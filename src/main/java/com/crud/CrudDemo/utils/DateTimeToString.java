package com.crud.CrudDemo.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateTimeToString {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public static String localDateTimeToString(LocalDateTime ldt){
        return ldt.format(formatter);
    }

    public static LocalDateTime stringToDateTime(String dateAndTime){
        return LocalDateTime.parse(dateAndTime, formatter);
    }
}
