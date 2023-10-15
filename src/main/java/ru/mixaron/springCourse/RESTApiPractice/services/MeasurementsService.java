package ru.mixaron.springCourse.RESTApiPractice.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.mixaron.springCourse.RESTApiPractice.Model.Measurements;
import ru.mixaron.springCourse.RESTApiPractice.Model.Sensor;
import ru.mixaron.springCourse.RESTApiPractice.dto.MeasurementsDTO;
import ru.mixaron.springCourse.RESTApiPractice.repositories.MeasurementsRepo;
import ru.mixaron.springCourse.RESTApiPractice.repositories.SensorRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MeasurementsService {

    private final MeasurementsRepo measurementsRepo;

    private final SensorService sensorService;

    public MeasurementsService(MeasurementsRepo measurementsRepo, SensorService sensorService) {
        this.measurementsRepo = measurementsRepo;
        this.sensorService = sensorService;
    }

    public Measurements findOne(int id) {
        Optional<Measurements> measurements = measurementsRepo.findById(id);
        return measurements.orElse(null);
    }

    public List<Measurements> findAll() {
        return  measurementsRepo.findAll();
    }

//    public Measurements findByOwner(Sensor sensor) {
//
//    }

    public void save(Measurements measurements) {
        String sensorName = measurements.getSensor().getName();
        Sensor sensor = sensorService.findByName(sensorName);
        measurements.setSensor(sensor);
        measurements.setDate(new Date());
        measurementsRepo.save(measurements);
    }




}
