package com.calendly.mini.controller;

import com.calendly.mini.exception.BadRequestException;
import com.calendly.mini.request.AuthUserRequest;
import com.calendly.mini.request.RegisterUserRequest;
import com.calendly.mini.response.AuthUserResponse;
import com.calendly.mini.response.RegisterUserResponse;
import com.calendly.mini.response.ResponseDTO;
import com.calendly.mini.service.UserService;
import com.calendly.mini.util.Constants;
import com.calendly.mini.util.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
        RegisterUserResponse response = service.register(request);
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
    public AuthUserResponse authenticate(@RequestBody AuthUserRequest request){
        if(!request.isValid())
            throw new BadRequestException(Constants.BAD_REQUEST);

        AuthUserResponse response = new AuthUserResponse(request.getRequestId());
        try {
            service.authenticate(request);
            response.setMessage("Authenticated");
        }catch (Exception e){
            response.setMessage("Forbidden");
        }
        return response;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    ResponseEntity<String> home() {
        String st = "Hello World";
        return new ResponseEntity<String>(st, HttpStatus.OK);
    }
}