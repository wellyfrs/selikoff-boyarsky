package com.wellysonfreitas.selikoff_boyarsky.ch7beyondclasses.enums;

//public enum Season { // public or package access:
enum Season {
    WINTER, SPRING, SUMMER, FALL; // semicolon optional for simple enums
}

@SuppressWarnings("ConstantValue")
class SimpleEnums {

    public static void main(String[] args) {
        var s = Season.SUMMER;
        System.out.println(Season.SUMMER); // SUMMER
        System.out.println(s == Season.SUMMER); // true
    }
}

// Can't extend an enum
//class ExtendedSeason extends Season {} // DOES NOT COMPILE

// CALLING THE values(), name(), AND ordinal() METHODS

class SimplesEnums2 {

    public static void main(String[] args) {
        for(var season: Season.values()) {
            System.out.println(season.name() + " " + season.ordinal());
        }
        // prints:
        // WINTER 0
        // SPRING 1
        // SUMMER 2
        // FALL 3
        
        // Can't compare an int and an enum value directly
        // if (Season.SUMMER == 2) {} // DOES NOT COMPILE
        
        // CALLING THE valueOf() METHOD
        Season s = Season.valueOf("SUMMER"); // SUMMER
        Season t = Season.valueOf("summer"); // IllegalArgumentException
    }
}
