package org.gs.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.gs.auth.session.SessionManager;
import org.gs.entity.CustomerTbl;
import org.gs.repository.CustomerTblRepo;
import org.gs.service.CustomerTblService;
import org.gs.util.constants.APIPaths;
import org.gs.util.constants.Msgs;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Path(APIPaths.CUSTOMERS)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerTblResource {

    private final CustomerTblService customerService;

    @Inject
    SessionManager sessionManager;

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
    @Path("/getByReference")
    public Response searchByKey(@QueryParam("txtReferences") String txtReferences) {
        CustomerTbl customer = customerService.searchByTxtRefrences(txtReferences);
        if (customer == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new org.gs.dto.Response(Msgs.CUSTOMER_NOT_FOUND)).build();
        }
        return Response.ok(customer).build();
    }

    @GET
    @Path("/numberOfRecords")
    public Response searchByKey() {

        return Response.ok().entity(new org.gs.dto.Response(customerService.NumberofRecords()+"")).build();
    }











    @Inject
    CustomerTblRepo customerRepo;


    @GET
    @Path("/search")
    public Response searchCustomer(@QueryParam("id") String id) {
        long startTime = System.currentTimeMillis();

        try {
            if (id == null || id.trim().isEmpty()) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("ID parameter is required")
                        .build();
            }

            System.out.println("Searching for customer with ID: " + id);
            CustomerTbl customerTbl = customerRepo.findById(id);
            System.out.println("Search completed");

            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;

            if (customerTbl == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Customer not found. Time taken: " + duration + " ms")
                        .build();
            }

            return Response.ok()
                    .entity(customerTbl.toString() + "\nTime taken: " + duration + " ms")
                    .build();

        } catch (Exception e) {
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;

            System.err.println("Error searching customer: " + e.getMessage());
            e.printStackTrace();

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error fetching customer: " + e.getMessage() +
                            ". Time taken: " + duration + " ms")
                    .build();
        }
    }


    @GET
    @Path("/add1000customer")
    public Response addUsers() {

        int batchSize = 500;
        int total = 1000000;

        for (int i = 0; i < total; i += batchSize) {
            List<CustomerTbl> batch = new ArrayList<>();
            for (int j = i; j < i + batchSize && j < total; j++) {
                CustomerTbl customer = new CustomerTbl();
                customer.setTxtKey(UUID.randomUUID().toString());
                customer.setTxtTag("TAG-123");
                customer.setTxtName("Dummy Name");
                customer.setTxtPhone1("111-222-333");
                customer.setTxtPhone2("444-555-666");
                customer.setTxtAddress("123 Dummy Street");
                customer.setTxtReference("REF-001");
                customer.setTxtTest("Test data");
                customer.setIntSystemtype(1);
                customer.setTxtEmail("dummy@example.com");
                batch.add(customer);
            }
            try {
                persistBatch(batch);
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        return Response.ok("Inserted 10,000 customers safely!").build();
    }

    @Transactional
    public void persistBatch(List<CustomerTbl> batch) {
        System.out.println("21212");
        customerRepo.persist(batch);
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


        System.out.println(sessionManager.getAttribute("user1"));
        List<CustomerTbl> customers = customerService.listAll(limit, page);
        return Response.ok(customers).build();
    }
    @DELETE
    @Path("/{txtReference}")
    public Response delete(@PathParam("txtReference") String txtReference) {
        boolean deleted = customerService.deleteByReference(txtReference);
        if (deleted) {
            return Response.ok(new org.gs.dto.Response(Msgs.DELETED_SUCCESS)).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new org.gs.dto.Response(Msgs.REFERENCE_NOT_FOUND)).build();
        }
    }
}
