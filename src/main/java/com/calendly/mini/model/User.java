package com.calendly.mini.model;

import com.calendly.mini.model.entity.UserEntity;
import com.calendly.mini.model.vo.Password;
import com.calendly.mini.request.AuthUserRequest;
import com.calendly.mini.request.RegisterUserRequest;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
@Data
public class User {

    private String username;

    private String name;

    private String password;

    private String email;

    private Long mobile;

    /**
     * Constructor with RegisterUserRequest
     * @param request
     */
    public User(RegisterUserRequest request) {
        this.username = request.getUserName();
        this.name = request.getName();
        this.password = new Password(request.getPassword()).toString();
        this.email = getEmail();
    }

    /**
     * Constructor with AuthUserRequest
     * @param request
     */
    public User(AuthUserRequest request) {
        this.username = request.getUsername();
        this.password = new Password(request.getPassword()).toString();
    }


    /**
     * Constructor with UserEntity
     * @param userEntity
     */
    public User(UserEntity userEntity) {
        this.username = userEntity.getUserid();
        this.password = userEntity.getPassword();
        this.email = userEntity.getEmail();
        this.name = userEntity.getName();
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

    /**
     * Compare only UserId and Password Values to compare user
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
               Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
