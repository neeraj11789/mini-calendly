package com.calendly.mini.model.vo;

import com.calendly.mini.exception.WeakPasswordException;
import com.calendly.mini.model.InternalServerException;
import com.calendly.mini.util.Constants;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Random;

@Slf4j
public class Password {

    private static final Random RANDOM = new SecureRandom();
    private static final int ITERATIONS = 100;
    private static final int KEY_LENGTH = 128;

    @Getter
    private String password;

    /**
     * Constructor
     * @param password
     * @throws InvalidKeySpecException
     * @throws NoSuchAlgorithmException
     */
    public Password(@NonNull String password) {
        this.password = generatePassword(password);
    }

    /**
     * Generate Password Hash
     * @param password
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    private String generatePassword(String password){
        byte[] hash;
        try {
            KeySpec spec = new PBEKeySpec(password.toCharArray(), getSalt(), ITERATIONS, KEY_LENGTH);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            hash =  factory.generateSecret(spec).getEncoded();
        }catch (Exception e){
            log.error("Unable to create hash of password");
            throw new InternalServerException(Constants.INTERNAL_ERROR);
        }
        return new String(hash);
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
