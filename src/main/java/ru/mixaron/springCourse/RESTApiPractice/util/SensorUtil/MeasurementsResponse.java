package ru.mixaron.springCourse.RESTApiPractice.util.SensorUtil;

import ru.mixaron.springCourse.RESTApiPractice.dto.MeasurementsDTO;

import java.util.List;

public class MeasurementsResponse {
    private List<MeasurementsDTO> measurementsDTOList;

    public MeasurementsResponse(List<MeasurementsDTO> measurementsDTOList) {
        this.measurementsDTOList = measurementsDTOList;
    }
    public List<MeasurementsDTO> getMeasurementsDTOList() {
        return measurementsDTOList;
    }

    public void setMeasurementsDTOList(List<MeasurementsDTO> measurementsDTOList) {
        this.measurementsDTOList = measurementsDTOList;
    }
}
