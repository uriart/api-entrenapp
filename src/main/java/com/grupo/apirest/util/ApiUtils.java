package com.grupo.apirest.util;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class ApiUtils {

    public static Date stringToDate(String date) {
        return stringToDate(date, "dd/MM/yyyy");
    }

    public static Date stringToDate(String date, String pattern) {
        Date result = null;
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        sdf.setLenient(false);
        try{
            result = sdf.parse(date);
        } catch (ParseException  e) {
            log.error("Error convirtiendo la fecha " + date);
        }
        return result;
    }

    public static String dateToString(Date date) {
        String result = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if (date != null) {
            result = sdf.format(date);
        }
        return result;
    }
}
