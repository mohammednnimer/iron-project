package org.gs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "ironprices_tbl")
public class IronpricesTbl {
    @Id
    @Column(name = "txt_key", length = 60)
    private String txtKey;

    @Column(name = "txt_custkey", length = 60)
    private String txtCustkey;

    @Column(name = "txt_irontypekey", length = 60)
    private String txtIrontypekey;

    @Column(name = "txt_irontypename", length = 200)
    private String txtIrontypename;

    @Column(name = "dbl_price", precision = 10, scale = 5)
    private BigDecimal dblPrice;

    @Column(name = "dat_date")
    private Instant datDate;

    public String getTxtKey() {
        return txtKey;
    }

    public void setTxtKey(String txtKey) {
        this.txtKey = txtKey;
    }

    public String getTxtCustkey() {
        return txtCustkey;
    }

    public void setTxtCustkey(String txtCustkey) {
        this.txtCustkey = txtCustkey;
    }

    public String getTxtIrontypekey() {
        return txtIrontypekey;
    }

    public void setTxtIrontypekey(String txtIrontypekey) {
        this.txtIrontypekey = txtIrontypekey;
    }

    public String getTxtIrontypename() {
        return txtIrontypename;
    }

    public void setTxtIrontypename(String txtIrontypename) {
        this.txtIrontypename = txtIrontypename;
    }

    public BigDecimal getDblPrice() {
        return dblPrice;
    }

    public void setDblPrice(BigDecimal dblPrice) {
        this.dblPrice = dblPrice;
    }

    public Instant getDatDate() {
        return datDate;
    }

    public void setDatDate(Instant datDate) {
        this.datDate = datDate;
    }

    @Override
    public String toString() {
        return "IronpricesTbl{" +
                "txtKey='" + txtKey + '\'' +
                ", txtCustkey='" + txtCustkey + '\'' +
                ", txtIrontypekey='" + txtIrontypekey + '\'' +
                ", txtIrontypename='" + txtIrontypename + '\'' +
                ", dblPrice=" + dblPrice +
                ", datDate=" + datDate +
                '}';
    }
}