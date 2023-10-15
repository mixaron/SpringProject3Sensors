package ru.mixaron.springCourse.RESTApiPractice.util.SensorUtil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.mixaron.springCourse.RESTApiPractice.Model.Measurements;
import ru.mixaron.springCourse.RESTApiPractice.services.MeasurementsService;

import java.util.List;

@Component
public class GetOutput {
    private final MeasurementsService measurementsService;


    public GetOutput(MeasurementsService measurementsService) {
        this.measurementsService = measurementsService;
    }
    public String getList() {
        List<Measurements> measurements = measurementsService.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(measurements);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
//    StringBuilder message = new StringBuilder();
//        for (Measurements measurements1 : measurements) {
//        message.append("Температура: ").append(measurements1.getValue()).append(" ")
//                .append("Дождь: ").append(measurements1.isRaining()).append(" ")
//                .append(" Датчик: ").append(measurements1.getSensor().getName()).append("\n");
//    }
//        return message.toString();
//}
    public String rainyDays() {
        List<Measurements> measurements = measurementsService.findAll();
        int result = 0;
        for (Measurements measurements1 : measurements) {
            if (measurements1.isRaining()) {
                result++;
            }
        }
        return "Количество дождливых дней: " + result;
    }


}
