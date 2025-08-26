package org.gs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "irontypes_tbl")
public class IrontypesTbl {
    @Id
    @Column(name = "txt_key", length = 60)
    private String txtKey;

    @Column(name = "txt_description", length = 300)
    private String txtDescription;

    @Column(name = "int_num", precision = 5)
    private BigDecimal intNum;

    @Column(name = "dbl_weightpergram", precision = 10, scale = 5)
    private BigDecimal dblWeightpergram;

    @Column(name = "txt_reference", length = 50)
    private String txtReference;

    @Column(name = "dbl_price", precision = 10, scale = 5)
    private BigDecimal dblPrice;



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

    public BigDecimal getIntNum() {
        return intNum;
    }

    public void setIntNum(BigDecimal intNum) {
        this.intNum = intNum;
    }

    public BigDecimal getDblWeightpergram() {
        return dblWeightpergram;
    }

    public void setDblWeightpergram(BigDecimal dblWeightpergram) {
        this.dblWeightpergram = dblWeightpergram;
    }

    public String getTxtReference() {
        return txtReference;
    }

    public void setTxtReference(String txtReference) {
        this.txtReference = txtReference;
    }

    public BigDecimal getDblPrice() {
        return dblPrice;
    }

    public void setDblPrice(BigDecimal dblPrice) {
        this.dblPrice = dblPrice;
    }

    @Override
    public String toString() {
        return "IrontypesTbl{" +
                "txtKey='" + txtKey + '\'' +
                ", txtDescription='" + txtDescription + '\'' +
                ", intNum=" + intNum +
                ", dblWeightpergram=" + dblWeightpergram +
                ", txtReference='" + txtReference + '\'' +
                ", dblPrice=" + dblPrice +
                '}';
    }
}