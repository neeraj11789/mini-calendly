package com.calendly.mini.service.impl;

import com.calendly.mini.model.AuthKey;
import com.calendly.mini.model.User;
import com.calendly.mini.model.vo.Password;
import com.calendly.mini.model.vo.UserName;
import com.calendly.mini.persist.dao.UserDao;
import com.calendly.mini.request.RegisterUserRequest;
import com.calendly.mini.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    @NonNull
    UserDao dao;

    @Override
    public void register(RegisterUserRequest request){
        User user = new User(request.getUserName(), request.getName(), request.getPassword(), request.getEmail());
        dao.save(user);
    }

    @Override
    public AuthKey authenticate(UserName userName, Password password) {
        return null;
    }
}
