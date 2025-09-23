package org.gs.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.gs.entity.IrondepthTbl;
import org.gs.entity.IronshapesTbl;
import org.gs.service.IronshapesService;
import org.gs.util.constants.APIPaths;
import org.gs.util.constants.Msgs;

import java.util.List;

@Path(APIPaths.IRON_SHAPES)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class IronshapesResource {

    @Inject
    IronshapesService ironshapesService;

    @POST
    public Response create(IronshapesTbl iron) {


        boolean created = ironshapesService.create(iron);

        if (created) {
            return Response.status(Response.Status.CREATED).entity(iron).build();
        } else {
            return Response.status(Response.Status.CONFLICT)
                    .entity(new org.gs.dto.Response(Msgs.REFERENCE_EXISTS)).build();
        }
    }

    @GET
    @Path("/getImageByReference/{Reference}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getImageByReference(@PathParam("Reference") String reference) {

        return Response.ok().entity(ironshapesService.getImage(reference)).build();
    }

    @PUT
    public Response update(IronshapesTbl iron) {
        boolean updated = ironshapesService.updateByReference(iron);
        if (updated) {
            return Response.ok(new org.gs.dto.Response(Msgs.UPDATED_SUCCESS)).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new org.gs.dto.Response(Msgs.REFERENCE_NOT_FOUND)).build();
        }
    }

    @GET
    public List<IronshapesTbl> getAll(@QueryParam("limit") @DefaultValue("50") int limit,
                                      @QueryParam("page") @DefaultValue("1") int page) {
        return ironshapesService.getAll(limit, page);
    }

    @GET
    @Path("/getByReference")
    public Response getByReference(@QueryParam("txtReference") String txtReference) {
       IronshapesTbl iron = ironshapesService.getByReference(txtReference);
        if (iron != null) {
            return Response.ok(iron).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new org.gs.dto.Response(Msgs.NOT_FOUND)).build();
        }
    }

    @GET
    @Path("/getByKey")
    public Response searchByKey(@QueryParam("txtKey") String txtKey) {
        IronshapesTbl ironshapesTbl = ironshapesService.searchByTxtKey(txtKey);
        if (ironshapesTbl == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new org.gs.dto.Response(Msgs.CUSTOMER_NOT_FOUND)).build();
        }
        return Response.ok(ironshapesTbl).build();
    }


    @GET
    @Path("/numberOfRecords")
    public Response searchByKey() {

        return Response.ok().entity(new org.gs.dto.Response(ironshapesService.NumberofRecords()+"")).build();
    }
    @GET
    @Path(APIPaths.GENERAL_SEARCH)
    public Response searchByGeneralInput(@QueryParam("generalInput") String generalInput,
                                         @QueryParam("limit") @DefaultValue("50") int limit,
                                         @QueryParam("page") @DefaultValue("1") int page) {
        List<IronshapesTbl> customer = ironshapesService.search(generalInput, limit, page);
        if (customer == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new org.gs.dto.Response(Msgs.CUSTOMER_NOT_FOUND)).build();
        }
        return Response.ok(customer).build();
    }

    @DELETE
    @Path("/{txtReference}")
    public Response delete(@PathParam("txtReference") String txtReference) {
        boolean deleted = ironshapesService.deleteByReference(txtReference);
        if (deleted) {
            return Response.ok(new org.gs.dto.Response(Msgs.DELETED_SUCCESS)).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new org.gs.dto.Response(Msgs.REFERENCE_NOT_FOUND)).build();
        }
    }
}
