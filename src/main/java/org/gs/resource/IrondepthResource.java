package org.gs.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.gs.entity.IrondepthTbl;
import org.gs.service.IrondepthService;
import org.gs.util.constants.APIPaths;
import org.gs.util.constants.Msgs;

import java.util.List;

@Path(APIPaths.IRON_DEPTH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class IrondepthResource {

    @Inject
    IrondepthService irondepthService;

    @POST
    public Response create(IrondepthTbl iron) {
        boolean created = irondepthService.create(iron);
        if (created) {
            return Response.status(Response.Status.CREATED).entity(iron).build();
        } else {
            return Response.status(Response.Status.CONFLICT)
                    .entity(new org.gs.dto.Response(Msgs.REFERENCE_EXISTS)).build();
        }
    }

    @GET
    public Response getAll(@QueryParam("limit") @DefaultValue("50") int limit,
                           @QueryParam("page") @DefaultValue("1") int page) {
        List<IrondepthTbl> list = irondepthService.getAll(limit, page);
        return Response.ok(list).build();
    }

    @GET
    @Path(APIPaths.GENERAL_SEARCH)
    public Response searchByGeneralInput(@QueryParam("generalInput") String generalInput,
                                         @QueryParam("limit") @DefaultValue("50") int limit,
                                         @QueryParam("page") @DefaultValue("1") int page) {
        List<IrondepthTbl> customer = irondepthService.search(generalInput, limit, page);
        if (customer == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new org.gs.dto.Response(Msgs.CUSTOMER_NOT_FOUND)).build();
        }
        return Response.ok(customer).build();
    }

    @GET
    @Path("/{txtReference}")
    public Response getByReference(@PathParam("txtReference") String txtReference) {
        List<IrondepthTbl> iron = irondepthService.getByReference(txtReference);
        if (iron == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new org.gs.dto.Response(Msgs.NOT_FOUND)).build();
        }
        return Response.ok(iron).build();
    }

    @PUT
    public Response update(IrondepthTbl iron) {
        boolean updated = irondepthService.updateByReference(iron);
        if (updated) {
            return Response.ok(iron).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new org.gs.dto.Response(Msgs.REFERENCE_NOT_FOUND)).build();
        }
    }
}
