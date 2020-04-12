package com.calendly.mini.controller;


import com.calendly.mini.exception.BadRequestException;
import com.calendly.mini.request.BookSlotRequest;
import com.calendly.mini.request.CreateSlotRequest;
import com.calendly.mini.response.MessageResponse;
import com.calendly.mini.response.ResponseDTO;
import com.calendly.mini.service.CalendarService;
import com.calendly.mini.utils.Constants;
import com.calendly.mini.utils.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CalendarController {

    @Autowired
    CalendarService service;

    @RequestMapping(value = "/create-slots", method = RequestMethod.POST)
    public ResponseEntity<ResponseDTO> createSlots(@RequestBody CreateSlotRequest request){
        if(!request.isValid())
            throw new BadRequestException(Constants.BAD_REQUEST);

        // Create Available Slots
        MessageResponse response = service.createSlot(request);
        response.setRequestId(request.getRequestId());

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode(ResponseCode.RESOURCE_CREATED);
        responseDTO.setPayload(response);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/book-slot", method = RequestMethod.POST)
    public ResponseEntity<ResponseDTO> bookSlot(@RequestBody BookSlotRequest request){
        ResponseDTO responseDTO = new ResponseDTO();

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


}
