package com.dev.springrestapi.corona.util.customvalid.corona.valid;

import com.dev.springrestapi.corona.util.Strings;
import com.dev.springrestapi.corona.util.customvalid.corona.validator.DateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateValidator.class)
public @interface DateFormatValid {

    String message() default Strings.WRONG_FORMAT_CORONA_REQUEST_DTO;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};

}
