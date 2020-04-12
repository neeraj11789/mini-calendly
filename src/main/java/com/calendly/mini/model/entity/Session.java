package com.calendly.mini.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class Session {

    public Session(String userId, String accessKey, String secretKey) {
        this.userId = userId;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public Session(String userId) {
        this.userId = userId;
        this.accessKey = UUID.randomUUID().toString();
        this.secretKey = UUID.randomUUID().toString();
    }

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "access_key")
    private String accessKey;

    @Column(name = "secret_key")
    private String secretKey;
}
