package com.wellysonfreitas.selikoff_boyarsky.ch5methods.accessmodifiers.packageaccess.pond.swan;

import com.wellysonfreitas.selikoff_boyarsky.ch5methods.accessmodifiers.packageaccess.pond.duck.MotherDuck;

public class BadCygnet {

    public void makeNoise() {
        var duck = new MotherDuck();
        // duck.quack(); // DOES NOT COMPILE
        // System.out.print(duck.noise); // DOES NOT COMPILE
    }
}
