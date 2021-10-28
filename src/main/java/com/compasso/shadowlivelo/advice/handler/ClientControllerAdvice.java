package com.compasso.shadowlivelo.advice.handler;

import com.compasso.shadowlivelo.advice.exception.DateException;
import com.compasso.shadowlivelo.advice.exception.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ClientControllerAdvice {

    @ExceptionHandler(DateException.class)
    public ResponseEntity<ErrorMessage> dateException (DateException dateException, HttpServletRequest httpServletRequest) {
        ErrorMessage errorMessages = new ErrorMessage("Exception:Wrong birth date", dateException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessages);
    }

}
