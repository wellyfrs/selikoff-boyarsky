package com.wellysonfreitas.selikoff_boyarsky.ch4coreapis.datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

/*

INSTANT

Instant class represents a specific moment in time in the GMT time zone.

*/

class InstantClass {
    public static void main(String[] args) {
        var now = Instant.now();
        // do something time-consuming
        var later = Instant.now();
        
        var duration = Duration.between(now, later);
        System.out.println(duration.toMillis()); // Returns number milliseconds
        
        var date = LocalDate.of(2022, 5, 25);
        var time = LocalTime.of(11, 55, 0);
        var zone = ZoneId.of("US/Eastern");
        var zonedDateTime = ZonedDateTime.of(date, time, zone);
        var instant = zonedDateTime.toInstant(); // 2022-05-25T15:55:00Z
        System.out.println(zonedDateTime); // 2022-05-25T11:55-04:00[US/Eastern]
        System.out.println(instant); // 2022-05-25T15:55:00Z -> removed time zone, convert time to GMT
        
        // [Other examples]
        instant.plus(1, ChronoUnit.NANOS);
        instant.plus(1, ChronoUnit.MICROS);
        instant.plus(1, ChronoUnit.MILLIS);
        instant.plus(1, ChronoUnit.SECONDS);
        instant.plus(1, ChronoUnit.MINUTES);
        instant.plus(1, ChronoUnit.HOURS);
        instant.plus(1, ChronoUnit.HALF_DAYS);
        instant.plus(1, ChronoUnit.DAYS);
        instant.plus(1, ChronoUnit.WEEKS); // compiles, but throws UnsupportedTemporalTypeException
        // Instant allows adding or removing units of DAYS or smaller
    }
}
