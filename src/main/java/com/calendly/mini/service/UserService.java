package com.calendly.mini.service;

import com.calendly.mini.model.AuthKey;
import com.calendly.mini.request.AuthUserRequest;
import com.calendly.mini.request.RegisterUserRequest;
import com.calendly.mini.response.RegisterUserResponse;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface UserService {

    RegisterUserResponse register(RegisterUserRequest request);

    AuthKey authenticate(AuthUserRequest request) throws InvalidKeySpecException, NoSuchAlgorithmException;

}