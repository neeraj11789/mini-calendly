package com.calendly.mini.service;

import com.calendly.mini.model.Session;
import com.calendly.mini.model.entity.SessionEntity;
import com.calendly.mini.model.entity.UserEntity;
import com.calendly.mini.request.AuthUserRequest;
import com.calendly.mini.request.RegisterUserRequest;
import com.calendly.mini.response.MessageResponse;

import java.util.Optional;

public interface UserService {

    MessageResponse register(RegisterUserRequest request);

    Session authenticate(AuthUserRequest request);

    Optional<UserEntity> userExists(String userId);

    Optional<SessionEntity> sessionExists(String userId);

}