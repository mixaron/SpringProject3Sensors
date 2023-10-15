package ru.mixaron.springCourse.RESTApiPractice.util;

public class ErrorResponse {
    private String message;
    private long timestamp;
    public ErrorResponse(String message, long timeStamp) {
        this.message = message;
        this.timestamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
