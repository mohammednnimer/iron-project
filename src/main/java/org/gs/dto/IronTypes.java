package org.gs.dto;



import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.math.BigDecimal;


public class IronTypes {

    private String txtDescription;
    private String txtReference;
   private BigDecimal dblPrice;


    public String getTxtDescription() {
        return txtDescription;
    }

    public void setTxtDescription(String txtDescription) {
        this.txtDescription = txtDescription;
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

}