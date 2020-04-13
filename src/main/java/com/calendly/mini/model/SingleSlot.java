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

    /**
     * Validate the Slot
     * @param slot
     * @return
     */
    public static boolean isInValidSlot(SingleSlot slot) {
        int startTime = slot.getStartTime();
        int endTime = slot.getEndTime();

        boolean cond1 = startTime%100 != 0 || endTime%100 != 0;
        boolean cond2 = startTime < 100 || startTime > 2400;
        boolean cond3 = endTime < 100 || endTime > 2400;
        boolean cond4 = endTime < startTime;

        return cond1 || cond2 || cond3 || cond4;
    }
}