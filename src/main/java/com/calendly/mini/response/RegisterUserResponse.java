package com.calendly.mini.response;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;


@Data
@Slf4j
public class RegisterUserResponse implements Serializable {

    private static final long serialVersionUID = 5773097659207648126L;

    private String requestId;

    private String message;

    public RegisterUserResponse(String requestId) {
        this.requestId = requestId;
    }
}
