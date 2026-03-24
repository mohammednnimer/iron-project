package org.gs.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.gs.entity.IrontypesTbl;
import org.gs.entity.ItemtypesTbl;
import org.gs.service.ItemTypeService;
import org.gs.util.constants.Msgs;

import java.math.BigDecimal;
import java.util.List;

@Path("/itemTypes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemTypeResource {

    @Inject
    ItemTypeService service;


    @GET
    @Path("/numberOfRecords")
    public Response searchByKey() {

        return Response.ok().entity(new org.gs.dto.Response(service.NumberofRecords()+"")).build();
    }

    @POST
    public Response create(@Valid ItemtypesTbl item) {
        boolean saved = service.create(item);
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

    @DELETE
    @Path("/{reference}")
    public Response delete(@PathParam("reference") String reference) {
        boolean deleted = service.deleteByReference(reference);
        if (deleted) {
            return Response.ok(new org.gs.dto.Response(Msgs.DELETED_SUCCESS)).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new org.gs.dto.Response(Msgs.REFERENCE_NOT_FOUND)).build();
        }
    }

    @PUT
    public Response update( ItemtypesTbl updated) {
        if (service.updatebyrefrences(updated)) {
            return Response.ok().entity(new org.gs.dto.Response(Msgs.OK)).build();
        }
        return Response.status(Response.Status.NOT_FOUND)
                .entity(new org.gs.dto.Response(Msgs.NOT_FOUND))
                .build();
    }

    @GET
    public Response listAll(@QueryParam("limit") @DefaultValue("50") int limit,
                            @QueryParam("page") @DefaultValue("1") int page) {
        List<ItemtypesTbl> result = service.listAll(limit, page);
        return Response.ok(result).build();
    }

     @GET
    @Path("/getByReference")
    public Response searchByReferences(@QueryParam("reference") String txtKey) {
         ItemtypesTbl iron = service.searchByrefrences(txtKey);
         if (iron == null) {
             return Response.status(Response.Status.NOT_FOUND)
                     .entity(new org.gs.dto.Response(Msgs.NOT_FOUND))
                     .build();
         }
         return Response.ok(iron).build();
     }

    @GET
    @Path("/getByKey")
    public Response searchByKey(@QueryParam("txtKey") String txtKey) {
        ItemtypesTbl itemtypesTbl = service.searchByTxtKey(txtKey);
        if (itemtypesTbl == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new org.gs.dto.Response(Msgs.CUSTOMER_NOT_FOUND)).build();
        }
        return Response.ok(itemtypesTbl).build();
    }

    @GET
    @Path("/generalSearch")
    public Response search(@QueryParam("generalSearch") String query,
                           @QueryParam("limit") @DefaultValue("50") int limit,
                           @QueryParam("page") @DefaultValue("1") int page) {
        List<ItemtypesTbl> result = service.search(query, limit, page);
        return Response.ok(result).build();
    }

    @GET
    @Path("/search/price")
    public Response searchByPrice(@QueryParam("from") @DefaultValue("0") BigDecimal from,
                                  @QueryParam("to") @DefaultValue("1000") BigDecimal to,
                                  @QueryParam("limit") @DefaultValue("50") int limit,
                                  @QueryParam("page") @DefaultValue("1") int page) {
        List<ItemtypesTbl> result = service.searchbyPrice(from, to, limit, page);
        return Response.ok(result).build();
    }
}
