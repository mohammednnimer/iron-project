package org.gs.mapper;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.gs.dto.Trans;
import org.gs.dto.Transactions;
import org.gs.dto.Transshapes;
import org.gs.entity.TransdtlTbl;
import org.gs.entity.TransdtlshapesTbl;
import org.gs.entity.TranshdrTbl;
import org.gs.repository.CustomerTblRepo;
import org.gs.repository.TransdtlshapesTblRepo;

@ApplicationScoped
public class TransactionMapper {


    @Inject
    CustomerTblRepo customerTblRepo;

    @Inject
    TransdtlshapesTblRepo transdtlshapesTblRepo;


    public static Transactions toTrans(TranshdrTbl transhdrTbl)
    {

        Transactions transactions=new Transactions();
        transactions.setDate(transhdrTbl.getDatDate()+"");
        if(transhdrTbl.getTxtReference()!=null)
        {
            transactions.setReference(transhdrTbl.getTxtReference());
        }
        transactions.setCustName(transhdrTbl.getTxtCustname());

        transactions.setStatus(transhdrTbl.getIntStatus());
        transactions.setTotalweight(transhdrTbl.getDblTotal());
        transactions.setUser(transhdrTbl.getTxtUsercode());
        transactions.setVouchernum(transhdrTbl.getIntVouchernum());
        return transactions;

    }
    public  Trans toDto(TransdtlTbl entity) {
        if (entity == null) {
            return null;
        }
        Trans dto = new Trans();
        dto.setTxtStockcode(entity.getTxtStockcode());
        dto.setTxtIrontype(entity.getTxtIrontype());
        dto.setDblIronlength(entity.getDblIronlength());
        dto.setDblQty(entity.getDblQty());
        dto.setDblPrice(entity.getDblPrice());
        dto.setDblTotal(entity.getDblTotal());
        dto.setTxtReference(entity.getTxtReference());
        dto.setDblTotalweight(entity.getDblTotalweight());
        dto.setTxtIrondepthkey(entity.getTxtIrondepthkey());
        dto.setIntType(entity.getIntType());
        TransdtlshapesTbl transdtlshapesTbl =transdtlshapesTblRepo.findBytransKey(entity.getTxtKey());
        if(transdtlshapesTbl!=null)
        {dto.setTransshapes(toTransShapesDto(transdtlshapesTbl));}
        return dto;
    }

    public  Transshapes toTransShapesDto(TransdtlshapesTbl transhdrTbl)
    {   Transshapes transshapes=new Transshapes();
        transshapes.setDblTotlength(transhdrTbl.getDblTotlength());
        transshapes.setIntSides(transhdrTbl.getIntSides());
        transshapes.setTxt_side_list(transhdrTbl.getTxtSideslist());
        transshapes.setTxtShapekey(transhdrTbl.getTxtShapekey());
        return transshapes;
    }

}
