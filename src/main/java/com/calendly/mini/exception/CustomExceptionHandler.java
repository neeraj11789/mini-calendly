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

    /**
     * Handle BadRequest Exceptions here for the application
     * @param ex
     * @return
     */
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequestException(Exception ex) {
        Response<Error> responseDTO = new Response<>();
        responseDTO.setSuccess(false);
        Error error = null;
        HttpStatus httpStatus = null;
        if (ex instanceof Exception) {
            error = new Error(ex.getClass().getName(), ex.getMessage());
            log.error("Exception {}", ex);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        responseDTO.setPayload(error);
        return new ResponseEntity<>(responseDTO, httpStatus);
    }

    /**
     * Handle the Application Exceptions here
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleServerExceptions(Exception ex) {
        Response<Error> responseDTO = new Response<>();
        responseDTO.setSuccess(false);
        Error error = null;
        HttpStatus httpStatus = null;

        if (ex instanceof Exception) {
            error = new Error(ex.getClass().getName(), ex.getMessage());
            log.error("Exception {}", ex);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        responseDTO.setPayload(error);
        return new ResponseEntity<>(responseDTO, httpStatus);

    }
}
