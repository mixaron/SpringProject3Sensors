package ru.mixaron.springCourse.RESTApiPractice.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mixaron.springCourse.RESTApiPractice.Model.Sensor;
import ru.mixaron.springCourse.RESTApiPractice.repositories.SensorRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional()
public class SensorService {
    private final SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public List<Sensor> findAll() {
        return sensorRepository.findAll();
    }

    public Sensor findOne(int id) {
        Optional<Sensor> sensor = sensorRepository.findById(id);
        return sensor.orElse(null);
    }

    public Sensor findByName(String name) {
        Optional<Sensor> sensor = sensorRepository.findByName(name);
        return sensor.orElse(null);
    }


    public void save(Sensor sensor) {
        sensorRepository.save(sensor);
    }
}
