package com.example.StockValueApp.handler;

import com.example.StockValueApp.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class UserExceptionHandler {
    @ExceptionHandler(MandatoryFieldsMissingException.class)
    public ResponseEntity<Object> handleMandatoryFieldException(MandatoryFieldsMissingException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NoUsersFoundException.class)
    public ResponseEntity<Object> handleNoUsersFoundException(NoUsersFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UserAlreadyExist.class)
    public ResponseEntity<Object> handleUserAlreadyExistException(UserAlreadyExist e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(IncorrectEmailFormatException.class)
    public ResponseEntity<Object> incorrectEmailFormatException(IncorrectEmailFormatException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmailAlreadyExist.class)
    public ResponseEntity<Object> emailAlreadyExist(EmailAlreadyExist e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }
}
