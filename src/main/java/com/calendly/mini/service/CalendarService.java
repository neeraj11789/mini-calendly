package com.calendly.mini.service;

import com.calendly.mini.request.BookSlotRequest;
import com.calendly.mini.request.CreateSlotRequest;
import com.calendly.mini.response.MessageResponse;

public interface CalendarService {

    MessageResponse createSlot(CreateSlotRequest request);

    MessageResponse bookSlot(BookSlotRequest request);
}
