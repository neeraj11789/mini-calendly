package com.calendly.mini.model;

import com.calendly.mini.model.entity.SlotEntity;
import com.calendly.mini.request.CreateSlotRequest;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Data
public class SlotCalendar {

    private String id = UUID.randomUUID().toString();

    private LocalDate date;

    private List<SingleSlot> slots;

    private String slotUser;

    private SlotStatus slotStatus;

    private String bookedBy;

    private long createdAt;

    private long bookedAt;

    /**
     * Constructor for creating slot calendar
     * @param request
     */
    public SlotCalendar(CreateSlotRequest request) {
        this.slotUser = request.getUser();
        this.date = request.getDate();
        this.slots = request.getSlots();
        this.slotStatus = SlotStatus.FREE;
    }

    /**
     * Create List of Entity Objects
     * @return
     */
    public List<SlotEntity> toEntity(){
        List<SlotEntity> list = new ArrayList<>();
        Iterator<SingleSlot> iterator = slots.iterator();
        while (iterator.hasNext()){
            SingleSlot singleSlot = iterator.next();
            // Create Entity
            SlotEntity slotEntity = new SlotEntity();
            slotEntity.setUserId(slotUser);
            slotEntity.setForDate(date);
            slotEntity.setBookingStatus(slotStatus.ordinal());
            slotEntity.setStartTime(singleSlot.getStartTime());
            slotEntity.setEndTime(singleSlot.getEndTime());
            slotEntity.setCreatedOn(LocalDateTime.now());
            // add to list
            list.add(slotEntity);
        }
        return list;
    }
}