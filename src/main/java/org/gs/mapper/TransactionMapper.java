package org.gs.mapper;

import jakarta.inject.Inject;
import org.gs.dto.Transactions;
import org.gs.entity.TranshdrTbl;
import org.gs.repository.CustomerTblRepo;

public class TransactionMapper {


    @Inject
    CustomerTblRepo customerTblRepo;

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
}
