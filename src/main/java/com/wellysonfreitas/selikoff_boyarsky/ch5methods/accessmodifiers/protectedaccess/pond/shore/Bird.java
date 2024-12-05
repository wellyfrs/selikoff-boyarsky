package com.wellysonfreitas.selikoff_boyarsky.ch5methods.accessmodifiers.protectedaccess.pond.shore;

public class Bird {
    protected String text = "floating";
    
    protected void floatInWater() {
        System.out.print(text); // protected access is ok
    }
}
