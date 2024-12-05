package com.wellysonfreitas.selikoff_boyarsky.ch5methods.staticdata;

class ZooPen {
    private static final int NUM_BUCKETS = 45; // constant

    public static void main(String[] args) {
        // NUM_BUCKETS = 5; // DOES NOT COMPILE
    }
}

@SuppressWarnings("MismatchedReadAndWriteOfArray")
class ZooInventoryManager {
    private static final String[] treats = new String[10];

    public static void main(String[] args) {
        treats[0] = "popcorn"; // DOES COMPILE FINE
    }
}

class Panda {
    final static String name = "Ronda";
    static final int bamboo;
    // static final double height; // DOES NOT COMPILE
    static { bamboo = 5; } // static initializer
}
