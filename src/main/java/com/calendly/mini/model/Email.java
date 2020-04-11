package com.calendly.mini.model;

import lombok.Getter;
import lombok.Setter;

public class Email {

    @Getter @Setter
    String email;

    boolean validate(){
        return true;
    }
}
