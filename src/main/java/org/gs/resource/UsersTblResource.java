package org.gs.resource;

import io.smallrye.openapi.internal.models.AbstractPathItem;
import io.vertx.ext.web.Session;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.gs.auth.session.SessionManager;
import org.gs.dto.UpdatePassword;
import org.gs.dto.UpdatePasswordByAdmin;
import org.gs.entity.UsersTbl;
import org.gs.service.UsersTblService;
import org.gs.util.constants.APIPaths;
import org.gs.util.constants.Msgs;

import java.math.BigDecimal;
import java.util.List;

@Path(APIPaths.USERS)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsersTblResource {

    @Inject
    UsersTblService usersTblService;





    @GET
    public Response getAlluser(@QueryParam("limit") @DefaultValue("50") int limit ,@QueryParam("page")@DefaultValue("1") int page)
    {
        return  Response.ok(usersTblService.getALlUser(limit,page)).build();
    }
    @GET
    @Path("/searchByName")
    public Response SearchByName(@QueryParam("limit") @DefaultValue("50") int limit ,@QueryParam("page")@DefaultValue("1") int page,@QueryParam("username")  String name )
    {

        return  Response.ok(usersTblService.Search(name,limit,page)).build();
    }

     @POST
    public Response createUser(UserRequest request) {
        boolean created = usersTblService.create(request.name, request.password, request.level);
        if (!created) {
            return Response.status(Response.Status.CONFLICT)
                    .entity(new org.gs.dto.Response(Msgs.USERNAME_EXIST))
                    .build();
        }
        return Response.status(Response.Status.CREATED)
                .entity(new org.gs.dto.Response(Msgs.USER_SUCC))
                .build();
    }

    @PUT
    @Path(APIPaths.UPDATE_PASSWORD)
    public Response updatePassword(UpdatePassword dto) {
        String result = usersTblService.updatePassword(dto);
        if (result.toLowerCase().contains("succeeded")) {
            return Response.ok(new org.gs.dto.Response(result)).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity(new org.gs.dto.Response(result)).build();
    }
    @PUT
    @Path(APIPaths.UPDATE_PASSWORD_BY_ADMIN)
    public Response updatePasswordbyAdmin(UpdatePasswordByAdmin dto) {
        String result = usersTblService.updatePasswordByAdmin(dto);
        if (result.toLowerCase().contains("succeeded")) {
            return Response.ok(new org.gs.dto.Response(result)).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity(new org.gs.dto.Response(result)).build();
    }
    @PUT
    @Path(APIPaths.UPDATER_Role)
public Response updateRole(@QueryParam("userName")  String username ,@QueryParam("newRole")  BigDecimal newRole) {
        String result = usersTblService.updateRole(username,newRole);
        if (result.toLowerCase().contains("succeeded")) {
            return Response.ok(new org.gs.dto.Response(result)).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity(new org.gs.dto.Response(result)).build();
    }





    @DELETE
    public Response deleteUser(@QueryParam("username") String username) {
        if(usersTblService.delete(username)){
            return Response.ok(new org.gs.dto.Response(Msgs.USER_DELETED)).build();
        }
        return Response.ok(new org.gs.dto.Response(Msgs.USER_NOT_FOUND)).build();
    }






//    @POST
//    @Path("/login")
//    public Response login(LoginRequest request) {
//        UsersTbl user = usersTblService.findByUsernameAndPassword(request.username, request.password);
//        if (user == null) {
//            return Response.status(Response.Status.UNAUTHORIZED).entity(new org.gs.dto.Response("Invalid username or password")).build();
//        }
//        return Response.ok(user).build();
//    }

    public static class UserRequest {
        public String name;
        public String password;
        public BigDecimal level;
    }

    public static class LoginRequest {
        public String username;
        public String password;
    }
}
