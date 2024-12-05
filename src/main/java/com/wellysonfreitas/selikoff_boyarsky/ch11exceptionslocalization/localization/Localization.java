package com.wellysonfreitas.selikoff_boyarsky.ch11exceptionslocalization.localization;

/*

Locale (language): fr (lowercase language code)
Locale (language, country): en_US (en: lowercase language code; US: uppercase country code)

Invalid:

US (cannot have country without language)
enUS (missing underscore)
US_en (the country and language are reversed)
EN (language must be lowercase)

*/

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import static java.time.format.FormatStyle.SHORT;

public class Localization {

    // Setting US as default to make book's examples work
    static {
        Locale.setDefault(Locale.US);
    }
    
    public static void main(String[] args) throws ParseException {
        // PICKING A LOCALE
        
        Locale locale = Locale.getDefault();
        System.out.println(locale);

        System.out.println(Locale.GERMAN); // de
        System.out.println(Locale.GERMANY); // de_DE
        
        System.out.println(new Locale("fr")); // fr
        System.out.println(new Locale("hi", "IN")); // hi_IN (Hindi, India)
        
        Locale l1 = new Locale.Builder()
                .setLanguage("en")
                .setRegion("US")
                .build();

        Locale l2 = new Locale.Builder()
                .setRegion("US")
                .setLanguage("en")
                .build();

        System.out.println(Locale.getDefault()); // en_US (it depends)
        Locale locale2 = new Locale("fr");
        Locale.setDefault(locale2); // the Locale changes for only this one Java program
        System.out.println(Locale.getDefault()); // fr
        Locale.setDefault(Locale.US);
        
        // LOCALIZING NUMBERS
        
        int attendeesPerYear = 3_200_000;
        int attendeesPerMonth = attendeesPerYear / 12;
        
        var us = NumberFormat.getInstance(Locale.US);
        System.out.println(us.format(attendeesPerMonth)); // 266,666
        
        var gr = NumberFormat.getInstance(Locale.GERMANY);
        System.out.println(gr.format(attendeesPerMonth)); // 266.666
        
        var ca = NumberFormat.getInstance(Locale.CANADA_FRENCH);
        System.out.println(ca.format(attendeesPerMonth)); // 266 666
        
        // Currency
        double price = 48;
        var myLocale = NumberFormat.getCurrencyInstance();
        System.out.println(myLocale.format(price));
        
        // Percentages
        double successRate = 0.802;
        var us2 = NumberFormat.getPercentInstance(Locale.US);
        System.out.println(us2.format(successRate)); // 80%
        
        var gr2 = NumberFormat.getPercentInstance(Locale.GERMANY);
        System.out.println(gr2.format(successRate)); // 80 %
        
        // PARSING NUMBERS
        
        String s = "40.45";
        
        var en = NumberFormat.getInstance(Locale.US);
        System.out.println(en.parse(s)); // 40.45
        
        // France does not use a decimal point to separate numbers.
        // Java parses it as a formatting character, and it stops looking at the rest of the number.
        var fr = NumberFormat.getInstance(Locale.FRANCE);
        System.out.println(fr.parse(s)); // 40
        
        // Currency
        String income = "$92,807.99";
        var cf = NumberFormat.getCurrencyInstance();
        double value = (Double) cf.parse(income);
        System.out.println(value); // 92807.99
        
        /* FORMATTING WITH CompactNumberFormat 
        
        Rules:
        - First it determines the highest range for the number, such as thousand (K), million (M), billion (B), or trillion (T).
        - It then returns up to the first three digits of that range, rounding the last digit as needed.
        - Finally, it prints an identifier. If SHORT is used, a symbol is returned. If LONG is used, a space followed by a word is returned.
        
        */
        
        var formatters = List.of(
                NumberFormat.getCompactNumberInstance(), // 7M (SHORT)
                NumberFormat.getCompactNumberInstance(Locale.getDefault(), NumberFormat.Style.SHORT), // 7M
                NumberFormat.getCompactNumberInstance(Locale.getDefault(), NumberFormat.Style.LONG), // 7 million
                
                NumberFormat.getCompactNumberInstance(Locale.GERMAN, NumberFormat.Style.SHORT), // 7 Mio.
                NumberFormat.getCompactNumberInstance(Locale.GERMAN, NumberFormat.Style.LONG), // 7 Millionen
                
                NumberFormat.getNumberInstance() // 7,123,456
        );
        
        formatters.stream().map(str -> str.format(7_123_456)).forEach(System.out::println);
        
        // Another example
        formatters.stream().map(str -> str.format(314_900_000)).forEach(System.out::println);
        // prints (en_US locale):
        // 315M
        // 315M
        // 315 million
        // 315 Mio.
        // 315 Millionen
        // 314,900,000
        // Notice that the third digit is automatically rounded up for the entries that use a CompactNumberFormat.
    }
}

// LOCALIZING DATES

class LocalizingDates {
    public static void print(DateTimeFormatter dtf, LocalDateTime dateTime, Locale locale) {
        System.out.println(dtf.format(dateTime) + " --- " + dtf.withLocale(locale).format(dateTime));
    }

    public static void main(String[] args) {
        Locale.setDefault(new Locale("en", "US"));
        var italy = new Locale("it", "IT");
        var dt = LocalDateTime.of(2022, Month.OCTOBER, 20, 15, 12, 34);
        
        // 10/20/22 --- 20/10/22
        print(DateTimeFormatter.ofLocalizedDate(SHORT), dt, italy);
        
        // 3:12 PM --- 15:12
        print(DateTimeFormatter.ofLocalizedTime(SHORT), dt, italy);

        // 10/20/22, 3:12 PM --- 20/10/22, 15:12
        print(DateTimeFormatter.ofLocalizedDateTime(SHORT, SHORT), dt, italy);
    }
}

// SPECIFYING A LOCALE CATEGORY

class SpecifyingLocaleCategory {
    public static void printCurrency(Locale locale, double money) {
        System.out.println(
                NumberFormat.getCurrencyInstance().format(money)
                        + ", " + locale.getDisplayLanguage()
        );
    }

    public static void main(String[] args) {
        var spain = new Locale("es", "ES");
        var money = 1.23;
        
        // Print with default locale
        Locale.setDefault(new Locale("en", "US"));
        printCurrency(spain, money); // $1.23, Spanish
        
        // Print with selected locale display
        Locale.setDefault(Locale.Category.DISPLAY, spain);
        printCurrency(spain, money); // $1.23, español
        
        // Print with selected locale format
        Locale.setDefault(Locale.Category.FORMAT, spain);
        printCurrency(spain, money); // 1,23 €, español
    }
}
