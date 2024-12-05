package com.wellysonfreitas.selikoff_boyarsky.ch4coreapis.datetime;

import java.time.*; // import time classes

@SuppressWarnings("ResultOfMethodCallIgnored")
class DateTimeAPI {
    public static void main(String[] args) {
        // LocalDate contains just a date -- no time and no time zone
        System.out.println(LocalDate.now());
        // LocalTime contains just a time -- no date and no time zone
        System.out.println(LocalTime.now());
        // LocalTime contains both a date and time but no time zone
        System.out.println(LocalDateTime.now());
        // ZonedDateTime contains a date, time, and time zone
        // +02:00, GMT+2, UTC+2 all mean the same thing
        System.out.println(ZonedDateTime.now());
        
        // LOCAL DATE
        
        var date1 = LocalDate.of(2022, Month.JANUARY, 20);
        var date2 = LocalDate.of(2022, 1, 20);
        
        // public static LocalDate of(int year, int month, int dayOfMonth)
        // public static LocalDate of(int year, Month month, int dayOfMonth)
        
        // LOCAL TIME
        
        var time1 = LocalTime.of(6, 15); // hour and minute
        var time2 = LocalTime.of(6, 15, 30); // + seconds
        var time3 = LocalTime.of(6, 15, 30, 200); // + nanoseconds
        
        // public static LocalTime of(int hour, int minute)
        // public static LocalTime of(int hour, int minute, int second)
        // public static LocalTime of(int hour, int minute, int second, int nanos)
        
        // LOCAL DATE TIME
        
        var dateTime1 = LocalDateTime.of(2022, Month.JANUARY, 20, 6, 15, 30);
        var dateTime2 = LocalDateTime.of(date1, time1);
        
        // public static LocalDateTime of(int year, int month, int dayOfMonth, int hour, int minute)
        // public static LocalDateTime of(int year, int month, int dayOfMonth, int hour, int minute, int second)
        // public static LocalDateTime of(int year, int month, int dayOfMonth, int hour, int minute, int second, int nanos)
        
        // Month reference

        // public static LocalDateTime of(int year, Month month, int dayOfMonth, int hour, int minute)
        // public static LocalDateTime of(int year, Month month, int dayOfMonth, int hour, int minute, int second)
        // public static LocalDateTime of(int year, Month month, int dayOfMonth, int hour, int minute, int second, int nanos)
        
        // public static LocalDateTime of(LocalDate date, LocalTime time)
        
        // ZONED DATE TIME
        
        var zone = ZoneId.of("US/Eastern");
        var zoned1 = ZonedDateTime.of(2022, 1, 20, 6, 15, 30, 200, zone);
        var zoned2 = ZonedDateTime.of(date1, time1, zone);
        var zoned3 = ZonedDateTime.of(dateTime1, zone);
        
        // public static ZonedDateTime of(int year, int month, int dayOfMonth, int hour, int minute, int second, int nanos, ZoneId, zone)
        // public static ZonedDateTime of(LocalDate date, LocalTime time, ZoneId zone)
        // public static ZonedDateTime of(LocalDateTime dateTime, ZoneId zone)
        
        // Tricky code
//        var d1 = new LocalDate(); // DOES NOT COMPILE
        
        // Tricky code
//        var d2 = LocalDate.of(2022, Month.JANUARY, 32); // DateTimeException (32/01 does not exist)
     
        // MANIPULATING DATES AND TIMES
        
        var date = LocalDate.of(2022, Month.JANUARY, 20);
        System.out.println(date); // 2022-01-20
        date = date.plusDays(2);
        System.out.println(date); // 2022-01-22
        date = date.plusWeeks(1);
        System.out.println(date); // 2022-01-29
        date = date.plusMonths(1);
        System.out.println(date); // 2022-02-28
        date = date.plusYears(5);
        System.out.println(date); // 2027-02-28
        
        // Go backward in time
        var date3 = LocalDate.of(2024, Month.JANUARY, 20);
        var time = LocalTime.of(5, 15);
        var dateTime = LocalDateTime.of(date3, time);
        System.out.println(dateTime); // 2024-01-20T05:15
        dateTime = dateTime.minusDays(1);
        System.out.println(dateTime); // 2024-01-19T05:15
        dateTime = dateTime.minusHours(10);
        System.out.println(dateTime); // 2024-01-18T19:15
        dateTime = dateTime.minusSeconds(30);
        System.out.println(dateTime); // 2024-01-18T19:14:30
        
        // Chaining
        var date4 = LocalDate.of(2024, Month.JANUARY, 20);
        var time4 = LocalTime.of(5, 15);
        var dateTime4 = LocalDateTime.of(date4, time4)
                .minusDays(1).minusHours(10).minusSeconds(30);
        
        // Tricky code
        var date5 = LocalDate.of(2024, Month.JANUARY, 20);
        date5.plusDays(10); // result is being ignored, date do not change
        System.out.println(date); // January 20, 2024
        
        var date6 = LocalDate.of(2024, Month.JANUARY, 20);
        // date6 = date6.plusMinutes(1); // DOES NOT COMPILE
    }
}
