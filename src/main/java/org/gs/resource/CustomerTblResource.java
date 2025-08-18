package org.gs.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.gs.entity.CustomerTbl;
import org.gs.service.CustomerTblService;
import org.gs.util.constants.APIPaths;
import org.gs.util.constants.Msgs;

import java.util.List;

@Path(APIPaths.CUSTOMERS)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerTblResource {

    private final CustomerTblService customerService;

    public CustomerTblResource(CustomerTblService customerService) {
        this.customerService = customerService;
    }

    @POST
    public Response add(CustomerTbl customer) {
        boolean created = customerService.add(customer);
        if (created) {
            return Response.status(Response.Status.CREATED)
                    .entity(new org.gs.dto.Response(Msgs.CUSTOMER_CREATED_SUCCESS)).build();
        }
        return Response.status(Response.Status.CONFLICT)
                .entity(new org.gs.dto.Response(Msgs.CUSTOMER_REFERENCE_EXISTS)).build();
    }

    @PUT
    public Response update(CustomerTbl customer) {
        boolean updated = customerService.update(customer);
        if (updated) {
            return Response.ok(new org.gs.dto.Response(Msgs.CUSTOMER_UPDATED_SUCCESS)).build();
        }
        return Response.status(Response.Status.NOT_FOUND)
                .entity(new org.gs.dto.Response(Msgs.CUSTOMER_NOT_FOUND)).build();
    }

    @GET
    @Path(APIPaths.SEARCH_BY_NAME+"{txtName}")
    public Response searchByName(@PathParam("txtName") String txtName) {
        List<CustomerTbl> results = customerService.searchByTxtName(txtName);
        return Response.ok(results).build();
    }

    @GET
    @Path(APIPaths.SEARCH_BY_KEY+"{txtReferences}")
    public Response searchByKey(@PathParam("txtReferences") String txtReferences) {
        List<CustomerTbl> customer = customerService.searchByTxtRefrences(txtReferences);
        if (customer == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new org.gs.dto.Response(Msgs.CUSTOMER_NOT_FOUND)).build();
        }
        return Response.ok(customer).build();
    }

    @GET
    @Path(APIPaths.GENERAL_SEARCH)
    public Response searchByGeneralInput(@QueryParam("generalInput") String generalInput,
                                         @QueryParam("limit") @DefaultValue("10") int limit,
                                         @QueryParam("page") @DefaultValue("1") int page) {
        List<CustomerTbl> customer = customerService.search(generalInput, limit, page);
        if (customer == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new org.gs.dto.Response(Msgs.CUSTOMER_NOT_FOUND)).build();
        }
        return Response.ok(customer).build();
    }

    @GET
    public Response listAll(@QueryParam("limit") @DefaultValue("50") int limit,
                            @QueryParam("page") @DefaultValue("1") int page) {
        List<CustomerTbl> customers = customerService.listAll(limit, page);
        return Response.ok(customers).build();
    }
}
