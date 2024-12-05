package com.wellysonfreitas.selikoff_boyarsky.ch5methods.overloading;

/*

Java tries to use the most specific parameter list it can find.

*/

class Kiwi {
    // public void fly(int numMiles) {}
    public void fly(Integer numMiles) {}
    
    // public static void walk(int[] ints) {}
    public static void walk(Integer[] integers) {}

    public static void main(String[] args) {
        var kiwi = new Kiwi();
        kiwi.fly(3); // uses fly(Integer)
        
        // kiwi.walk(new int[] {1, 2, 3}) // DOES NOT COMPILE
    }
}
