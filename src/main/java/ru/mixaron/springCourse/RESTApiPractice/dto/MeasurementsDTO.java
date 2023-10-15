    package ru.mixaron.springCourse.RESTApiPractice.dto;

    import jakarta.persistence.Column;
    import jakarta.persistence.Id;
    import jakarta.persistence.JoinColumn;
    import jakarta.persistence.ManyToOne;
    import jakarta.validation.constraints.*;
    import lombok.Getter;
    import lombok.Setter;
    import ru.mixaron.springCourse.RESTApiPractice.Model.Sensor;

    import java.util.Date;

    @Getter
    @Setter
    public class MeasurementsDTO {


        @NotNull(message = "Value cannot be empty!")
        @Min(value = -100,message = "Cant be less -100")
        @Max(value = 100,message = "Cant be biggest 100")
        private double value;

        @NotNull(message = "isRaining cannot be empty!")
        private boolean raining;



        @NotNull(message = "name cannot be empty!")
        private SensorDTO sensor;


    }
