package com.dev.springrestapi.corona.util.exception.exceptionhandler;

import com.dev.springrestapi.corona.util.Strings;

import com.dev.springrestapi.corona.util.exception.corona.CoronaRequestWrongFormatException;
import com.dev.springrestapi.util.res.DefaultResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.dev.springrestapi.corona.controller")
public class CoronaExceptionHandler {

    @ExceptionHandler({CoronaRequestWrongFormatException.class})
    public ResponseEntity<DefaultResponse> dateValidException() {
        return new ResponseEntity<>(new DefaultResponse(
                DefaultResponse.Status.FAIL, Strings.WRONG_FORMAT_CORONA_REQUEST_DTO
                ), HttpStatus.BAD_REQUEST);
    }
}
