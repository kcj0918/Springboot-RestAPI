package com.dev.springrestapi.finedust.util.exception.exceptionhandler;

import com.dev.springrestapi.finedust.util.exception.airdata.AirDataRequestWrongFormatException;
import com.dev.springrestapi.finedust.util.Strings;
import com.dev.springrestapi.util.res.DefaultResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.dev.springrestapi.finedust.controller")
public class FineDustExceptionHandler {
    @ExceptionHandler({AirDataRequestWrongFormatException.class})
    public ResponseEntity<DefaultResponse> dateValidException() {
        return new ResponseEntity<>(new DefaultResponse(
                DefaultResponse.Status.FAIL, Strings.WRONG_FORMAT_AIR_DATA_REQUEST_DTO),
                HttpStatus.BAD_REQUEST);
    }
}
