package com.wellysonfreitas.selikoff_boyarsky.ch5methods.staticdata.staticimports;

import java.util.Arrays;

// import static java.util.Arrays; // DOES NOT COMPILE

// static import java.util.Arrays.*; // DOES NOT COMPILE

// Tricky code
@SuppressWarnings("ArraysAsListWithZeroOrOneArgument")
public class BadZooParking {

    public static void main(String[] args) {
        Arrays.asList("one");
    }
}
