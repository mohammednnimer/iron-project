package org.gs.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.gs.dto.*;
import org.gs.reports.ReprotService;
import org.gs.service.IronCalculator;
import org.gs.service.TransHdrService;
import org.gs.service.TransactionService;

@Path("/transaction")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TransactionResource {

    @Inject
    TransactionService transactionServicel;

    @Inject
    TransHdrService transHdrService;

    @Inject
    ReprotService reprotService;

    @POST
    public Response create(TransactionRequest transactionRequest)
    {

   transactionServicel.createTransaction(transactionRequest);

        reprotService.documentsReport(transactionRequest);
        return Response.ok().build();

    }


    @GET
    @Path("getTransactionByOrderNumber")
    public Response getTransaction(@QueryParam("orderNumber")  int orderNumber )
    {


        return Response.ok().entity(transHdrService.getTransaction(orderNumber)).build();


    }

    @POST
    @Path("/search")
    public Response getTransaction(@QueryParam("limit") @DefaultValue("50") int limit ,@QueryParam("page")@DefaultValue("1") int page,TransactionFiltering transactionFiltering)
    {
        return  Response.ok().entity(transHdrService.getTransaction(transactionFiltering,page,limit)).build();
    }

    @GET
    public Response getAll(@QueryParam("limit") @DefaultValue("50") int limit ,@QueryParam("page")@DefaultValue("1") int page)
    {

        return  Response.ok(transHdrService.getALl(limit,page)).build();
    }

    @Path("/calculate")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public IronCalculationResult calculate(IronCalculationRequest request) {
        IronCalculator calculator = new IronCalculator();
        return calculator.calc(request);
    }
    @PUT
    public Response updateStatus(StatusUpdateRequest request) {
        try {
            boolean updated = transHdrService.updateStatus(request.getVouchernum(), request.getStatus());
            if (!updated) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(new org.gs.dto.Response("Transaction not found for Vouchernum: "  + request.getVouchernum()))
                        .build();
            }
            return Response.ok(new org.gs.dto.Response("Status updated successfully")).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }




}
