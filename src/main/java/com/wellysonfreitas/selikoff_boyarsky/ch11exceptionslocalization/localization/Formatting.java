package com.wellysonfreitas.selikoff_boyarsky.ch11exceptionslocalization.localization;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("IncorrectDateTimeFormat")
public class Formatting {

    public static void main(String[] args) {
        // FORMATTING NUMBERS
        
        double d = 1234.567;
        NumberFormat f1 = new DecimalFormat("###,###,###.0");
        System.out.println(); // 1,234.6
        
        NumberFormat f2 = new DecimalFormat("000,000,000.00000");
        System.out.println(f2.format(d)); // 000,001,234.56700
        
        NumberFormat f3 = new DecimalFormat("Your Balance $#,###,###.##");
        System.out.println(f3.format(d)); // Your Balance $1,234.57
        
        // FORMATTING DATES AND TIMES
        
        LocalDate date = LocalDate.of(2022, Month.OCTOBER, 20);
        System.out.println(date.getDayOfWeek()); // THURSDAY
        System.out.println(date.getMonth()); // OCTOBER
        System.out.println(date.getYear()); // 2022
        System.out.println(date.getDayOfYear()); // 293
        
        // DateTimeFormatter
        LocalDate date2 = LocalDate.of(2022, Month.OCTOBER, 20);
        LocalTime time = LocalTime.of(11, 12, 34);
        LocalDateTime dt = LocalDateTime.of(date2, time);

        System.out.println(date2.format(DateTimeFormatter.ISO_LOCAL_DATE)); // 2022-10-20
        System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME)); // 11:12:34
        System.out.println(dt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)); // 2022-10-20T11:12:34
        
//        date2.format(DateTimeFormatter.ISO_LOCAL_TIME); // RuntimeException
//        time.format(DateTimeFormatter.ISO_LOCAL_DATE); // RuntimeException
        
        // CUSTOMIZING THE DATE/TIME FORMAT
        
        var f = DateTimeFormatter.ofPattern("MMMM dd, yyyy 'at' hh:mm");
        System.out.println(dt.format(f)); // October 20, 2022 at 11:12
        
        // LEARNING THE STANDARD DATE/TIME SYMBOLS
        
        var dt2 = LocalDateTime.of(2022, Month.OCTOBER, 20, 6, 15, 30);
        
        var formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss");
        System.out.println(dt2.format(formatter1)); // 10/20/2022 06:15:30
        
        var formatter2 = DateTimeFormatter.ofPattern("MM_yyyy_-_dd");
        System.out.println(dt2.format(formatter2)); // 10_2022_-_20
        
        var formatter3 = DateTimeFormatter.ofPattern("h:mm z");
//        System.out.println(dt2.format(formatter3)); // DateTimeException
        
        // SELECTING A format() METHOD
        
        var dateTime = LocalDateTime.of(2022, Month.OCTOBER, 20, 6, 15, 30);
        var formatter4 = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss");

        System.out.println(dateTime.format(formatter4)); // 10/20/2022 06:15:30
        System.out.println(formatter4.format(dateTime)); // 10/20/2022 06:15:30
        
        // ADDING CUSTOM TEXT VALUES
        
        var dt3 = LocalDateTime.of(2022, Month.OCTOBER, 20, 6, 15, 30);
        
        var f4 = DateTimeFormatter.ofPattern("MMMM dd, yyyy ");
        var f5 = DateTimeFormatter.ofPattern(" hh:mm");
        System.out.println(dt3.format(f4) + "at" + dt3.format(f5)); // October 20, 2022 at 06:15
        
        // Escaping text
        var f6 = DateTimeFormatter.ofPattern("MMMM dd, yyyy 'at' hh:mm");
        System.out.println(dt3.format(f)); // October 20, 2022 at 06:15
        
        // Examples
        var g1 = DateTimeFormatter.ofPattern("MMMM dd', Party''s at' hh:mm");
        System.out.println(dt3.format(g1)); // October 20, Party's at 06:15
        
        var g2 = DateTimeFormatter.ofPattern("'System format, hh:mmm: 'hh:mm");
        System.out.println(dt3.format(g2)); // System format, hh:mm: 06:15
        
        var g3 = DateTimeFormatter.ofPattern("NEW! 'yyyy', yay!");
        System.out.println(dt3.format(g3)); // 22530000000000Thu3! yyyy, 2022am2022!
        
//        DateTimeFormatter.ofPattern("The time is hh:mm"); // Exception thrown (no escape; T is an unknown symbol)
//        DateTimeFormatter.ofPattern("'The time is hh:mm: "); // Exception thrown (escape not terminated)
    }
}
