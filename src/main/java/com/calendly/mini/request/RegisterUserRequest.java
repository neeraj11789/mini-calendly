package com.calendly.mini.request;

import com.calendly.mini.util.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
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
     * Validate the Registration Request
     * @return
     */
    public boolean isValid(){
        requireNonNull(userName, Constants.NULL_USER);
        requireNonNull(password, Constants.NULL_PASS);
        requireNonNull(confirmPassword, Constants.NULL_PASS);
        if(!password.equals(confirmPassword))
            throw new IllegalArgumentException(Constants.PASS_MISMATCH);
        return true;
    }
}