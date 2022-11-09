package ru.zzaharovs.mvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.zzaharovs.mvc.model.ExceptionResponse;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ExceptionHandlerController {


    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleAccessException(ConstraintViolationException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(400, ex.getMessage()));
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleAccessException(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ExceptionResponse(500, "Unknown error"));
    }


}
