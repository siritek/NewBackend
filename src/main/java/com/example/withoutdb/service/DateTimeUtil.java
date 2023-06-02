package com.example.withoutdb.service;



import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    // Convert string to Date
    public static LocalDate toDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateString, formatter);
        return date;
    }

    // Convert string to Time
    public static LocalTime toTime(String timeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time = LocalTime.parse(timeString, formatter);
        return time;
    }

    public static void main(String[] args) {
        // Example usage:
        String dateStr = "2023-05-31";
        LocalDate date = toDate(dateStr);
        System.out.println("Date: " + date);

        String timeStr = "12:58";
        LocalTime time = toTime(timeStr);
        System.out.println("Time: " + time);
    }
}














//package com.example.withoutdb.service;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Date;
//
//
//
//public class DateTimeUtil {
//
//    //Convert string to Date
//    public Date toDate(String date) {
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate date = LocalDate.parse(date, formatter);
//        return date;
//
//    }
//
//    public <Time> Time toTime(String Time) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
//       LocalTime time = LocalTime.parse(timeString, formatter);
//       System.out.println(time);
//    }
//
//
//}





//
//    // Convert string to Date
//    public static LocalDate toDate(String dateString) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate date = LocalDate.parse(dateString, formatter);
//        return date;
//    }
//
//    // Convert string to Time
//    public static LocalTime toTime(String timeString) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
//        LocalTime time = LocalTime.parse(timeString, formatter);
//        return time;
//    }
//
//    public static void main(String[] args) {
//        // Example usage:
//        String dateStr = "2023-05-31";
//        LocalDate date = toDate(dateStr);
//        System.out.println("Date: " + date);
//
//        String timeStr = "12:34:56";
//        LocalTime time = toTime(timeStr);
//        System.out.println("Time: " + time);
//    }