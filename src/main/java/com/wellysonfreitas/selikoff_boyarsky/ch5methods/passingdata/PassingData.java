package com.wellysonfreitas.selikoff_boyarsky.ch5methods.passingdata;

class PassingData {

    public static void main(String[] args) {
        int num = 4;
        newNumber(num);
        System.out.print(num); // 4
    }
    
    public static void newNumber(int num) {
        num = 8;
    }
}

// PASSING OBJECTS

class Dog {
    public String name;

    public static void main(String[] args) {
        String name = "Webby";
        speak(name); // variable name does not change
        System.out.println(name); // Webby

        // DO NOT CONFUSE WITH
        var name2 = new StringBuilder("Webby");
        speak(name2); // variable name2 does not change, but object that variable is pointing to does
        System.out.println(name2); // WebbyGeorgette
    }

    public static void speak(String name) {
        name = "Georgette";
    }

    // Because Java is a pass-by-value language,
    // it will copy the reference, but both point to the same object
    public static void speak(StringBuilder s) {
        s.append("Georgette");
    }
}
