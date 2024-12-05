package com.wellysonfreitas.selikoff_boyarsky.ch5methods.staticdata.staticimports;

// Regular imports:
import java.util.List;

// Static imports:
//import static java.util.Arrays.asList; // OR
import static java.util.Arrays.*;
//static import java.util.Arrays.*; // DOES NOT COMPILE (wrong order)

//import static java.util.Collections.sort; // OK
//import static java.util.Collections.sort(ArrayList<String>); // DOES NOT COMPILE

/*
 * Regular imports are for importing classes,
 * while static imports are for importing static members of classes
 * like variables and methods.
 */

class Imports {
    public static void main(String[] args) {
        // List<String> list = Arrays.asList("one", "two");
        List<String> list = asList("one", "two"); // No Arrays. prefix
    }
}
