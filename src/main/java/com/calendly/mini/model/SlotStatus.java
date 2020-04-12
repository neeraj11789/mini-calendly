package com.calendly.mini.model;

/**
 * Slot Status
 */
public enum SlotStatus {
    FREE(0, "Free Slot"),
    BOOKED(1, "Booked Slot");

    SlotStatus(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private int id;
    private String name;
}