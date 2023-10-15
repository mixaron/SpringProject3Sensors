package ru.mixaron.springCourse.RESTApiPractice.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Date;

@Entity
@Table(name = "measurements")
public class Measurements {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "value")
    @NotNull(message = "Value cannot be empty!")
    @Min(value = -100,message = "Cant be less -100")
    @Max(value = 100,message = "Cant be biggest 100")
    private Double value;

    @Column(name = "raining")
    @NotNull(message = "isRaining cannot be empty!")
    private boolean isRaining;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "sensor", referencedColumnName = "name")
    @JsonManagedReference
    @NotNull
//    @NotEmpty(message = "name cannot be empty!")
    private Sensor sensor;



    public Measurements(double value, boolean isRaining, Sensor sensor) {
        this.value = value;
        this.isRaining = isRaining;
        this.sensor = sensor;
    }
    public Measurements() {}

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isRaining() {
        return isRaining;
    }

    public void setRaining(boolean raining) {
        isRaining = raining;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor owner) {
        this.sensor = owner;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
