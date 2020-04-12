package com.calendly.mini.model.vo;

import com.calendly.mini.exception.WeakPasswordException;
import lombok.Getter;
import lombok.NonNull;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Random;

public class Password {

    private static final Random RANDOM = new SecureRandom();
    private static final int ITERATIONS = 65536;
    private static final int KEY_LENGTH = 128;

    @Getter
    private String password;

    /**
     * Constructor
     * @param password
     * @throws InvalidKeySpecException
     * @throws NoSuchAlgorithmException
     */
    public Password(@NonNull String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
        this.password = generatePassword(password);
    }

    /**
     *
     * @param password
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    private String generatePassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeySpec spec = new PBEKeySpec(password.toCharArray(), getSalt(), ITERATIONS, KEY_LENGTH);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash =  factory.generateSecret(spec).getEncoded();
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
