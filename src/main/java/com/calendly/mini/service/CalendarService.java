package com.calendly.mini.service;

import com.calendly.mini.model.SingleSlot;
import com.calendly.mini.request.CreateSlotRequest;
import com.calendly.mini.response.MessageResponse;

import java.time.LocalDate;

public interface CalendarService {
    void bookSlot(String userName, LocalDate date, SingleSlot singleSlot);

    MessageResponse createSlot(CreateSlotRequest request);
}
