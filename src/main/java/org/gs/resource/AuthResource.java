package org.gs.resource;

import io.vertx.core.http.HttpServerRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.gs.repository.LogsRepo;
import org.gs.service.LogoutService;
import org.gs.util.constants.ErrorCodes;
import org.gs.util.constants.Msgs;
import org.gs.dto.LoginRequest;
import org.gs.dto.LoginResponse;
import org.gs.entity.UsersTbl;
import org.gs.service.LoginService;
import org.gs.util.JwtUtils;

import java.time.Instant;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class AuthResource {

    @Inject
    LoginService loginService;

    @Inject
    LogoutService logoutService;


    @Inject
    LogsRepo logsRepo;

    @Inject
    JwtUtils jwtUtils;

    @POST
    @Path("/login")
    @Transactional
    public Response login(@Valid LoginRequest request, @Context HttpServerRequest httpServerRequest) {

        if (request.getUsername() == null || request.getPassword() == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new LoginResponse(Msgs.INVALID_CREDENTIALS, ErrorCodes.INVALID_CREDENTIALS_CODE))
                    .build();
        }
        UsersTbl user = loginService.authenticate(request.getUsername().trim(), request.getPassword().trim());
        if (user == null) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity(new LoginResponse(Msgs.INVALID_CREDENTIALS, ErrorCodes.INVALID_CREDENTIALS_CODE))
                    .build();
        }

         String role = loginService.getUserRole(user.getIntLevel());

         String token;
        try {
            token = jwtUtils.generateToken(user.getTxtCode(), role);
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new LoginResponse(Msgs.TOKEN_GENERATION_FAILED, ErrorCodes.TOKEN_GENERATION_FAILED_CODE))
                    .build();
        }

        loginService.updateUserToken(user, token);

        String expiresAt = Instant.now().plusSeconds(172800).toString(); // 48 hours
        return Response.ok(new LoginResponse(token, expiresAt,Msgs.SUCCESS, role)).build();
    }

    @POST
    @Path("/logout")
    @Transactional
    public Response logout(@Context HttpServerRequest request) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"message\": \"No token provided\"}")
                    .build();
        }

        String token = authHeader.substring("Bearer ".length());
        if(logoutService.deletToken(token))
        {
            return Response.ok()
                    .entity("{\"message\": \"Logged out successfully\"}")
                    .build();}
        else{
            return Response.status(Response.Status.NOT_ACCEPTABLE)
                    .entity("{\"message\": \"Logged out Not successfully\"}")
                    .build();}
    }



    @GET
    @Path("getallogs")
    public Response getallt()
    {

       return Response.ok().entity(logsRepo.listAll()).build();

    }

}