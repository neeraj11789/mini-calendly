package com.calendly.mini.model;

public enum SlotStatus {
    FREE(1, "Free Slot"),
    PENDING(2, "Pending Request"),
    BOOKED(3, "Booked Slot");

    SlotStatus(int id, String name) {

    }
}