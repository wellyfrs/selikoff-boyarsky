package com.wellysonfreitas.selikoff_boyarsky.ch14io.interaction;

/*

System.out and System.err are PrintStream.
 
*/

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;

@SuppressWarnings({"EmptyTryBlock", "resource", "DataFlowIssue"})
public class Interaction {
    public static void main(String[] args) throws IOException {
        // PRINTING DATA TO THE USER
        
        try (var in = new FileInputStream("zoo.txt")) {
            System.out.println("Found file!");
        } catch (FileNotFoundException e) {
            System.err.println("File not found!"); // note System.err
        }
        
        // READING INPUT AS AN I/O STREAM
        
        var reader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = reader.readLine();
        System.out.println("You entered: " + userInput);
        
        // CLOSING SYSTEM STREAMS (not recommended)
        
        try (var out = System.out) {} // try-with-resources is closing System.out
        System.out.println("Hello"); // it prints nothing, they fail silently
        
        try (var err = System.err) {}
        System.err.println("Hello"); // prints nothing
        
        var reader2 = new BufferedReader(new InputStreamReader(System.in));
        try (reader) {}
        String data = reader.readLine(); // IOException
        
        // ACQUIRING INPUT WITH CONSOLE
        
        // Console class is a singleton
//        Console c = new Console(); // DOES NOT COMPILE
        
        Console console = System.console();
        if (console != null) {
            String userInput2 = console.readLine();
            console.writer().println("You entered: " + userInput2);
        } else {
            System.err.println("Console not available");
        }
        
        // OBTAINING UNDERLYING I/O STREAMS
        // public Reader reader()
        // public PrintWriter writer()
        
        // FORMATTING CONSOLE DATA
        
        // PrintStream
        // public PrintStream format(String format, Object... args)
        // public PrintStream format(Locale loc, String format, Object... args)
        
        // PrintWriter
        // public PrintWriter format(String format, Object... args)
        // public PrintWriter format(Locale loc, String format, Object... args)
        
        Console console2 = System.console();
        if (console2 != null) {
            throw new RuntimeException("Console not available");
        } else {
            console2.writer().println("Welcome to Our Zoo!");
            console2.format("It has %d animals and employs %d people", 391, 25);
            console2.writer().println();
            console2.printf("The zoo spans %5.1f acres", 128.91);
            // prints:
            // Welcome to Our Zoo!
            // It has 391 animals and employs 25 people
            // The zoo spans 128.9 acres.
        }
        
        // USING CONSOLE WITH A LOCALE
        
        Console console3 = System.console();
        console3.writer().format(new Locale("fr", "CA"), "Hello World");
        
        // READING CONSOLE DATA
        
        // public String readLine()
        // public String readLine(String fmt, Object... args)
        
        // readPassword() hide the password on the screen and returns char[] to prevent entering the String pool
        // public char[] readPassword()
        // public char[] readPassword(String fmt, Object... args)
        
        // REVIEWING CONSOLE METHODS
        
        Console console4 = System.console();
        if (console4 != null) {
            throw new RuntimeException("Console not available");
        } else {
            String name = console4.readLine("Please enter your name: ");
            console4.writer().format("Hi %s", name);
            console4.writer().println();
            
            console4.format("What is your address?");
            String address = console4.readLine();
            
            char[] password = console.readPassword("Enter a password " 
                    + "between %d and %d characters: ", 5, 10);
            char[] verify = console.readPassword("Enter the password again: ");
            console.printf("Password "
                    + (Arrays.equals(password, verify) ? "match" : "do not match"));
        }
        // prints:
        // Please enter your name: Max
        // Hi Max
        // What is your address? Spoonerville
        // Enter a password between 5 and 10 characters:
        // Enter the password again:
        // Password match
    }
}
