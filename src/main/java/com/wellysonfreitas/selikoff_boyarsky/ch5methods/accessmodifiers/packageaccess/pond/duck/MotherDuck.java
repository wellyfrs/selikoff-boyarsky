package com.wellysonfreitas.selikoff_boyarsky.ch5methods.accessmodifiers.packageaccess.pond.duck;

public class MotherDuck {
    String noise = "quack";
    
    void quack() {
        System.out.print(noise); // package access is ok
    }
}
