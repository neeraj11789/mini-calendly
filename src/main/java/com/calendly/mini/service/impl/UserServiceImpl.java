package com.calendly.mini.service.impl;

import com.calendly.mini.exception.InvalidCredentialsException;
import com.calendly.mini.exception.UserNotFoundException;
import com.calendly.mini.model.AuthKey;
import com.calendly.mini.exception.RequestFailureException;
import com.calendly.mini.model.entity.Session;
import com.calendly.mini.model.entity.User;
import com.calendly.mini.model.vo.Password;
import com.calendly.mini.persist.dao.SessionDao;
import com.calendly.mini.persist.dao.UserDao;
import com.calendly.mini.request.AuthUserRequest;
import com.calendly.mini.request.RegisterUserRequest;
import com.calendly.mini.service.UserService;
import com.calendly.mini.util.Constants;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    @NonNull
    UserDao dao;

    @NonNull
    SessionDao sessionDao;

    @Override
    public void register(RegisterUserRequest request){
        try{
            Password password = new Password(request.getPassword());
            User user = new User(request.getUserName(), request.getName(), password.toString(), request.getEmail());
            dao.save(user);
        }catch (Exception e){
            log.error("Unable to save user", e);
            throw new RequestFailureException(Constants.REQUEST_FAILURE);
        }
    }

    @Override
    public AuthKey authenticate(AuthUserRequest request) throws InvalidKeySpecException, NoSuchAlgorithmException {
        // find user by id -> UserNotFoundException
        // check password -> InvalidCredentialsException
        if(!dao.get(request.getUsername()).isPresent())
            throw new UserNotFoundException("User not found in the system");

        User user = dao.get(request.getUsername()).get();
        Password userpassword = new Password(request.getPassword());

        if(!(userpassword.equals(user.getPassword())))
            throw new InvalidCredentialsException("Incorrect Credentials");

        // Create Session
        Session session = new Session(request.getUsername());
        sessionDao.save(session);

        return new AuthKey(session);
    }
}