package ru.mixaron.springCourse.RESTApiPractice.util.MeasurementsUtil;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.stereotype.Component;
import ru.mixaron.springCourse.RESTApiPractice.Model.Measurements;
import ru.mixaron.springCourse.RESTApiPractice.Model.Sensor;
import ru.mixaron.springCourse.RESTApiPractice.services.MeasurementsService;
import ru.mixaron.springCourse.RESTApiPractice.services.SensorService;

@Component
public class MeasurementsValidator implements Validator {
    private final MeasurementsService measurementsService;
    private final SensorService sensorService;

    public MeasurementsValidator(MeasurementsService measurementsService, SensorService sensorService) {
        this.measurementsService = measurementsService;
        this.sensorService = sensorService;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Measurements measurements = (Measurements) target;
        if (sensorService.findByName(measurements.getSensor().getName()) == null) {
            errors.rejectValue("sensor" , "" , "This name is not availible");
        }
    }
}
