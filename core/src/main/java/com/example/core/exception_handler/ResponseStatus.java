package com.example.core.exception_handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ResponseStatus {
    INTERNAL_SERVER_ERROR(1, HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error"),
    INVALID_LANGUAGE(2, HttpStatus.BAD_REQUEST, "Invalid language provided"),
    REQUEST_PARAMETER_NOT_FOUND(3, HttpStatus.BAD_REQUEST, "Request parameter not found"),
    CUSTOMER_NOT_FOUND(100, HttpStatus.NOT_FOUND, "No customer found");


    private final Integer statusCode;
    private final HttpStatus httpStatus;
    private final String description;
}
