package org.gs.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

public class UserResponse {




        private BigDecimal intLevel;

    private String txtName;



        public BigDecimal getIntLevel() {
            return intLevel;
        }

        public void setIntLevel(BigDecimal intLevel) {
            this.intLevel = intLevel;
        }

    public String getTxtName() {
        return txtName;
    }

    public void setTxtName(String txtName) {
        this.txtName = txtName;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "intLevel=" + intLevel +
                ", txtName='" + txtName + '\'' +
                '}';
    }
}
