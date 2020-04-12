package com.calendly.mini.controller;

import com.calendly.mini.persist.dao.UserDao;
import com.calendly.mini.request.RegisterUserRequest;
import com.calendly.mini.response.RegisterUserResponse;
import com.calendly.mini.exception.BadRequestException;
import com.calendly.mini.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class UserController {

    @Autowired
    UserService service;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public RegisterUserResponse register(@RequestBody RegisterUserRequest request){
        if(!request.isValid())
            throw new BadRequestException("Bad Request");
        service.register(request);

        RegisterUserResponse response = new RegisterUserResponse(request.getRequestId());
        response.setMessage("User Registered");
        return response;
    }
}