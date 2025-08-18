package org.gs.auth.filters;

import io.vertx.core.http.HttpServerRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;
import org.gs.entity.Logs;
import org.gs.repository.LogsRepo;
import org.gs.util.constants.ErrorCodes;
import org.gs.util.constants.Msgs;
import org.gs.exception.UnAuthRequestException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

@Provider
@ApplicationScoped
public class AuthenticationFilter implements ContainerRequestFilter, ContainerResponseFilter {

    private static final Logger logger = Logger.getLogger(AuthenticationFilter.class.getName());
    private static final String LOG_OBJECT_PROPERTY = "logObject";
    private static final String REQUEST_START_TIME = "requestStartTime";

    @Inject
    FilterMethods filterMethods;
    @Inject
    HttpServerRequest httpRequest;

    @Inject
    LogsRepo logsRepo;

    @Override
    public void filter(ContainerRequestContext requestContext) {
        long startTime = System.currentTimeMillis();
        requestContext.setProperty(REQUEST_START_TIME, startTime);

        Logs logs = createLogEntry(requestContext);
        requestContext.setProperty(LOG_OBJECT_PROPERTY, logs);

//        String authorizationHeader = requestContext.getHeaderString("Authorization");
//        String path = requestContext.getUriInfo().getPath();
//        boolean isPathPublic = filterMethods.isPathPublic(path);
//
//        String jwt = extractJwtToken(authorizationHeader);
        //filterMethods.isTokenValid(jwt, isPathPublic);
        boolean isTokenValid = true;

        if (!isTokenValid) {
            throw new UnAuthRequestException(Msgs.INVALID_TOKEN, ErrorCodes.INVALID_TOKEN_CODE);
        }
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
        Logs logs = (Logs) requestContext.getProperty(LOG_OBJECT_PROPERTY);
        Long startTime = (Long) requestContext.getProperty(REQUEST_START_TIME);

        if (logs != null) {
            long responseTime = startTime != null ? System.currentTimeMillis() - startTime : 0;
            logs.setStatusCode(String.valueOf(responseContext.getStatus()));
            logs.setResponseBody(getResponseBody(responseContext));
            System.out.println(LocalDateTime.now());
            logs.setResponseTime(LocalDateTime.now());
             saveLogAsync(logs);
        }
    }

    private Logs createLogEntry(ContainerRequestContext requestContext) {
        Logs logs = new Logs();
        logs.setId(UUID.randomUUID().toString().substring(0,30));
        logs.setIp(getClientIp(requestContext));
        logs.setApi(requestContext.getUriInfo().getPath());
        logs.setRequestBody(getRequestBody(requestContext));
        return logs;
    }

    private String getRequestBody(ContainerRequestContext requestContext) {
        try {
            InputStream inputStream = requestContext.getEntityStream();
            if (inputStream != null) {
               String body = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
                requestContext.setEntityStream(new ByteArrayInputStream(body.getBytes(StandardCharsets.UTF_8)));
                return body;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String extractJwtToken(String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.substring(7);
        }
        return "";
    }

    private String getClientIp(ContainerRequestContext requestContext) {
        String xForwardedFor = requestContext.getHeaderString("X-Forwarded-For");
        if (xForwardedFor != null && !xForwardedFor.isEmpty()) {
            return xForwardedFor.split(",")[0].trim();
        }

        String xRealIp = requestContext.getHeaderString("X-Real-IP");
        if (xRealIp != null && !xRealIp.isEmpty()) {
            return xRealIp;
        }

         return httpRequest.remoteAddress().host();
    }



    private String getResponseBody(ContainerResponseContext responseContext) {
        Object entity = responseContext.getEntity();
        if (entity != null) {
            String responseBody = entity.toString();
            return responseBody.length() > 1000 ?
                    responseBody.substring(0, 1000) + "..." : responseBody;
        }
        return "";
    }

    private void saveLogAsync(Logs logs) {
        CompletableFuture.runAsync(() -> {
            try {
                persistLog(logs);
            } catch (Exception e) {
                logger.severe("Failed to save log entry: " + e.getMessage());
           }
        });
    }

    @Transactional
    public void persistLog(Logs logs) {
         logsRepo.persist(logs);
    }
}