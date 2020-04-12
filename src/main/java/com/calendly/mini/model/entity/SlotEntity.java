package com.calendly.mini.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "slots")
@Data
@Entity
public class SlotEntity {

    @Id
    @Column(name = "slot_id")
    private String slotId = UUID.randomUUID().toString();

    @Column(name = "user_id")
    private String userId;

    @Column(name = "date")
    private LocalDate forDate;

    @Column(name = "start_time")
    private int startTime;

    @Column(name = "end_time")
    private int endTime;

    @Column(name = "status")
    private int bookingStatus;

    @Column(name = "booked_by_user")
    private String bookedByUser;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "booked_on")
    private LocalDateTime bookedOn;
}
