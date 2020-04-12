package com.calendly.mini.model.vo;

import lombok.Value;

@Value
public class Email {

    String email;

    boolean validate(){
        return true;
    }
}
