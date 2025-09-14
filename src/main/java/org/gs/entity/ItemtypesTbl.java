package org.gs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "itemtypes_tbl")
public class ItemtypesTbl {
    @Id
    @Column(name = "txt_key", length = 60)
    private String txtKey;

    @Column(name = "txt_description", length = 300)
    private String txtDescription;

    @Column(name = "dbl_price")
    private BigDecimal dblPrice;

    @Column(name = "txt_reference", length = 30)
    private String txtReference;

    @Column(name = "int_systemtype")
    private BigDecimal intSystemtype;

    public String getTxtKey() {
        return txtKey;
    }

    public void setTxtKey(String txtKey) {
        this.txtKey = txtKey;
    }

    public String getTxtDescription() {
        return txtDescription;
    }

    public void setTxtDescription(String txtDescription) {
        this.txtDescription = txtDescription;
    }

    public BigDecimal getDblPrice() {
        return dblPrice;
    }

    public void setDblPrice(BigDecimal dblPrice) {
        this.dblPrice = dblPrice;
    }

    public String getTxtReference() {
        return txtReference;
    }

    public void setTxtReference(String txtReference) {
        this.txtReference = txtReference;
    }

    public BigDecimal getIntSystemtype() {
        return intSystemtype;
    }

    public void setIntSystemtype(BigDecimal intSystemtype) {
        this.intSystemtype = intSystemtype;
    }

}