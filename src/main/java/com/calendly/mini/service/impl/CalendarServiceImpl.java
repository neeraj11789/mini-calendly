package com.calendly.mini.service.impl;

import com.calendly.mini.model.SingleSlot;
import com.calendly.mini.service.CalendarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CalendarServiceImpl implements CalendarService {
    @Override
    public void createSlot(String userName, LocalDate date, List<SingleSlot> slots) {

    }

    @Override
    public void bookSlot(String userName, LocalDate date, SingleSlot singleSlot) {

    }
}
