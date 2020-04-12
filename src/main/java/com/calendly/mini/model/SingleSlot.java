package com.calendly.mini.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter @RequiredArgsConstructor
public class SingleSlot {
    @NonNull
    private int startTime;

    @NonNull
    private int endTime;

    public boolean validate(){
        return true;
    }
}