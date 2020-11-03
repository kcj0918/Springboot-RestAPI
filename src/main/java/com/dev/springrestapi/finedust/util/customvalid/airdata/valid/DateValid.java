package com.dev.springrestapi.finedust.util.customvalid.airdata.valid;

import com.dev.springrestapi.finedust.util.Strings;
import com.dev.springrestapi.finedust.util.customvalid.airdata.valitator.DateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateValidator.class)
public @interface DateValid {
    String message() default Strings.WRONG_LOCAL_DATE_TIME;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
