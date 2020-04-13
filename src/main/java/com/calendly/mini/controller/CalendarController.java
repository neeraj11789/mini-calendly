package com.calendly.mini.controller;

import com.calendly.mini.exception.BadRequestException;
import com.calendly.mini.exception.InvalidCredentialsException;
import com.calendly.mini.model.entity.SessionEntity;
import com.calendly.mini.request.BookSlotRequest;
import com.calendly.mini.request.CreateSlotRequest;
import com.calendly.mini.response.MessageResponse;
import com.calendly.mini.response.ResponseDTO;
import com.calendly.mini.service.CalendarService;
import com.calendly.mini.service.UserService;
import com.calendly.mini.utils.Constants;
import com.calendly.mini.utils.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
public class CalendarController {

    @Autowired
    CalendarService service;

    @Autowired
    UserService userService;


    /**
     * Define the available slots for a user
     * @param request
     * @return
     */
    @RequestMapping(value = "/create-slots", method = RequestMethod.POST)
    public ResponseEntity<ResponseDTO> createSlots(@RequestHeader("access-key") String accessKey,
                                                   @RequestHeader("secret-key") String secretKey,
                                                   @RequestBody CreateSlotRequest request){

        if(!request.isValid())
            throw new BadRequestException(Constants.BAD_REQUEST);

        authenticate(request, accessKey, secretKey);

        // Create Available Slots
        MessageResponse response = service.createSlot(request);
        response.setRequestId(request.getRequestId());

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode(ResponseCode.RESOURCE_CREATED);
        responseDTO.setPayload(response);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * Check if user is authenticated. Should pass the keys in headers
     * @param request
     * @param accessKey
     * @param secretKey
     */
    private void authenticate(CreateSlotRequest request, String accessKey, String secretKey) {
        // check user exists in the system
        userService.userExists(request.getUser());

        // verify access key and secret key
        Optional<SessionEntity> optionalSessionEntity = userService.sessionExists(request.getUser());
        if(!optionalSessionEntity.isPresent())
            throw new InvalidCredentialsException(Constants.UNAUTHORIZED_ACCESS);

        SessionEntity sessionEntity = optionalSessionEntity.get();
        if(!sessionEntity.getSecretKey().equals(secretKey) || !sessionEntity.getAccessKey().equals(accessKey))
            throw new InvalidCredentialsException(Constants.UNAUTHORIZED_ACCESS);
    }

    /**
     * Book A Slot from a Users Calendar if available
     * @param request
     * @return
     */
    @RequestMapping(value = "/book-slot", method = RequestMethod.POST)
    public ResponseEntity<ResponseDTO> bookSlot(@RequestBody BookSlotRequest request){
        if(!request.isValid())
            throw new BadRequestException(Constants.BAD_REQUEST);

        // Create Available Slots
        MessageResponse response = service.bookSlot(request);
        response.setRequestId(request.getRequestId());

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode(ResponseCode.SUCCESS);
        responseDTO.setPayload(response);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
