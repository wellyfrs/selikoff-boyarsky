package com.wellysonfreitas.selikoff_boyarsky.ch5methods.overloading;

class Toucan {
    // Java treats varargs as if they were an array
    // This means the method signature is the same for both methods
    public void fly(int[] lengths) {}
    // public void fly(int... lengths) {} // DOES NOT COMPILE
    
    public static void main(String[] args) {
        var toucan = new Toucan();
        
        toucan.fly(new int[] { 1, 2, 3 }); // Allowed to call either fly() method
        // toucan.fly(1, 2, 3); // Allowed to call only the fly() method using varargs
    }
}
