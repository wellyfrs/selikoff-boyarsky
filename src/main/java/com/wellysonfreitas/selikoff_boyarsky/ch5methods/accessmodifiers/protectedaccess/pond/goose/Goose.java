package com.wellysonfreitas.selikoff_boyarsky.ch5methods.accessmodifiers.protectedaccess.pond.goose;

import com.wellysonfreitas.selikoff_boyarsky.ch5methods.accessmodifiers.protectedaccess.pond.shore.Bird;

public class Goose extends Bird {
    public void helpGooseSwim() {
        Goose other = new Goose();
        other.floatInWater();
        System.out.print(other.text);
    }
    
    // Tricky code:
    public void helpOtherGooseSwim() {
        Bird other = new Goose(); // using variable (not subclass of Bird)
        // other.floatInWater(); // DOES NOT COMPILE
        // System.out.print(other.text); // DOES NOT COMPILE
    }
}
