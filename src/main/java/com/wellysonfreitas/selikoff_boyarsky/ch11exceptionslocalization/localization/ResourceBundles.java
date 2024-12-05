package com.wellysonfreitas.selikoff_boyarsky.ch11exceptionslocalization.localization;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class ResourceBundles {
    
    static {
        Locale.setDefault(Locale.US);
    }
    
    public static void printWelcomeMessage(Locale locale) {
        var rb = ResourceBundle.getBundle("Zoo", locale);
        System.out.println(rb.getString("hello")
                + ", " + rb.getString("open"));
    }

    public static void main(String[] args) {
        Locale us = new Locale("en", "US");
        Locale france = new Locale("fr", "FR");
        Locale englishCanada = new Locale("en", "CA");
        Locale frenchCanada = new Locale("fr", "CA");
        
        printWelcomeMessage(us); // Hello, The Zoo is open
        printWelcomeMessage(france); // Bonjour, Le Zoo est ouvert
        
        // Looping through key/value pairs
        ResourceBundle rb = ResourceBundle.getBundle("Zoo", us);
        rb.keySet().stream()
                .map(k -> k + ": " + rb.getString(k))
                .forEach(System.out::println);
        
        // PICKING A RESOURCE BUNDLE
        // Java handles the logic of picking the best available resource bundle for a given key.
        // It tries to find the most specific value.
        
        ResourceBundle.getBundle("Zoo"); // uses default locale
        ResourceBundle.getBundle("Zoo", us);
        
        Locale.setDefault(new Locale("hi"));
        ResourceBundle rb2 = ResourceBundle.getBundle("Zoo", new Locale("en"));
        // Will look for:
        // Zoo_en.properties (specified locale)
        // Zoo_hi.properties (default locale)
        // Zoo.properties (default bundle)
        
        // SELECTING RESOURCE BUNDLE VALUES
        
        Locale.setDefault(new Locale("en", "US"));
        Locale locale = new Locale("en", "CA");
        ResourceBundle rb3 = ResourceBundle.getBundle("Zoo", locale);
        System.out.print(rb3.getString("hello"));
        System.out.print(".");
        System.out.print(rb3.getString("name"));
        System.out.print(" ");
        System.out.print(rb3.getString("open2"));
        System.out.print(" ");
        System.out.print(rb3.getString("visitors"));
        
        // prints:
        // Hello.Vancouver Zoo is open Canada visitors

//        System.out.println(rb3.getString("close")); // MissingResourceException
        
        // FORMATTING MESSAGES
        
        String format = rb3.getString("helloByName");
        System.out.println(MessageFormat.format(format, "Tammy", "Henry"));
        // prints: Hello, Tammy and Henry
    }
}

// USING THE PROPERTIES CLASS

class ZooOptions {

    public static void main(String[] args) {
        var props = new Properties();
        props.setProperty("name", "Our zoo");
        props.setProperty("open", "10am");

        System.out.println(props.getProperty("camel")); // null
        System.out.println(props.getProperty("camel", "Bob")); // Bob
        
        props.get("open"); // 10am
        
//        props.get("open", "The zoo will be open soon"); // DOES NOT COMPILE
    }
}
