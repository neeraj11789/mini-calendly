package com.calendly.mini.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "users")
@Entity
@Data
public class UserEntity {

    @Id
    @Column(name = "user_id", nullable = false)
    private String userid;

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
