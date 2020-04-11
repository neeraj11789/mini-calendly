package com.calendly.mini.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class User {

    @Getter
    private String id = UUID.randomUUID().toString();

    @Getter @Setter
    private UserName username;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private Password password;

    @Getter @Setter
    private Email email;

    /**
     * ... other fields
     */

}
