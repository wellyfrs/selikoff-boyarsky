// Different package than bird
package com.wellysonfreitas.selikoff_boyarsky.ch5methods.accessmodifiers.protectedaccess.pond.goose;

import com.wellysonfreitas.selikoff_boyarsky.ch5methods.accessmodifiers.protectedaccess.pond.shore.Bird;

public class Gosling extends Bird { // Gosling is a subclass of Bird
    public void swim() {
        floatInWater(); // protected access is ok
        System.out.print(text); // protected access is ok
    }

    public static void main(String[] args) {
        new Gosling().swim();
    }
}
