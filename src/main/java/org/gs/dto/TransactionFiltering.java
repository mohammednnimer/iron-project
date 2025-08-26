package org.gs.dto;

import net.bytebuddy.asm.Advice;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionFiltering {
    private LocalDate fromDate;
    private LocalDate toDate;
    private Integer fromOrderNumber;
    private Integer toOrderNumber;
    private String CustomerName;
    private BigDecimal status;
    private String Username;
    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public Integer getFromOrderNumber() {
        return fromOrderNumber;
    }

    public void setFromOrderNumber(Integer fromOrderNumber) {
        this.fromOrderNumber = fromOrderNumber;
    }

    public Integer getToOrderNumber() {
        return toOrderNumber;
    }

    public void setToOrderNumber(Integer toOrderNumber) {
        this.toOrderNumber = toOrderNumber;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public BigDecimal getStatus() {
        return status;
    }

    public void setStatus(BigDecimal status) {
        this.status = status;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }
}
