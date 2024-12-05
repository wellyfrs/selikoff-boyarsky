package com.wellysonfreitas.selikoff_boyarsky.ch4coreapis.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;

/*

PERIOD

*/

@SuppressWarnings("AccessStaticViaInstance")
class PeriodClass {
    public static void main(String[] args) {
        var start = LocalDate.of(2022, Month.JANUARY, 1);
        var end = LocalDate.of(2022, Month.MARCH, 30);
        performAnimalEnrichment(start, end); // method can't be reused

        var period = Period.ofMonths(1); // create a period
        performAnimalEnrichment(start, end, period);

        // different ways to create a period
        var annually = Period.ofYears(1); // every 3 months
        var quarterly = Period.ofMonths(3); // every 3 weeks
        var everyThreeWeeks = Period.ofWeeks(3); // every 3 weeks
        var everyOtherDay = Period.ofDays(2); // every 2 days
        var everyYearAndAWeek = Period.of(1, 0, 7); // every year and 7 days

        // YOU CANNOT CHAIN METHODS WHEN CREATING A PERIOD
        var wrong = Period.ofYears(1).ofWeeks(1); // every week

        var wrong2 = Period.ofYears(1);
        wrong2 = Period.ofWeeks(1);

        // PRINTING PERIODS
        // Java omits any measures that are zero

        System.out.println(Period.of(1, 2, 3)); // P1Y2M3D

        System.out.println(Period.ofMonths(3)); // P3M

        var date = LocalDate.of(2022, 1, 20);
        var time = LocalTime.of(6, 15);
        var dateTime = LocalDateTime.of(date, time);
        var period2 = Period.ofMonths(1);
        System.out.println(date.plus(period2)); // 2022-02-20
        System.out.println(dateTime.plus(period2)); // 2022-02-20T06:15
        System.out.println(time.plus(period2)); // Exception
    }

    private static void performAnimalEnrichment(LocalDate start, LocalDate end) {
        var upTo = start;
        while (upTo.isBefore(end)) { // check if still before end
            System.out.println("give new toy: " + upTo);
            upTo = upTo.plusMonths(1); // add a month
        }
    }

    // Uses the generic period
    private static void performAnimalEnrichment(LocalDate start, LocalDate end, Period period) {
        var upTo = start;
        while (upTo.isBefore(end)) {
            System.out.println("give new toy: " + upTo);
            upTo = upTo.plus(period); // adds the period
        }
    }
}
