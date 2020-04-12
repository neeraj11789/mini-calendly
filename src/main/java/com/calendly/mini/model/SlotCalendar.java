package com.calendly.mini.model;

import com.calendly.mini.model.vo.UserName;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * @NOTE: This can be decomposed further
 */
public class SlotCalendar {

    private String id = UUID.randomUUID().toString();

    private LocalDate date;

    private List<SingleSlot> slots;

    private UserName slotUser;

    private SlotStatus slotStatus;

    private UserName bookedBy;

    private long createdAt;

    private long bookedAt;
}