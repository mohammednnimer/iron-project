package org.gs.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.gs.dto.Documents;
import org.gs.entity.IrondepthTbl;
import org.gs.service.DocuemntService;
import org.gs.util.constants.APIPaths;
import org.gs.util.constants.Msgs;

@Path("/document")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DocumentResource {


    @Inject
    DocuemntService docService;
    @POST
    public Response insert(Documents documents) {
        boolean created = docService.insert(documents);
        if (created) {
            return Response.status(Response.Status.OK).build();
        } else {
            return Response.status(Response.Status.CONFLICT)
                    .entity(new org.gs.dto.Response(Msgs.REFERENCE_EXISTS)).build();
        }
    }
    @GET
    @Path("/numberOfRecords")
    public Response searchByKey() {

        return Response.ok().entity(new org.gs.dto.Response(docService.NumberofRecords()+"")).build();
    }

    @GET
    public Response getDocuments(@QueryParam("TxtHeader") String txthdr) {

        return Response.ok().entity(docService.searchByTxtHdr(txthdr)).build();



    }

}
