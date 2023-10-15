package ru.mixaron.springCourse.RESTApiPractice.Controller;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.mixaron.springCourse.RESTApiPractice.Model.Measurements;
import ru.mixaron.springCourse.RESTApiPractice.Model.Sensor;
import ru.mixaron.springCourse.RESTApiPractice.dto.MeasurementsDTO;

import ru.mixaron.springCourse.RESTApiPractice.services.MeasurementsService;
import ru.mixaron.springCourse.RESTApiPractice.util.ErrorResponse;
import ru.mixaron.springCourse.RESTApiPractice.util.ErrorsOutput;
import ru.mixaron.springCourse.RESTApiPractice.util.MeasurementsUtil.MeasurementsValidator;
import ru.mixaron.springCourse.RESTApiPractice.util.NotCreatedException;
import ru.mixaron.springCourse.RESTApiPractice.util.NotFoundException;
import ru.mixaron.springCourse.RESTApiPractice.util.SensorUtil.GetOutput;

@RestController
@RequestMapping("/measurements")
public class MeasurementsController {


    private final MeasurementsService measurementsService;

    private final MeasurementsValidator measurementsValidator;

    private final ModelMapper modelMapper;

    private final GetOutput getOutput;

    private final ErrorsOutput errorsOutput;


    public MeasurementsController(MeasurementsService measurementsService, MeasurementsValidator measurementsValidator,
                                  ModelMapper modelMapper, GetOutput getOutput, ErrorsOutput errorsOutput) {

        this.measurementsService = measurementsService;
        this.measurementsValidator = measurementsValidator;
        this.modelMapper = modelMapper;
        this.getOutput = getOutput;
        this.errorsOutput = errorsOutput;
    }


    @GetMapping
    public String measuring() {
        return getOutput.getList();
    }

    @GetMapping("/rainyDaysCount")
    public String rainyDays() {
        return getOutput.rainyDays();
    }


    @PostMapping("/add")
    public ResponseEntity<HttpStatus> add(@RequestBody @Valid MeasurementsDTO measurementsDTO, BindingResult bindingResult) {
        Measurements measurements = convertToMeas(measurementsDTO);



        measurementsValidator.validate(measurements, bindingResult);
        if (bindingResult.hasErrors()) {
            errorsOutput.output(bindingResult);
        }

        measurementsService.save(measurements);

        return ResponseEntity.ok(HttpStatus.OK);
    }
    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handlerException(NotCreatedException e) {
        ErrorResponse sensorErrorResponse = new ErrorResponse(e.getMessage(), System.currentTimeMillis());
        return  new ResponseEntity<>(sensorErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handlerException(NotFoundException e) {
        ErrorResponse sensorErrorResponse = new ErrorResponse(e.getMessage(), System.currentTimeMillis());
        return  new ResponseEntity<>(sensorErrorResponse, HttpStatus.NOT_FOUND);
    }

    private MeasurementsDTO convertToMeasDTO(Measurements measurements) {
        return modelMapper.map(measurements, MeasurementsDTO.class);
    }

    private Measurements convertToMeas(MeasurementsDTO measurementsDTO) {
        return modelMapper.map(measurementsDTO, Measurements.class);
    }

    private Sensor  convertTOSencor(MeasurementsDTO measurementsDTO) {
        return modelMapper.map(measurementsDTO, Sensor.class);
    }
}
