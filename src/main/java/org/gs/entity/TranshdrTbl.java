package org.gs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "transhdr_tbl")
public class TranshdrTbl {
    @Id
    @Column(name = "txt_key", length = 60)
    private String txtKey;

    @Column(name = "int_vouchernum")
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

    @Column(name = "dbl_total")
    private BigDecimal dblTotal;

    @Column(name = "dat_createddate")
    private LocalDate datCreateddate;

    @Column(name = "dat_stampdate")
    private Instant datStampdate;

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

    public BigDecimal getDblTotal() {
        return dblTotal;
    }

    public void setDblTotal(BigDecimal dblTotal) {
        this.dblTotal = dblTotal;
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

}