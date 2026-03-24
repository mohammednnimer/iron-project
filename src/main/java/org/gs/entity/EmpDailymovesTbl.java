package org.gs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table(name = "emp_dailymoves_tbl")
public class EmpDailymovesTbl {

    @Id
    @Column(name = "txt_key", length = 60)
    private String txtKey;

    @Column(name = "txt_empkey", length = 60)
    private String txtEmpkey;

    @Column(name = "dat_transdate")
    private Instant datTransdate;

    @Column(name = "int_type")
    private Integer intType;

    @Column(name = "txt_status", length = 50)
    private String txtStatus;

    @Column(name = "bol_approved")
    private Integer bolApproved;

    public String getTxtKey() {
        return txtKey;
    }

    public void setTxtKey(String txtKey) {
        this.txtKey = txtKey;
    }

    public String getTxtEmpkey() {
        return txtEmpkey;
    }

    public void setTxtEmpkey(String txtEmpkey) {
        this.txtEmpkey = txtEmpkey;
    }

    public Instant getDatTransdate() {
        return datTransdate;
    }

    public void setDatTransdate(Instant datTransdate) {
        this.datTransdate = datTransdate;
    }

    public Integer getIntType() {
        return intType;
    }

    public void setIntType(Integer intType) {
        this.intType = intType;
    }

    public String getTxtStatus() {
        return txtStatus;
    }

    public void setTxtStatus(String txtStatus) {
        this.txtStatus = txtStatus;
    }

    public Integer getBolApproved() {
        return bolApproved;
    }

    public void setBolApproved(Integer bolApproved) {
        this.bolApproved = bolApproved;
    }

}