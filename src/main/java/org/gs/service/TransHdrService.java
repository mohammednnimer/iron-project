package org.gs.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.gs.dto.TransactionFiltering;
import org.gs.dto.Transactions;
import org.gs.entity.TranshdrTbl;
import org.gs.mapper.TransactionMapper;
import org.gs.repository.TranshdrTblRepo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TransHdrService {


    @Inject
    TranshdrTblRepo transhdrTblRepo;
    public List<Transactions> getALl(int limit, int page)
    {
        List<TranshdrTbl> transhdrTbls=transhdrTblRepo.findAll(limit,page);
        List<Transactions> transResponses=new ArrayList<>();
        for(TranshdrTbl transhdrTbl:transhdrTbls )
        {
            transResponses.add(TransactionMapper.toTrans(transhdrTbl));
        }
        return transResponses;
    }


    public List<Transactions> getTransaction(TransactionFiltering transactionFiltering,int page,int limit)
    {
        List<TranshdrTbl> transhdrTbls=transhdrTblRepo.findFiltering(limit,page,transactionFiltering);
        List<Transactions> transResponses=new ArrayList<>();
        for(TranshdrTbl transhdrTbl:transhdrTbls )
        {
            transResponses.add(TransactionMapper.toTrans(transhdrTbl));
        }
        return transResponses;
    }


    @Transactional
    public boolean updateStatus(int Vouchernum, int status) {
        if (status < 0 || status > 3) {
            throw new IllegalArgumentException("Invalid status: must be between 0 and 3");
        }

      TranshdrTbl transhdrTbl=  transhdrTblRepo.updateStatus(Vouchernum, status);

        if (transhdrTbl == null) {

            return false;
        }
        System.out.println("12121");
        transhdrTbl.setIntStatus(BigDecimal.valueOf(status));
        transhdrTblRepo.persist(transhdrTbl);
        return true;

    }
}
