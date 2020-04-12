package com.calendly.mini.request;

import com.calendly.mini.model.SingleSlot;
import com.calendly.mini.utils.Constants;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Data
public class CreateSlotRequest implements Serializable {

    private static final long serialVersionUID = -3882571123392034391L;

    private String requestId = UUID.randomUUID().toString();

    private String user;

    private LocalDate date;

    private List<SingleSlot> slots;

    /**
     * Validate the Request Object
     * @return
     */
    public boolean isValid(){
        Objects.requireNonNull(user, Constants.NULL_USER);
        Objects.requireNonNull(date, Constants.NULL_DATE);
        if(slots.size() < 1)
            throw new IllegalArgumentException(Constants.NULL_SLOT);

        if(!isValidDate())
            throw new IllegalArgumentException(Constants.INVALID_DATE);

        Iterator<SingleSlot> slotIterator = slots.iterator();
        while (slotIterator.hasNext()){
            SingleSlot slot = slotIterator.next();
            if(!isValidSlot(slot))
                throw new IllegalArgumentException(Constants.INVALID_SLOT);
        }

        return true;
    }

    /**
     * Validate the Slot
     * @param slot
     * @return
     */
    private boolean isValidSlot(SingleSlot slot) {
        int startTime = slot.getStartTime();
        int endTime = slot.getEndTime();

        boolean cond1 = startTime%100 != 0 || endTime%100 != 0;
        boolean cond2 = startTime < 100 || startTime > 2400;
        boolean cond3 = endTime < 100 || endTime > 2400;
        boolean cond4 = endTime > startTime;

        return cond1 || cond2 || cond3 || cond4;
    }

    /**
     * The Date passed should not be older than todays date
     * @return
     */
    private boolean isValidDate() {
        return date.isAfter(LocalDate.now());
    }

}