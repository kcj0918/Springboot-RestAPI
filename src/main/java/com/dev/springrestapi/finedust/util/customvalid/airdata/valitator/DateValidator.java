package com.dev.springrestapi.finedust.util.customvalid.airdata.valitator;

import com.dev.springrestapi.finedust.util.customvalid.airdata.valid.DateFormatValid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidator implements ConstraintValidator<DateFormatValid, String> {

    @Override
    public void initialize(DateFormatValid constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime.parse(value, dateTimeFormatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
