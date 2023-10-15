package ru.mixaron.springCourse.RESTApiPractice.util.SensorUtil;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.mixaron.springCourse.RESTApiPractice.dto.SensorDTO;
import ru.mixaron.springCourse.RESTApiPractice.services.SensorService;

@Component
public class SensorValidator implements Validator {

    private final SensorService sensorService;

    public SensorValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SensorDTO sensorDTO = (SensorDTO) target;
        if (sensorService.findByName(sensorDTO.getName()) != null) {
            errors.rejectValue("name" , "" , "This name is already taken");
        }
    }
}
