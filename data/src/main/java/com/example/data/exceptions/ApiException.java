package com.example.data.exceptions;


public class ApiException extends RuntimeException {
    public final int httpCode;

    public ApiException(int httpCode) {
        super("Server returned http code: " + httpCode);
        this.httpCode = httpCode;
    }
}
