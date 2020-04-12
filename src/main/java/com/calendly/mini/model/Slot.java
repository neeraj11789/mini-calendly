package com.calendly.mini.model;

import com.calendly.mini.model.vo.UserName;

import java.time.LocalDate;
import java.util.UUID;

/**
 * @NOTE: This can be decomposed further
 */
public class Slot {

    private String id = UUID.randomUUID().toString();

    private LocalDate date;

    private int startTime;

    private int endTime;

    private UserName slotUser;

    private SlotStatus slotStatus;

    private UserName bookedBy;

    private long createdAt;

    private long bookedAt;
}