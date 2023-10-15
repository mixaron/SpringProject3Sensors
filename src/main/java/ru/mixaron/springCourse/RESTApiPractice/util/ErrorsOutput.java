package ru.mixaron.springCourse.RESTApiPractice.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

@Component
public class ErrorsOutput {
    public void output(BindingResult bindingResult) {
        StringBuilder message = new StringBuilder();
        List<FieldError> errors =bindingResult.getFieldErrors();
        for (FieldError error : errors) {
            message.append(error.getField()).append(" - ").append(error.getDefaultMessage()).append(";");
        }
        throw new NotCreatedException(message.toString());
    }
}
