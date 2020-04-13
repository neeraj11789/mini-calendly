package com.calendly.mini.service;

import com.calendly.mini.model.Session;
import com.calendly.mini.request.AuthUserRequest;
import com.calendly.mini.request.RegisterUserRequest;
import com.calendly.mini.response.MessageResponse;

public interface UserService {

    MessageResponse register(RegisterUserRequest request);

    Session authenticate(AuthUserRequest request);

    boolean userExists(String userId);

}