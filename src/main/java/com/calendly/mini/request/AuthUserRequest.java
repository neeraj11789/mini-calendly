package com.calendly.mini.request;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class AuthUserRequest implements Serializable {

    private static final long serialVersionUID = 9142546232423804143L;

    private final String requestId = UUID.randomUUID().toString();

    private String username;

    private String password;

    /**
     * @todo
     * @return
     */
    public boolean isValid(){
        return true;
    }

}