package org.gs.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.gs.dto.DocumentDto;
import org.gs.dto.Documents;
import org.gs.entity.DocumentsTbl;
import org.gs.repository.DocumentsTblRepo;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class DocuemntService {

    @Inject
    DocumentsTblRepo documentTest;

    @Transactional
    public boolean insert(Documents documents)
    {

        for(DocumentDto documentsDto: documents.getDocumentsTbls())
        {

                DocumentsTbl documentsTbl = new DocumentsTbl();
           // Document_test documentsTbl=new Document_test();
            documentsTbl.setTxtKey(UUID.randomUUID().toString());
            documentsTbl.setDatCreationdate(Instant.now());
            documentsTbl.setImgImage(documentsDto.getImgImage());
            documentsTbl.setTxtFilename(documentsDto.getTxtFilename());
            documentsTbl.setTxtHdrkey(documentsDto.getTxtHdr());
            documentsTbl.setTxtDescription(documentsDto.getTxtDescription());
            try{
                documentTest.persist(documentsTbl);
            }catch (Exception e)
            {
                return false;
            }

        }
        return true;
    }

    public Integer NumberofRecords() {
        return documentTest.listAll().size();
    }


    public List<DocumentsTbl> searchByTxtHdr(String txthdr) {

        return documentTest.findBytxtHdr(txthdr);

    }


}

