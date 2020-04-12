package com.calendly.mini.exception;

import com.calendly.mini.response.ResponseDTO;
import com.calendly.mini.utils.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

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
        ResponseDTO<ErrorDTO> responseDTO = new ResponseDTO<>();
        responseDTO.setCode(ResponseCode.BAD_REQUEST);
        ErrorDTO errorDTO = null;
        HttpStatus httpStatus = null;
        if (ex instanceof Exception) {
            errorDTO = new ErrorDTO(ex.getClass().getName(), ex.getMessage());
            log.error("Exception {}", ex);
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        responseDTO.setPayload(errorDTO);
        return new ResponseEntity<>(responseDTO, httpStatus);
    }

    /**
     * Handle the Application Exceptions here
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleServerExceptions(Exception ex) {
        ResponseDTO<ErrorDTO> responseDTO = new ResponseDTO<>();
        responseDTO.setCode(ResponseCode.INTERNAL_SERVER_ERROR);
        ErrorDTO errorDTO = null;
        HttpStatus httpStatus = null;

        if (ex instanceof Exception) {
            errorDTO = new ErrorDTO(ex.getClass().getName(), ex.getMessage());
            log.error("Exception {}", ex);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        responseDTO.setPayload(errorDTO);
        return new ResponseEntity<>(responseDTO, httpStatus);

    }
}
