package com.wellysonfreitas.selikoff_boyarsky.ch5methods.staticdata;

@SuppressWarnings("AccessStaticViaInstance")
class Penguin {
    String name;
    static String nameOfTallestPenguin;

    public static void main(String[] unused) {
        var p1 = new Penguin();
        p1.name = "Lilly";
        p1.nameOfTallestPenguin = "Lilly";
        var p2 = new Penguin();
        p2.name = "Willy";
        p2.nameOfTallestPenguin = "Willy";

        System.out.println(p1.name); // Lilly
        System.out.println(p1.nameOfTallestPenguin); // Willy
        System.out.println(p2.name); // Willy
        System.out.println(p2.nameOfTallestPenguin); // Willy
    }
}

// Another example

class Koala {
    public static int count = 0; // static variable
    public static void main(String[] args) { // static method
        System.out.print(count);
    }
}

class KoalaTester {
    public static void main(String[] args) {
        Koala.main(new String[0]); // call static method
    }
}
