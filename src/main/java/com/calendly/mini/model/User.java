package com.calendly.mini.model;

import javax.persistence.*;

@Table(name = "user")
@Entity
public class User {

    public User(String username, String name, String password, String email) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name", nullable = false)
    private String username;

    @Column(name = "full_name")
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email")
    private String email;

    /**
     * ... other fields
     */

}
