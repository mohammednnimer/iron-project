package org.gs.dto;

import java.math.BigDecimal;

public class LoginResponse {
    private String token;
    private String message;
    private String errorCode;
    private String expiresAt;
    private BigDecimal role;

    public LoginResponse() {}

    public LoginResponse(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public LoginResponse(String token, String expiresAt, String message) {
        this.token = token;
        this.expiresAt = expiresAt;
        this.message = message;
    }

    public LoginResponse(String token, String expiresAt, String message, BigDecimal role) {
        this.token = token;
        this.expiresAt = expiresAt;
        this.message = message;
        this.role = role;
    }

   public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public String getErrorCode() { return errorCode; }
    public void setErrorCode(String errorCode) { this.errorCode = errorCode; }
    public String getExpiresAt() { return expiresAt; }
    public void setExpiresAt(String expiresAt) { this.expiresAt = expiresAt; }
    public BigDecimal getRole() { return role; }
    public void setRole(BigDecimal role) { this.role = role; }
}