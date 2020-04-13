package com.calendly.mini.request;

import com.calendly.mini.model.SingleSlot;
import com.calendly.mini.model.SlotCalendar;
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

        if(!SlotCalendar.isValidDate(date))
            throw new IllegalArgumentException(Constants.INVALID_DATE);

        Iterator<SingleSlot> slotIterator = slots.iterator();
        while (slotIterator.hasNext()){
            SingleSlot slot = slotIterator.next();
            if(SingleSlot.isInValidSlot(slot))
                throw new IllegalArgumentException(Constants.INVALID_SLOT);
        }

        return true;
    }

}