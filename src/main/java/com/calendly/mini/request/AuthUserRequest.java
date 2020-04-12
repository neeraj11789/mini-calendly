package com.calendly.mini.request;

import com.calendly.mini.utils.Constants;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Data
public class AuthUserRequest implements Serializable {

    private static final long serialVersionUID = 9142546232423804143L;

    private final String requestId = UUID.randomUUID().toString();

    private String username;

    private String password;

    /**
     * Validate the UserName and Password
     * @return
     */
    public boolean isValid(){
        Objects.requireNonNull(username, Constants.NULL_USER);
        Objects.requireNonNull(password, Constants.NULL_PASS);
        return true;
    }

}