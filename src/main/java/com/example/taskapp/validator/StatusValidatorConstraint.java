package com.example.taskapp.validator;


import com.example.taskapp.enums.task.Status;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class StatusValidatorConstraint implements ConstraintValidator<StatusValidator, Status> {

    private Status[] statuses;

    @Override
    public void initialize(StatusValidator constraint) {
        this.statuses = constraint.statuses();
    }

    @Override
    public boolean isValid(Status value, ConstraintValidatorContext context) {
        return value == null || Arrays.asList(statuses).contains(value);
    }
}
