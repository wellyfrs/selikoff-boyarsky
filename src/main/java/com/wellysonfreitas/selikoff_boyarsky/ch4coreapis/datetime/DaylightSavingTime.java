package com.wellysonfreitas.selikoff_boyarsky.ch4coreapis.datetime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/*

DAYLIGHT SAVING TIME

US Daylight Saving Time
Spring (March) -> 1:59 a.m. -> 3:00 a.m.
Fall (November) -> 1:59 a.m. -> 1:00 a.m.

*/

class DaylightSavingTime {
    public static void main(String[] args) {
        var zone = ZoneId.of("US/Eastern");
        
        // Spring (March)
        var date = LocalDate.of(2022, Month.MARCH, 13);
        var time = LocalTime.of(1, 30);
        var dateTime = ZonedDateTime.of(date, time, zone); // 2022-03-13T01:30-05:00[US/Eastern]
        
        System.out.println(dateTime.getHour()); // 1
        System.out.println(dateTime.getOffset()); // -05:00
        
        dateTime = dateTime.plusHours(1);
        System.out.println(dateTime); // 2022-03-13T03:30-04:00[US/Eastern]
        System.out.println(dateTime.getHour()); // 3
        System.out.println(dateTime.getOffset()); // -04:00
        
        // Fall (November)
        var date2 = LocalDate.of(2022, Month.NOVEMBER, 6);
        var time2 = LocalTime.of(1, 30);
        var dateTime2 = ZonedDateTime.of(date2, time2, zone);

        System.out.println(dateTime2); // 2022-11-06T01:30-04:00[US/Eastern]
        
        dateTime2 = dateTime2.plusHours(1);
        System.out.println(dateTime2); // 2022-11-06T01:30-05:00[US/Eastern]
        
        dateTime2 = dateTime2.plusHours(1);
        System.out.println(dateTime2); // 2022-11-06T02:30-05:00[US/Eastern]
    
        // A time that doesn't exist
        var date3 = LocalDate.of(2022, Month.MARCH, 13);
        var time3 = LocalTime.of(2, 30);
        var dateTime3 = ZonedDateTime.of(date3, time3, zone);
        
        // Java know that there is no 2:30 a.m.
        // and switches over to the appropriate GMT offset
        System.out.println(dateTime3); // 2022-03-13T03:30-04:00[US/Eastern]
    }
}
