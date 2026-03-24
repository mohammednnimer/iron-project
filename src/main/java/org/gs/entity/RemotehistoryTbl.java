package org.gs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "remotehistory_tbl")
public class RemotehistoryTbl {
    @Id
    @Column(name = "txt_key", length = 60)
    private String txtKey;

    @Column(name = "txt_mkey", length = 60)
    private String txtMkey;

    @Column(name = "int_type", precision = 5)
    private BigDecimal intType;

    @Column(name = "dat_date")
    private Instant datDate;

    @Column(name = "int_status", precision = 5)
    private BigDecimal intStatus;

    public String getTxtKey() {
        return txtKey;
    }

    public void setTxtKey(String txtKey) {
        this.txtKey = txtKey;
    }

    public String getTxtMkey() {
        return txtMkey;
    }

    public void setTxtMkey(String txtMkey) {
        this.txtMkey = txtMkey;
    }

    public BigDecimal getIntType() {
        return intType;
    }

    public void setIntType(BigDecimal intType) {
        this.intType = intType;
    }

    public Instant getDatDate() {
        return datDate;
    }

    public void setDatDate(Instant datDate) {
        this.datDate = datDate;
    }

    public BigDecimal getIntStatus() {
        return intStatus;
    }

    public void setIntStatus(BigDecimal intStatus) {
        this.intStatus = intStatus;
    }

}