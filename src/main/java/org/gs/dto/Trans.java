package org.gs.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.math.BigDecimal;

public class Trans {


    Transshapes transshapes;


     private String txtStockcode;

     private String txtIrontype;


    private BigDecimal dblIronlength;

    private BigDecimal dblQty;

    private BigDecimal dblPrice;

    private BigDecimal dblTotal;

    private String txtReference;

    private BigDecimal dblTotalweight;

     private String txtItemKey;


    private String txtIrondepthkey;

    private BigDecimal intType;

    public Transshapes getTransshapes() {
        return transshapes;
    }

    public void setTransshapes(Transshapes transshapes) {
        this.transshapes = transshapes;
    }

    public String getTxtStockcode() {
        return txtStockcode;
    }

    public void setTxtStockcode(String txtStockcode) {
        this.txtStockcode = txtStockcode;
    }

    public String getTxtIrontype() {
        return txtIrontype;
    }

    public void setTxtIrontype(String txtIrontype) {
        this.txtIrontype = txtIrontype;
    }

    public BigDecimal getDblIronlength() {
        return dblIronlength;
    }

    public void setDblIronlength(BigDecimal dblIronlength) {
        this.dblIronlength = dblIronlength;
    }

    public BigDecimal getDblQty() {
        return dblQty;
    }

    public void setDblQty(BigDecimal dblQty) {
        this.dblQty = dblQty;
    }

    public BigDecimal getDblPrice() {
        return dblPrice;
    }

    public void setDblPrice(BigDecimal dblPrice) {
        this.dblPrice = dblPrice;
    }

    public BigDecimal getDblTotal() {
        return dblTotal;
    }

    public void setDblTotal(BigDecimal dblTotal) {
        this.dblTotal = dblTotal;
    }

    public String getTxtReference() {
        return txtReference;
    }

    public void setTxtReference(String txtReference) {
        this.txtReference = txtReference;
    }

    public BigDecimal getDblTotalweight() {
        return dblTotalweight;
    }

    public void setDblTotalweight(BigDecimal dblTotalweight) {
        this.dblTotalweight = dblTotalweight;
    }

    public String getTxtItemKey() {
        return txtItemKey;
    }

    public void setTxtItemKey(String txtItemKey) {
        this.txtItemKey = txtItemKey;
    }

    public String getTxtIrondepthkey() {
        return txtIrondepthkey;
    }

    public void setTxtIrondepthkey(String txtIrondepthkey) {
        this.txtIrondepthkey = txtIrondepthkey;
    }

    public BigDecimal getIntType() {
        return intType;
    }

    public void setIntType(BigDecimal intType) {
        this.intType = intType;
    }
}
