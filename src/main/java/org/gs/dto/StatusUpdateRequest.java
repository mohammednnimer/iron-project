package org.gs.dto;

import java.math.BigDecimal;

public class StatusUpdateRequest {
    private int vouchernum;
    private int status;


    public int getVouchernum() {
        return vouchernum;
    }

    public void setVouchernum(int vouchernum) {
        this.vouchernum = vouchernum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
