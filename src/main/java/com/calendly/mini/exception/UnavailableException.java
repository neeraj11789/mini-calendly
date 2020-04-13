package com.calendly.mini.exception;

public class UnavailableException extends RuntimeException {
    public UnavailableException() {
    }

    public UnavailableException(String message) {
        super(message);
    }

    public UnavailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnavailableException(Throwable cause) {
        super(cause);
    }

    public UnavailableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
