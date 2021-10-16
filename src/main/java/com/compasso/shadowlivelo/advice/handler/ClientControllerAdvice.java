package com.compasso.shadowlivelo.advice.handler;

import com.compasso.shadowlivelo.advice.exception.AgeException;
import com.compasso.shadowlivelo.advice.exception.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ClientControllerAdvice {

    @ExceptionHandler(AgeException.class)
    public ResponseEntity<ErrorMessage> ageException(AgeException ageException, HttpServletRequest httpServletRequest) {
        ErrorMessage errorMessage = new ErrorMessage("AgeException: Please, verify your birthdate or age", ageException.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }



}
