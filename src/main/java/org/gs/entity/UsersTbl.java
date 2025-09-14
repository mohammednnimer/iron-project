package org.gs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "users_tbl")
public class UsersTbl {
    @Id
    @Column(name = "txt_code", length = 30,nullable = true)
    private String txtCode;

    @Column(name = "txt_name", length = 100)
    private String txtName;

    @Column(name = "txt_pwd", length = 30)
    private String txtPwd;

    @Column(name = "int_level", precision = 5)
    private BigDecimal intLevel;



    @Column(name = "active_token", columnDefinition = "TEXT")
    private String activeToken;


    public String getActiveToken() { return activeToken; }

    public void setActiveToken(String activeToken) { this.activeToken = activeToken; }

    @Column(name = "user_status")
    private Boolean userStatus;




    public Boolean getUserStatus() {
        return userStatus;
    }


    public Boolean  isUserStatus() {
            return userStatus;
        }
        public void setUserStatus(Boolean userStatus) {
            this.userStatus = userStatus;
    }

    public String getTxtCode() {
        return txtCode;
    }

    public void setTxtCode(String txtCode) {
        this.txtCode = txtCode;
    }

    public String getTxtName() {
        return txtName;
    }

    public void setTxtName(String txtName) {
        this.txtName = txtName;
    }

    public String getTxtPwd() {
        return txtPwd;
    }

    public void setTxtPwd(String txtPwd) {
        this.txtPwd = txtPwd;
    }

    public BigDecimal getIntLevel() {
        return intLevel;
    }

    public void setIntLevel(BigDecimal intLevel) {
        this.intLevel = intLevel;
    }

    @Override
    public String toString() {
        return "UsersTbl{" +
                "txtCode='" + txtCode + '\'' +
                ", txtName='" + txtName + '\'' +
                ", txtPwd='" + txtPwd + '\'' +
                ", intLevel=" + intLevel +
                ", activeToken='" + activeToken + '\'' +
                ", userStatus=" + userStatus +
                '}';
    }
}