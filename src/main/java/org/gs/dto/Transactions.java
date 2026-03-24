package org.gs.dto;

import java.math.BigDecimal;

public class Transactions {
    private BigDecimal vouchernum;

    private String reference;
    private String date;
    private String custName;
    private BigDecimal status;
    private BigDecimal totalweight;
    private String User;

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public BigDecimal getVouchernum() {
        return vouchernum;
    }

    public void setVouchernum(BigDecimal vouchernum) {
        this.vouchernum = vouchernum;
    }
    public String getReference() {
        return reference;
    }


    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public BigDecimal getStatus() {
        return status;
    }

    public void setStatus(BigDecimal status) {
        this.status = status;
    }

    public BigDecimal getTotalweight() {
        return totalweight;
    }

    public void setTotalweight(BigDecimal totalweight) {
        this.totalweight = totalweight;
    }

}
