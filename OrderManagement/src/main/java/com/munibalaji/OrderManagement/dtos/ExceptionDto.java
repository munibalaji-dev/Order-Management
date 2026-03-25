package com.munibalaji.OrderManagement.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ExceptionDto {

    private HttpStatus httpStatus;
    private String message;

    public ExceptionDto(HttpStatus httpStatus,
                        String message){

        this.message = message;
        this.httpStatus = httpStatus;
    }
}
