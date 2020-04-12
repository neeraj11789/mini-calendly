package com.calendly.mini.service.impl;

import com.calendly.mini.model.AuthKey;
import com.calendly.mini.exception.RequestFailureException;
import com.calendly.mini.model.User;
import com.calendly.mini.model.vo.Password;
import com.calendly.mini.model.vo.UserName;
import com.calendly.mini.persist.dao.UserDao;
import com.calendly.mini.request.RegisterUserRequest;
import com.calendly.mini.service.UserService;
import com.calendly.mini.util.Constants;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    @NonNull
    UserDao dao;

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
    public AuthKey authenticate(UserName userName, Password password) {
        return null;
    }
}