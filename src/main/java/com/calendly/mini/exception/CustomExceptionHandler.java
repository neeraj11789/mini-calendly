package com.calendly.mini.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.concurrent.CompletionException;

@Slf4j
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequestException(Exception ex) {
        Error error = null;

        if (ex instanceof CompletionException) {
            ex = (Exception) ex.getCause();
        }
        error = new Error("BAD REQUEST", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleServerExceptions(Exception ex) {
        Response<Error> responseDTO = new Response<>();
        responseDTO.setSuccess(false);
        Error error = null;
        HttpStatus httpStatus = null;

        if (ex instanceof CompletionException) {
            ex = (Exception) ex.getCause();
        }

        if (ex instanceof Exception) {
            error = new Error(ex.getClass().getName(), ex.getMessage());
            log.error("Exception {}", ex);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        responseDTO.setPayload(error);
        return new ResponseEntity<>(responseDTO, httpStatus);

    }
}
