package ru.mixaron.springCourse.RESTApiPractice.util;

public class NotCreatedException extends RuntimeException{
    public NotCreatedException(String msg) {
        super(msg);
    }
}
