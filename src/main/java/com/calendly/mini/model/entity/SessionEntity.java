package com.calendly.mini.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sessions")
@Data
@Entity
public class SessionEntity {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "access_key")
    private String accessKey;

    @Column(name = "secret_key")
    private String secretKey;

    /**
     * Other fields

     private Long createdAt;

     private Long lastAccessAt;

     private Long expiry;

     **/

}
