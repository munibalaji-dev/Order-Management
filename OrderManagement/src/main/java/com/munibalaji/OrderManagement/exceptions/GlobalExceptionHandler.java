package com.munibalaji.OrderManagement.exceptions;
import com.munibalaji.OrderManagement.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionDto> resourceNotFound(ResourceNotFoundException resourceNotFoundException){

        ExceptionDto exceptionDto = new ExceptionDto(
                HttpStatus.NOT_FOUND,
                resourceNotFoundException.getMessage()
        );

        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);

    }




    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneric(Exception ex){

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An unexpected error occured "+ex.getMessage());
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> validationExceptions(MethodArgumentNotValidException methodArgumentNotValidException){

        Map<String, String> errors = new HashMap<>();

        methodArgumentNotValidException.getBindingResult().getFieldErrors().forEach(error->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
