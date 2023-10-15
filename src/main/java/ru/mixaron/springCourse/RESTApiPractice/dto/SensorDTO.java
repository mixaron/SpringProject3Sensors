package ru.mixaron.springCourse.RESTApiPractice.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class SensorDTO {
    @NotEmpty(message = "Name of the sensor cannot be empty")
    @Size(min = 3, max = 30, message = "Name of the sensor must be on between 3 and 30 symbols")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
