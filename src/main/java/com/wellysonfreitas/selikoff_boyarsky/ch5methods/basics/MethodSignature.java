package com.wellysonfreitas.selikoff_boyarsky.ch5methods.basics;

class Trip {
    // The following two methods have the exact same signature
    public void visitZoo(String name, int waitTime) {}
    // public void visitZoo(String attraction, int rainFall) {} // DOES NOT COMPILE
    
    public void visitZoo(int rainFall, String attraction) {}
}
