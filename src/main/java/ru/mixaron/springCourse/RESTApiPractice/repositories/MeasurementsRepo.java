package ru.mixaron.springCourse.RESTApiPractice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mixaron.springCourse.RESTApiPractice.Model.Measurements;
import ru.mixaron.springCourse.RESTApiPractice.Model.Sensor;

import java.util.Optional;

@Repository
public interface MeasurementsRepo extends JpaRepository<Measurements, Integer> {

//    Optional<Measurements> findBySensor(Sensor sensor);
}
