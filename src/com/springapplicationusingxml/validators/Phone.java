package com.springapplicationusingxml.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by muhammadkhan on 10/1/16.
 */
@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {
    String message() default "${user.valid.phoneCorrect}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
