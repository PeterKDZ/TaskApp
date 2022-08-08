package com.example.taskapp.validator;

import com.example.taskapp.enums.task.Status;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StatusValidatorConstraint.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface StatusValidator {
    Status[] statuses();
    String message() default "Status must be one of the statuses {statuses}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
