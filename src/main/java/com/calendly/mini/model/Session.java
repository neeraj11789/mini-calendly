package com.calendly.mini.model;

import com.calendly.mini.model.entity.SessionEntity;
import lombok.Data;

import java.util.UUID;

@Data
public class Session {

    private String userId;

    private String accessKey;

    private String secretKey;

    public Session(User user) {
        this.userId = user.getUsername();
        setAccessKey();
        setSecretKey();
    }

    public void setAccessKey() {
        this.accessKey = UUID.randomUUID().toString();
    }

    public void setSecretKey() {
        this.secretKey = UUID.randomUUID().toString();
    }

    public SessionEntity toEntity(){
        SessionEntity entity = new SessionEntity();
        entity.setAccessKey(this.accessKey);
        entity.setSecretKey(this.secretKey);
        entity.setUserId(this.userId);
        return entity;
    }
}