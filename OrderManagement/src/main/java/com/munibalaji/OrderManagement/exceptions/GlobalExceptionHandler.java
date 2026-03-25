package com.munibalaji.OrderManagement.exceptions;

import com.munibalaji.OrderManagement.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionDto> resourceNotFound(ResourceNotFoundException resourceNotFoundException){

        return new ResponseEntity<>(new ExceptionDto(HttpStatus.NOT_FOUND, resourceNotFoundException.getMessage()),HttpStatus.NOT_FOUND);
    }
}
