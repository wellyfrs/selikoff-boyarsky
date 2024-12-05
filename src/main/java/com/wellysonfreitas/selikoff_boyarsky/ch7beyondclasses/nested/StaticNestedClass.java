package com.wellysonfreitas.selikoff_boyarsky.ch7beyondclasses.nested;

/*

A static nested class is like a top-level class except for the following:

- The nesting creates a namespace because the enclosing class name must be used to refer to it.
- It can additionally be marked private or protected.
- The enclosing class can refer to the fields and methods of the static nested class.

*/

@SuppressWarnings("FieldMayBeFinal")
class Park {

    static class Ride {
        private int price = 6;
    }

    public static void main(String[] args) {
        var ride = new Ride();
        System.out.println(ride.price);
    }
}
