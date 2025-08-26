package org.gs.dto;


import org.gs.entity.TransdtlshapesTbl;
import org.gs.entity.TranshdrTbl;
import org.gs.entity.TransdtlTbl;

import java.util.List;

public class TransactionRequest {
    private TranshdrTbl header;
    private List<Trans> transactions;


    public List<Trans> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Trans> transactions) {
        this.transactions = transactions;
    }

    public TranshdrTbl getHeader() {
        return header;
    }

    public void setHeader(TranshdrTbl header) {
        this.header = header;
    }


}
