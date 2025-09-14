package org.gs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "irondepth_tbl")
public class IrondepthTbl {
    @Id
    @Column(name = "txt_key", length = 60)
    private String txtKey;

    @Column(name = "txt_description")
    private String txtDescription;

    //, precision = 10, scale = 10
    @Column(name = "dbl_weight")
    private BigDecimal dblWeight;

    @Column(name = "txt_reference")
    private String txtReference;

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

    public BigDecimal getDblWeight() {
        return dblWeight;
    }

    public void setDblWeight(BigDecimal dblWeight) {
        this.dblWeight = dblWeight;
    }

    public String getTxtReference() {
        return txtReference;
    }

    public void setTxtReference(String txtReference) {
        this.txtReference = txtReference;
    }

    @Override
    public String toString() {
        return "IrondepthTbl{" +
                "txtKey='" + txtKey + '\'' +
                ", txtDescription='" + txtDescription + '\'' +
                ", dblWeight=" + dblWeight +
                ", txtReference='" + txtReference + '\'' +
                '}';
    }
}