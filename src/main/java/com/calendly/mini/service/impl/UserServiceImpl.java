package com.calendly.mini.service.impl;

import com.calendly.mini.exception.InvalidCredentialsException;
import com.calendly.mini.exception.RequestFailureException;
import com.calendly.mini.exception.UserNotFoundException;
import com.calendly.mini.model.Session;
import com.calendly.mini.model.User;
import com.calendly.mini.model.entity.SessionEntity;
import com.calendly.mini.model.entity.UserEntity;
import com.calendly.mini.persist.dao.SessionDao;
import com.calendly.mini.persist.dao.UserDao;
import com.calendly.mini.request.AuthUserRequest;
import com.calendly.mini.request.RegisterUserRequest;
import com.calendly.mini.response.MessageResponse;
import com.calendly.mini.service.UserService;
import com.calendly.mini.utils.Constants;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    @NonNull
    UserDao dao;

    @NonNull
    SessionDao sessionDao;

    /**
     * Register User Service
     * @param request
     * @return
     */
    @Override
    public MessageResponse register(RegisterUserRequest request){
        MessageResponse response = new MessageResponse(request.getRequestId());
        try{
            User user = new User(request);
            dao.save(user.toEntity());
            response.setMessage(Constants.USER_SAVED);
        }catch (Exception e){
            log.error("Unable to save user", e);
            throw new RequestFailureException(Constants.REQUEST_FAILURE);
        }
        return response;
    }

    /**
     * Check if the User Exists in the System
     * @param userId
     * @return
     */
    public boolean userExists(String userId){
        Optional<UserEntity> daoEntity = dao.get(userId);

        if(!daoEntity.isPresent())
            throw new UserNotFoundException(Constants.USER_NOT_FOUND);

        return true;
    }

    /**
     * Authentication Module for User
     * Creates session on correct credentials if does not exist
     * @param request
     * @return
     */
    @Override
    public Session authenticate(AuthUserRequest request) {
        // find user by id -> UserNotFoundException
        // check password -> InvalidCredentialsException

        User requestUser = new User(request);
        Optional<UserEntity> daoEntity = dao.get(requestUser.getUsername());

        if(!daoEntity.isPresent())
            throw new UserNotFoundException(Constants.USER_NOT_FOUND);

        User daoUser = new User(daoEntity.get());

        if(!(daoUser.equals(requestUser)))
            throw new InvalidCredentialsException(Constants.INCORRECT_CREDENTIALS);

        // if existing session if found, send it else create new session
        Session session = new Session(daoUser);
        Optional<SessionEntity> sessionDaoEntity = sessionDao.get(session.getUserId());

        if(!sessionDaoEntity.isPresent())
            sessionDao.save(session.toEntity());

        return session;
    }
}