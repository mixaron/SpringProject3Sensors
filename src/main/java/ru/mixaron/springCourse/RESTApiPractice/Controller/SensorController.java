package ru.mixaron.springCourse.RESTApiPractice.Controller;


import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.mixaron.springCourse.RESTApiPractice.Model.Sensor;
import ru.mixaron.springCourse.RESTApiPractice.dto.SensorDTO;
import ru.mixaron.springCourse.RESTApiPractice.services.SensorService;
import ru.mixaron.springCourse.RESTApiPractice.util.ErrorResponse;
import ru.mixaron.springCourse.RESTApiPractice.util.ErrorsOutput;
import ru.mixaron.springCourse.RESTApiPractice.util.NotCreatedException;
import ru.mixaron.springCourse.RESTApiPractice.util.SensorUtil.SensorValidator;


@RestController
@RequestMapping("/sensors")
public class SensorController {

    private final SensorService sensorService;
    private final ModelMapper modelMapper;

    private final ErrorsOutput errorsOutput;

    private final SensorValidator sensorValidator;

    public SensorController(SensorService sensorService, ModelMapper modelMapper, ErrorsOutput errorsOutput, SensorValidator sensorValidator) {
        this.sensorService = sensorService;
        this.modelMapper = modelMapper;
        this.errorsOutput = errorsOutput;
        this.sensorValidator = sensorValidator;
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid SensorDTO sensorDTO, BindingResult bindingResult) {
        sensorValidator.validate(sensorDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            errorsOutput.output(bindingResult);
        }
        sensorService.save(convertToSensor(sensorDTO));

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handlerException(NotCreatedException e) {
        ErrorResponse sensorErrorResponse = new ErrorResponse(e.getMessage(), System.currentTimeMillis());
        return  new ResponseEntity<>(sensorErrorResponse, HttpStatus.BAD_REQUEST);
    }

    private SensorDTO convertToSensorDTO(Sensor sensor) {
            return modelMapper.map(sensor, SensorDTO.class);
    }

    private Sensor convertToSensor(SensorDTO sensor) {
        return modelMapper.map(sensor, Sensor.class);
    }
}
