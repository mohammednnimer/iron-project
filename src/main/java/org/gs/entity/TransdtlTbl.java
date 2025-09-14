package org.gs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "transdtl_tbl")
    public class TransdtlTbl {
    @Id
    @Column(name = "txt_key", length = 60)
    private String txtKey;

    @Column(name = "txt_hdrkey", length = 60)
    private String txtHdrkey;

        @Column(name = "txt_stockcode", length = 60)
        private String txtStockcode;

    @Column(name = "txt_irontype", length = 60)
    private String txtIrontype;



    @Column(name = "dbl_ironlength")
    private BigDecimal dblIronlength;

    @Column(name = "dbl_qty")
    private BigDecimal dblQty;

    @Column(name = "dbl_price")
    private BigDecimal dblPrice;

    @Column(name = "dbl_total")
    private BigDecimal dblTotal;

    @Column(name = "txt_reference", length = 30)
    private String txtReference;

    @Column(name = "dbl_totalweight")
    private BigDecimal dblTotalweight;

    @Column(name = "txt_irondepthley", length = 60)
    private String txtIrondepthley;

    @Column(name = "txt_irondepthkey", length = 60)
    private String txtIrondepthkey;

    @Column(name = "int_type")
    private BigDecimal intType;

    public String getTxtKey() {
        return txtKey;
    }

    public void setTxtKey(String txtKey) {
        this.txtKey = txtKey;
    }

    public String getTxtHdrkey() {
        return txtHdrkey;
    }

    public void setTxtHdrkey(String txtHdrkey) {
        this.txtHdrkey = txtHdrkey;
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

    public String getTxtIrondepthley() {
        return txtIrondepthley;
    }

    public void setTxtIrondepthley(String txtIrondepthley) {
        this.txtIrondepthley = txtIrondepthley;
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