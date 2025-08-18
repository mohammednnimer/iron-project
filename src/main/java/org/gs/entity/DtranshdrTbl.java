package org.gs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "dtranshdr_tbl")
public class DtranshdrTbl {
    @Id
    @Column(name = "txt_key", length = 60)
    private String txtKey;

    @Column(name = "int_vouchernum", precision = 5)
    private BigDecimal intVouchernum;

    @Column(name = "txt_reference", length = 30)
    private String txtReference;

    @Column(name = "txt_notes", length = 200)
    private String txtNotes;

    @Column(name = "dat_date")
    private LocalDate datDate;

    @Column(name = "txt_custkey", length = 60)
    private String txtCustkey;

    @Column(name = "txt_custname", length = 300)
    private String txtCustname;

    @Column(name = "int_status", precision = 5)
    private BigDecimal intStatus;

    @Column(name = "txt_usercode", length = 30)
    private String txtUsercode;

    @Column(name = "dat_createddate")
    private LocalDate datCreateddate;

    @Column(name = "dat_stampdate")
    private Instant datStampdate;

    @Column(name = "txt_exittime", length = 30)
    private String txtExittime;

    @Column(name = "txt_vehicelno", length = 50)
    private String txtVehicelno;

    @Column(name = "txt_address", length = 250)
    private String txtAddress;

    @Column(name = "int_type")
    private Integer intType;

    public String getTxtKey() {
        return txtKey;
    }

    public void setTxtKey(String txtKey) {
        this.txtKey = txtKey;
    }

    public BigDecimal getIntVouchernum() {
        return intVouchernum;
    }

    public void setIntVouchernum(BigDecimal intVouchernum) {
        this.intVouchernum = intVouchernum;
    }

    public String getTxtReference() {
        return txtReference;
    }

    public void setTxtReference(String txtReference) {
        this.txtReference = txtReference;
    }

    public String getTxtNotes() {
        return txtNotes;
    }

    public void setTxtNotes(String txtNotes) {
        this.txtNotes = txtNotes;
    }

    public LocalDate getDatDate() {
        return datDate;
    }

    public void setDatDate(LocalDate datDate) {
        this.datDate = datDate;
    }

    public String getTxtCustkey() {
        return txtCustkey;
    }

    public void setTxtCustkey(String txtCustkey) {
        this.txtCustkey = txtCustkey;
    }

    public String getTxtCustname() {
        return txtCustname;
    }

    public void setTxtCustname(String txtCustname) {
        this.txtCustname = txtCustname;
    }

    public BigDecimal getIntStatus() {
        return intStatus;
    }

    public void setIntStatus(BigDecimal intStatus) {
        this.intStatus = intStatus;
    }

    public String getTxtUsercode() {
        return txtUsercode;
    }

    public void setTxtUsercode(String txtUsercode) {
        this.txtUsercode = txtUsercode;
    }

    public LocalDate getDatCreateddate() {
        return datCreateddate;
    }

    public void setDatCreateddate(LocalDate datCreateddate) {
        this.datCreateddate = datCreateddate;
    }

    public Instant getDatStampdate() {
        return datStampdate;
    }

    public void setDatStampdate(Instant datStampdate) {
        this.datStampdate = datStampdate;
    }

    public String getTxtExittime() {
        return txtExittime;
    }

    public void setTxtExittime(String txtExittime) {
        this.txtExittime = txtExittime;
    }

    public String getTxtVehicelno() {
        return txtVehicelno;
    }

    public void setTxtVehicelno(String txtVehicelno) {
        this.txtVehicelno = txtVehicelno;
    }

    public String getTxtAddress() {
        return txtAddress;
    }

    public void setTxtAddress(String txtAddress) {
        this.txtAddress = txtAddress;
    }

    public Integer getIntType() {
        return intType;
    }

    public void setIntType(Integer intType) {
        this.intType = intType;
    }

}