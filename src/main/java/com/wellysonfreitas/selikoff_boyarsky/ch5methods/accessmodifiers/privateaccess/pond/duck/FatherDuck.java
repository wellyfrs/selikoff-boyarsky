package com.wellysonfreitas.selikoff_boyarsky.ch5methods.accessmodifiers.privateaccess.pond.duck;

@SuppressWarnings({"FieldCanBeLocal", "FieldMayBeFinal"})
public class FatherDuck {
    private String noise = "quack";
    
    private void quack() {
        System.out.print(noise); // private access is ok
    }
}
