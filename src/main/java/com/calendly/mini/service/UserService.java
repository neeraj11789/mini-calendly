package com.calendly.mini.service;

import com.calendly.mini.model.AuthKey;
import com.calendly.mini.model.vo.Password;
import com.calendly.mini.model.vo.UserName;
import com.calendly.mini.request.AuthUserRequest;
import com.calendly.mini.request.RegisterUserRequest;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface UserService {

    void register(RegisterUserRequest request);

    AuthKey authenticate(AuthUserRequest request) throws InvalidKeySpecException, NoSuchAlgorithmException;

}