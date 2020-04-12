package com.calendly.mini.service;

import com.calendly.mini.model.SingleSlot;

import java.time.LocalDate;
import java.util.List;

public interface CalendarService {
    void createSlot(String userName, LocalDate date, List<SingleSlot> slots);
    void bookSlot(String userName, LocalDate date, SingleSlot singleSlot);
}
