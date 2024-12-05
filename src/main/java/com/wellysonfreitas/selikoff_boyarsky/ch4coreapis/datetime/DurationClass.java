package com.wellysonfreitas.selikoff_boyarsky.ch4coreapis.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/*

DURATION

Duration works roughly the same way as Period,
except it is used with objects that have time.

*/

class DurationClass {
    public static void main(String[] args) {
        var daily = Duration.ofDays(1); // PT24H
        var hourly = Duration.ofHours(1); // PT1H
        var everyMinute = Duration.ofMinutes(1); // PT1M
        var everyTenSeconds = Duration.ofSeconds(10); // PT10S
        var everyMilli = Duration.ofMillis(1); // PT0.001S
        var everyNano = Duration.ofNanos(1); // PT0.000000001S

        var daily2 = Duration.of(1, ChronoUnit.DAYS);
        var hourly2 = Duration.of(1, ChronoUnit.HOURS);
        var everyMinute2 = Duration.of(1, ChronoUnit.MINUTES);
        var everyTenSeconds2 = Duration.of(10, ChronoUnit.SECONDS);
        var everyMilli2 = Duration.of(1, ChronoUnit.MILLIS);
        var everyNano2 = Duration.of(1, ChronoUnit.NANOS);

        // ChronoUnit also supports HALF_DAYS
        System.out.println(ChronoUnit.HALF_DAYS);
        
        // ChronoUnit for Differences
        var one = LocalTime.of(5, 15);
        var two = LocalTime.of(6, 30);
        var date = LocalDate.of(2016, 1, 20);
        System.out.println(ChronoUnit.HOURS.between(one, two)); // 1
        System.out.println(ChronoUnit.MINUTES.between(one, two)); // 75
        System.out.println(ChronoUnit.MINUTES.between(one, date)); // DateTimeException
    
        // Truncate
        LocalTime time = LocalTime.of(3,12,45);
        System.out.println(time); // 03:12:45
        LocalTime truncated = time.truncatedTo(ChronoUnit.MINUTES);
        System.out.println(truncated); // 03:12
        
        // Using Duration
        var date2 = LocalDate.of(2022, 1, 20);
        var time2 = LocalTime.of(6, 15);
        var dateTime = LocalDateTime.of(date2, time2);
        var duration = Duration.ofHours(6);
        System.out.println(dateTime.plus(duration)); // 2022-01-20T12:15
        System.out.println(time.plus(duration)); // 12:15
        System.out.println(date.plus(duration)); // UnsupportedTemporalTypeException
        
        duration = Duration.ofHours(23);
        System.out.println(dateTime.plus(duration)); // 2022-01-21T05:15
        System.out.println(time.plus(duration)); // 05:15
        System.out.println(date.plus(duration)); // UnsupportedTemporalTypeException
        
        // Period and Duration not equivalent
        var date3 = LocalDate.of(2022, 5, 25);
        var period = Period.ofDays(1);
        var days = Duration.ofDays(1);

        System.out.println(date3.plus(period)); // 2022-05-26
        System.out.println(date3.plus(days)); // Unsupported unit: Seconds
    }
}
