package com.example.data.exceptions;

public class ConnectivityException extends RuntimeException {

    public ConnectivityException(String message) {
        super("Server was not reached: " + message);
    }
}
