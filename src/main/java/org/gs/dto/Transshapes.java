package org.gs.dto;

import java.math.BigDecimal;

public class Transshapes {

    private String txtShapekey;

    private BigDecimal intSides;

    private BigDecimal dblTotlength;
    private String txt_side_list;

    public String getTxt_side_list() {
        return txt_side_list;
    }

    public void setTxt_side_list(String txt_side_list) {
        this.txt_side_list = txt_side_list;
    }

    public String getTxtShapekey() {
        return txtShapekey;
    }



    public void setTxtShapekey(String txtShapekey) {
        this.txtShapekey = txtShapekey;
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
