package com.calendly.mini.util;

public enum ResponseCode {

    SUCCESS(2000, "Success"),
    RESOURCE_CREATED(2001, "Resource Created"),
    UNAUTHORIZED(4001, "Unauthorized Access"),
    PAYMENT_REQUIRED(4002, "Payment Required"),
    FORBIDDEN(4003, "Forbidden Action"),
    RESOURCE_NOT_FOUND(4004, "Resource Not Found"),
    TIMEOUT_OCCURRED(5024, "A timeout occurred"),
    INTERNAL_SERVER_ERROR(5000, "Internal Server Error"),
    SERVICE_UNAVAILABLE(5003, "Service Unavailable"),
    RESOURCE_CREATION_FAILED(5103, "Resource Creation Failed");

    ResponseCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    private int code;
    private String description;
}