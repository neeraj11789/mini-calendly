package com.calendly.mini.service;

import com.calendly.mini.model.SingleSlot;
import com.calendly.mini.model.vo.UserName;

import java.time.LocalDate;
import java.util.List;

public interface Calendar {
    void createSlot(UserName userName, LocalDate date, List<SingleSlot> slots);
}
