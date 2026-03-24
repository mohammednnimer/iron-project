package org.gs.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customer_tbl")
public class CustomerTbl {
    @Id
    @Column(name = "txt_key", length = 60)
    private String txtKey;

    @Column(name = "txt_tag", length = 15)
    private String txtTag;

    @Column(name = "txt_name", length = 300)
    private String txtName;

    @Column(name = "txt_phone1", length = 50)
    private String txtPhone1;

    @Column(name = "txt_phone2", length = 50)
    private String txtPhone2;

    @Column(name = "txt_address", length = 200)
    private String txtAddress;

    @Column(name = "txt_reference", length = 30)
    private String txtReference;


    @Column(name = "txt_test")
    private String txtTest;

    @Column(name = "int_systemtype", nullable = false)
    private Integer intSystemtype;

    @Column(name = "txt_email", length = 100)
    private String txtEmail;

    public String getTxtKey() {
        return txtKey;
    }

    public void setTxtKey(String txtKey) {
        this.txtKey = txtKey;
    }

    public String getTxtTag() {
        return txtTag;
    }

    public void setTxtTag(String txtTag) {
        this.txtTag = txtTag;
    }

    public String getTxtName() {
        return txtName;
    }

    public void setTxtName(String txtName) {
        this.txtName = txtName;
    }

    public String getTxtPhone1() {
        return txtPhone1;
    }

    public void setTxtPhone1(String txtPhone1) {
        this.txtPhone1 = txtPhone1;
    }

    public String getTxtPhone2() {
        return txtPhone2;
    }

    public void setTxtPhone2(String txtPhone2) {
        this.txtPhone2 = txtPhone2;
    }

    public String getTxtAddress() {
        return txtAddress;
    }

    public void setTxtAddress(String txtAddress) {
        this.txtAddress = txtAddress;
    }

    public String getTxtReference() {
        return txtReference;
    }

    public void setTxtReference(String txtReference) {
        this.txtReference = txtReference;
    }

    public String getTxtTest() {
        return txtTest;
    }

    public void setTxtTest(String txtTest) {
        this.txtTest = txtTest;
    }

    public Integer getIntSystemtype() {
        return intSystemtype;
    }

    public void setIntSystemtype(Integer intSystemtype) {
        this.intSystemtype = intSystemtype;
    }

    public String getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(String txtEmail) {
        this.txtEmail = txtEmail;
    }

    @Override
    public String toString() {
        return "CustomerTbl{" +
                "txtKey='" + txtKey + '\'' +
                ", txtTag='" + txtTag + '\'' +
                ", txtName='" + txtName + '\'' +
                ", txtPhone1='" + txtPhone1 + '\'' +
                ", txtPhone2='" + txtPhone2 + '\'' +
                ", txtAddress='" + txtAddress + '\'' +
                ", txtReference='" + txtReference + '\'' +
                ", txtTest='" + txtTest + '\'' +
                ", intSystemtype=" + intSystemtype +
                ", txtEmail='" + txtEmail + '\'' +
                '}';
    }
}