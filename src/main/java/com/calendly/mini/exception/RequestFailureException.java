package com.calendly.mini.exception;

public class RequestFailureException extends RuntimeException {

    public RequestFailureException() {
    }

    public RequestFailureException(String message) {
        super(message);
    }

    public RequestFailureException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestFailureException(Throwable cause) {
        super(cause);
    }

    public RequestFailureException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
