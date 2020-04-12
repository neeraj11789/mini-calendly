package com.calendly.mini.model;

import com.calendly.mini.model.entity.UserEntity;
import com.calendly.mini.model.vo.Password;
import com.calendly.mini.request.RegisterUserRequest;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class User {

    private String username;

    private String name;

    private String password;

    private String email;

    private Long mobile;

    /**
     * Constructor
     * @param request
     */
    public User(RegisterUserRequest request) {
        this.username = request.getUserName();
        this.name = request.getName();
        this.password = new Password(request.getPassword()).toString();
        this.email = getEmail();
    }

    /**
     * Get the DB Entity Object
     * @return
     */
    public UserEntity toEntity(){
        UserEntity entity =  new UserEntity();
        entity.setEmail(email);
        entity.setName(name);
        entity.setPassword(password);
        entity.setUserid(username);
        return entity;
    }
}
