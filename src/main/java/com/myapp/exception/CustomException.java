package com.myapp.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public class CustomException extends RuntimeException {
    private final String dtoErrorMessage;
    private final HttpStatus errorStatus;

    public CustomException(String causeMessage, String dtoErrorMessage, HttpStatus errorStatus) {
        super(causeMessage);
        this.dtoErrorMessage = dtoErrorMessage;
        this.errorStatus = errorStatus;
    }

}

