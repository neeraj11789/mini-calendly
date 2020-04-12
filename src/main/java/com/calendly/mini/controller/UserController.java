package com.calendly.mini.controller;

import com.calendly.mini.exception.BadRequestException;
import com.calendly.mini.model.Session;
import com.calendly.mini.request.AuthUserRequest;
import com.calendly.mini.request.RegisterUserRequest;
import com.calendly.mini.response.AuthUserResponse;
import com.calendly.mini.response.MessageResponse;
import com.calendly.mini.response.ResponseDTO;
import com.calendly.mini.service.UserService;
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
public class UserController {

    @Autowired
    UserService service;

    /**
     * Rest Endpoint to create a User
     * @param request
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<ResponseDTO> register(@RequestBody RegisterUserRequest request){
        if(!request.isValid())
            throw new BadRequestException(Constants.BAD_REQUEST);

        // Register User
        MessageResponse response = service.register(request);
        response.setRequestId(request.getRequestId());

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode(ResponseCode.RESOURCE_CREATED);
        responseDTO.setPayload(response);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * Authenticate the User Information and Return Session Information
     * @param request
     * @return
     */
    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity<ResponseDTO> authenticate(@RequestBody AuthUserRequest request){
        if(!request.isValid())
            throw new BadRequestException(Constants.BAD_REQUEST);

        ResponseDTO responseDTO = new ResponseDTO();
        AuthUserResponse response = new AuthUserResponse(request.getRequestId());

        Session session = service.authenticate(request);
        response.setSession(session);
        responseDTO.setCode(ResponseCode.SUCCESS);
        responseDTO.setPayload(response);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    ResponseEntity<String> home() {
        String st = "Hello World";
        return new ResponseEntity<String>(st, HttpStatus.OK);
    }
}