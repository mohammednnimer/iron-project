package org.gs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "dtransdtl_tbl")
public class DtransdtlTbl {
   @Id
    @Column(name = "txt_key", length = 60)
    private String txtKey;

    @Column(name = "txt_hdrkey", length = 60)
    private String txtHdrkey;

    @Column(name = "txt_stockcode", length = 60)
    private String txtStockcode;

    @Column(name = "dbl_qty", precision = 10, scale = 5)
    private BigDecimal dblQty;

    @Column(name = "txt_unit", length = 30)
    private String txtUnit;

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

    public BigDecimal getDblQty() {
        return dblQty;
    }

    public void setDblQty(BigDecimal dblQty) {
        this.dblQty = dblQty;
    }

    public String getTxtUnit() {
        return txtUnit;
    }

    public void setTxtUnit(String txtUnit) {
        this.txtUnit = txtUnit;
    }

}