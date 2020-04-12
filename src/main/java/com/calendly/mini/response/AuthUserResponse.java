package com.calendly.mini.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class AuthUserResponse implements Serializable {

    private String requestId;

    private String message;

    public AuthUserResponse(String requestId) {
        this.requestId = requestId;
    }
}
