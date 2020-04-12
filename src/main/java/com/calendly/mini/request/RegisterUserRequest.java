package com.calendly.mini.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserRequest implements Serializable {

    private static final long serialVersionUID = -8986617214507610931L;

    private final String requestId = UUID.randomUUID().toString();

    private String userName;

    private String password;

    private String confirmPassword;

    private String name;

    private String email;

    /**
     * @todo
     * @return
     */
    public boolean isValid(){
        return true;
    }
}