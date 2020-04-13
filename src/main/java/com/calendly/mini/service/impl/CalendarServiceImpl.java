package com.calendly.mini.service.impl;

import com.calendly.mini.exception.InternalServerException;
import com.calendly.mini.exception.UnavailableException;
import com.calendly.mini.model.SlotCalendar;
import com.calendly.mini.model.SlotStatus;
import com.calendly.mini.model.entity.SlotEntity;
import com.calendly.mini.persist.dao.SlotDao;
import com.calendly.mini.request.BookSlotRequest;
import com.calendly.mini.request.CreateSlotRequest;
import com.calendly.mini.response.MessageResponse;
import com.calendly.mini.service.CalendarService;
import com.calendly.mini.service.UserService;
import com.calendly.mini.utils.Constants;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CalendarServiceImpl implements CalendarService {

    @NonNull
    private SlotDao dao;

    @NonNull
    private UserService userService;

    /**
     * Create Slot for the User
     * @param request
     * @return
     */
    @Override
    public MessageResponse createSlot(CreateSlotRequest request) {
        MessageResponse response = new MessageResponse(request.getRequestId());
        SlotCalendar slotCalendar = new SlotCalendar(request);
        try {
            Iterator<SlotEntity> slots = slotCalendar.toEntity().iterator();
            while (slots.hasNext()){
                SlotEntity entity = slots.next();
                // check if it is duplicate - else save
                Optional<SlotEntity> optionalSlotEntity = dao.getAvailableSlot(entity.getForDate(),
                        entity.getStartTime(), SlotStatus.FREE.ordinal(), entity.getUserId());
                if(!optionalSlotEntity.isPresent())
                    dao.save(entity);
            }
            response.setMessage(Constants.SLOTS_ADDED);
        }catch (Exception e){
            log.error("Unable to add the Slots in the Users calendar", e);
            throw new InternalServerException(Constants.INTERNAL_ERROR);
        }
        return response;
    }

    /**
     * Book a slot if available
     * @param request
     * @return
     */
    @Override
    public MessageResponse bookSlot(BookSlotRequest request) {
        MessageResponse response = new MessageResponse(request.getRequestId());

        // check if user exist in system
        if(!userService.userExists(request.getUser()))
            throw new IllegalArgumentException(Constants.USER_NOT_FOUND);

        // query for available slots on the requested date for the user
        Optional<SlotEntity> optionalSlotEntity = dao.getAvailableSlot(request.getDate(), request.getSlot().getStartTime()
                , SlotStatus.FREE.ordinal(), request.getUser());
        if(!optionalSlotEntity.isPresent())
            throw new UnavailableException(Constants.SLOT_UNAVAILABLE);

        // update the slot with requesting user details and new status
        SlotEntity slotEntity = optionalSlotEntity.get();
        slotEntity.setBookingStatus(SlotStatus.BOOKED.ordinal());
        slotEntity.setBookedByUser(request.getRequestfromUser());
        dao.save(slotEntity);

        response.setMessage(Constants.SLOT_BOOKED);
        return response;
    }
}
