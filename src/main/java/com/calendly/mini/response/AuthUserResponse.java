package com.calendly.mini.response;

import com.calendly.mini.model.Session;
import lombok.Data;

import java.io.Serializable;

@Data
public class AuthUserResponse implements Serializable {

    private String requestId;

    private Session session;

    public AuthUserResponse(String requestId) {
        this.requestId = requestId;
    }
}
