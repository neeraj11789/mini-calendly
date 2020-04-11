package com.calendly.mini.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Password {

    @NonNull @Getter
    private String password;

    public boolean isStrong(){
        return true;
    }

    public boolean validate(){
        return true;
    }
}
