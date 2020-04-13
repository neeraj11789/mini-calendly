package com.calendly.mini.request;

import com.calendly.mini.model.SingleSlot;
import com.calendly.mini.model.SlotCalendar;
import com.calendly.mini.utils.Constants;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Data
public class BookSlotRequest implements Serializable {
    private static final long serialVersionUID = -3882571123392034391L;

    private String requestId = UUID.randomUUID().toString();

    private String user;

    private LocalDate date;

    private SingleSlot slot;

    private String requestfromUser;

    /**
     * Validate the booking request
     * @return
     */
    public boolean isValid(){
        Objects.requireNonNull(user, Constants.NULL_USER);
        Objects.requireNonNull(date, Constants.NULL_DATE);
        Objects.requireNonNull(requestfromUser, Constants.NULL_USER);

        if(!SlotCalendar.isValidDate(date))
            throw new IllegalArgumentException(Constants.INVALID_DATE);

        if(SingleSlot.isInValidSlot(slot))
            throw new IllegalArgumentException(Constants.INVALID_SLOT);

        return true;
    }
}
