package org.gs.exception;


public class UnAuthRequestException extends RuntimeException {
    private String errorCode;

    public UnAuthRequestException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}