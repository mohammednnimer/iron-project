package org.gs.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.gs.dto.IronTypes;
import org.gs.entity.IrontypesTbl;
import org.gs.service.IrontypesTblService;
import org.gs.util.constants.APIPaths;
import org.gs.util.constants.Msgs;

import java.math.BigDecimal;
import java.util.List;

@Path(APIPaths.IRON_TYPES)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class IrontypesTblResource {

    @Inject
    IrontypesTblService service;

    @POST
    public Response create(IrontypesTbl iron) {
        boolean saved = service.create(iron);
        if(saved) {
            return Response.status(Response.Status.CREATED)
                    .entity(new org.gs.dto.Response(Msgs.CREATED_SUCCESS))
                    .build();
        } else {
            return Response.status(Response.Status.CONFLICT)
                    .entity(new org.gs.dto.Response(Msgs.OBJECT_EXIST))
                    .build();
        }
    }

    @PUT
    public Response update(IronTypes iron) {
        if (service.updatebyrefrences(iron)) {
            return Response.ok().entity(new org.gs.dto.Response(Msgs.OK)).build();
        }
        return Response.status(Response.Status.NOT_FOUND)
                .entity(new org.gs.dto.Response(Msgs.NOT_FOUND))
                .build();
    }

    @GET
    @Path(APIPaths.GENERAL_SEARCH)
    public Response searchByGeneralInput(@QueryParam("generalInput") String generalInput,
                                         @QueryParam("limit") @DefaultValue("10") int limit,
                                         @QueryParam("page") @DefaultValue("1") int page) {
        List<IrontypesTbl> customer = service.search(generalInput, limit, page);
        if (customer == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new org.gs.dto.Response(Msgs.CUSTOMER_NOT_FOUND))
                    .build();
        }
        return Response.ok(customer).build();
    }
    @GET
    @Path(APIPaths.BY_REFERENCE+"{txtReference}")
    public Response getByReference(@PathParam("txtReference") String txtReference) {
        List<IrontypesTbl> iron = service.searchByrefrences(txtReference);
        if (iron == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new org.gs.dto.Response(Msgs.NOT_FOUND))
                    .build();
        }
        return Response.ok(iron).build();
    }
    @GET
    public List<IrontypesTbl> listAll(@QueryParam("limit") @DefaultValue("50") int limit,
                                      @QueryParam("page") @DefaultValue("1") int page) {
        return service.listAll(limit, page);
    }
    @GET
    @Path("/findByPrice")
    public List<IrontypesTbl> listByPrice(@QueryParam("from") @DefaultValue("0") BigDecimal from,@QueryParam("to") @DefaultValue("100") BigDecimal to, @QueryParam("limit") @DefaultValue("50") int limit,
                                          @QueryParam("page") @DefaultValue("1") int page) {
        return service.searchbyPrice(from,to,limit, page);
    }

    @DELETE
    @Path("/{txtReference}")
    public Response delete(@PathParam("txtReference") String txtReference) {
        boolean deleted = service.deleteByReference(txtReference);
        if (deleted) {
            return Response.ok(new org.gs.dto.Response(Msgs.DELETED_SUCCESS)).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new org.gs.dto.Response(Msgs.REFERENCE_NOT_FOUND)).build();
        }
    }
}
