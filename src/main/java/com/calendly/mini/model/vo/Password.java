package com.calendly.mini.model.vo;

import com.calendly.mini.exception.WeakPasswordException;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Random;

@Slf4j
public class Password {

    private static final Random RANDOM = new SecureRandom();

    @Getter
    private String password;

    /**
     * Constructor
     * @param password
     * @throws InvalidKeySpecException
     * @throws NoSuchAlgorithmException
     */
    public Password(@NonNull String password) {
        this.password = getHash(password);
    }

    /**
     * Temporary function to save the hash
     * @param password
     * @return
     */
    private String getHash(String password){
        return String.valueOf(password.hashCode());
    }

    /**
     * Utility for creating Salt
     * @return
     */
    public byte[] getSalt() {
        byte[] salt = new byte[16];
        RANDOM.nextBytes(salt);
        return salt;
    }

    /**
     * Get String version of password
     * @return
     */
    @Override
    public String toString() {
        return password;
    }

    @Override
    public int hashCode() {
        return password.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(obj == null || obj.getClass()!= this.getClass())
            return false;

        String objPassword = (String) obj;
        return objPassword.equals(password);
    }

    /**
     * Check if the password is strong
     * @todo: To be implemented
     * @return
     */
    public boolean isStrong() throws WeakPasswordException {
        return true;
    }

    /**
     * Validate Password
     * @return
     */
    public boolean validate(){
        return true;
    }
}
