package com.calendly.mini.model;

import com.calendly.mini.model.entity.Session;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class AuthKey {

    private String userName;

    private String accessKey;

    private String secretKey;

    public AuthKey(Session session) {
        this.userName = session.getUserId();
        this.accessKey = session.getAccessKey();
        this.secretKey = session.getSecretKey();
    }

    /**
     * Other fields

    private Long createdAt;

    private Long lastAccessAt;

    private Long expiry;

     **/
}
