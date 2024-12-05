package com.wellysonfreitas.selikoff_boyarsky.ch5methods.basics;

public class ReturnType {

    public void swim(int distance) {
        if (distance <= 0) {
            // Exit early, nothing to do!
            return;
        }
        System.out.println("Fish is swimming " + distance + " meters");
    }
}

@SuppressWarnings("ConstantValue")
class Hike {
    public void hike1() {}
    public void hike2() { return; }
    public String hike3() { return ""; }
    // public String hike4() {} // DOES NOT COMPILE
    // public void hike5() {} // DOES NOT COMPILE
    // public String int hike6() {} // DOES NOT COMPILE
    // String hike7(int a) { // DOES NOT COMPILE
    //     if (1 < 2) return "orange";
    // }
    
    String hike8(int a) {
        if (1 < 2) return "orange";
        return "apple"; // unreachable
    }
}

@SuppressWarnings("UnnecessaryLocalVariable")
class Measurement {
    int getHeight1() {
        int temp = 9;
        return temp;
    }
    // int getHeight2() {
    //     int temp = 9L; // DOES NOT COMPILE
    //     return temp;
    // }
    // int getHeight3() {
    //     long temp = 9L;
    //     return temp; // DOES NOT COMPILE
    // }
}
