package com.knowvationlearning.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<MyErrorDetails> studentNotFoundHanlder(StudentNotFoundException snf, WebRequest wr){
        MyErrorDetails error = new MyErrorDetails(LocalDateTime.now(), snf.getMessage(), wr.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
