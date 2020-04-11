package com.calendly.mini.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class AuthKey {

    private UserName userName;

    private String accessKey;

    private String secretKey;

    private Long createdAt;

    private Long lastAccessAt;

    private Long expiry;
}
