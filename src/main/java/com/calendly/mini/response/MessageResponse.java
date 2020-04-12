package com.calendly.mini.response;

import com.calendly.mini.request.RegisterUserRequest;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Data
@Slf4j
public class MessageResponse implements Serializable {

    private static final long serialVersionUID = 5773097659207648126L;

    private String requestId;

    private String message;

    public MessageResponse(String requestId) {
        this.requestId = requestId;
    }

    public MessageResponse(RegisterUserRequest request) {
        this.requestId = request.getRequestId();
    }
}
