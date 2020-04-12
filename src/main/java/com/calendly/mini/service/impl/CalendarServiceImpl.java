package com.calendly.mini.service.impl;

import com.calendly.mini.exception.InternalServerException;
import com.calendly.mini.model.SingleSlot;
import com.calendly.mini.model.SlotCalendar;
import com.calendly.mini.model.entity.SlotEntity;
import com.calendly.mini.persist.dao.SlotDao;
import com.calendly.mini.request.CreateSlotRequest;
import com.calendly.mini.response.MessageResponse;
import com.calendly.mini.service.CalendarService;
import com.calendly.mini.utils.Constants;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Iterator;

@Slf4j
@Service
@RequiredArgsConstructor
public class CalendarServiceImpl implements CalendarService {

    @NonNull
    private SlotDao dao;

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
                dao.save(entity);
            }
            response.setMessage(Constants.SLOTS_ADDED);
        }catch (Exception e){
            log.error("Unable to add the Slots in the Users calendar", e);
            throw new InternalServerException(Constants.INTERNAL_ERROR);
        }
        return response;
    }

    @Override
    public void bookSlot(String userName, LocalDate date, SingleSlot singleSlot) {

    }
}
