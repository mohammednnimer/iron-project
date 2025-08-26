package org.gs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "transdtlshapes_tbl")
public class TransdtlshapesTbl {

    @Id
   @Column(name = "txt_key", length = 60)
    private String txtKey;

    @Column(name = "txt_transkey", length = 60)
    private String txtTranskey;

    @Column(name = "txt_shapekey", length = 60)
    private String txtShapekey;


    @Column(name = "txt_sideslist", length = 600)
    private String txtSideslist;

    @Column(name = "int_sides", precision = 5)
    private BigDecimal intSides;

    @Column(name = "dbl_totlength", precision = 10, scale = 5)
    private BigDecimal dblTotlength;

    public String getTxtKey() {
        return txtKey;
    }

    public void setTxtKey(String txtKey) {
        this.txtKey = txtKey;
    }

    public String getTxtTranskey() {
        return txtTranskey;
    }

    public void setTxtTranskey(String txtTranskey) {
        this.txtTranskey = txtTranskey;
    }

    public String getTxtShapekey() {
        return txtShapekey;
    }

    public void setTxtShapekey(String txtShapekey) {
        this.txtShapekey = txtShapekey;
    }

    public String getTxtSideslist() {
        return txtSideslist;
    }

    public void setTxtSideslist(String txtSideslist) {
        this.txtSideslist = txtSideslist;
    }

    public BigDecimal getIntSides() {
        return intSides;
    }

    public void setIntSides(BigDecimal intSides) {
        this.intSides = intSides;
    }

    public BigDecimal getDblTotlength() {
        return dblTotlength;
    }

    public void setDblTotlength(BigDecimal dblTotlength) {
        this.dblTotlength = dblTotlength;
    }

}