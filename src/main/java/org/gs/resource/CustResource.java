//package org.gs.resource;
//
//import jakarta.ws.rs.*;
//import jakarta.ws.rs.core.MediaType;
//import jakarta.ws.rs.core.Response;
//import org.gs.entity.Cust;
//import org.gs.service.CustService;
//
//import java.util.List;
//
//@Path("/cust")
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
//public class CustResource {
//
//    private final CustService custService;
//
//    public CustResource(CustService custService) {
//        this.custService = custService;
//    }
//
//    @POST
//    public Response createCust(Cust cust) {
//        boolean created = custService.create(cust);
//        if (created) {
//            return Response.status(Response.Status.CREATED)
//                    .entity(new org.gs.dto.Response("Customer created successfully"))
//                    .build();
//        }
//        return Response.status(Response.Status.CONFLICT)
//                .entity(new org.gs.dto.Response("Customer with this reference already exists")).build();
//    }
//    @PUT
//    public Response updateCust(Cust cust) {
//        boolean updated = custService.update(cust);
//        if (updated) {
//            return Response.ok(new org.gs.dto.Response("Customer updated successfully")).build();
//        }
//        return Response.status(Response.Status.NOT_FOUND)
//                .entity( new org.gs.dto.Response("Customer not found"))
//                .build();
//    }
//    @GET
//    @Path("/{reference}")
//    public Response searchByReference(@PathParam("reference") String reference) {
//
//       Cust customer = custService.searchByReference(reference);
//        if (customer == null) {
//            return Response.status(Response.Status.NOT_FOUND)
//                    .entity(new org.gs.dto.Response( "Customer not found"))
//                    .build();
//        }
//        return Response.ok(customer).build();
//    }
//    @GET
//    public Response listAll(@QueryParam("limit") @DefaultValue("50") int limit ,@QueryParam("page")@DefaultValue("1") int page) {
//        List<Cust> customers = custService.listAll(limit,page);
//        return Response.ok(customers).build();
//    }
//
//
//
//}