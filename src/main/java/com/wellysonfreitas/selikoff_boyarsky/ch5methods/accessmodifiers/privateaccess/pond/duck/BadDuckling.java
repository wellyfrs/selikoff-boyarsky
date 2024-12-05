package com.wellysonfreitas.selikoff_boyarsky.ch5methods.accessmodifiers.privateaccess.pond.duck;

public class BadDuckling {

    public void makeNoise() {
        var duck = new FatherDuck();
        // duck.quack(); // DOES NOT COMPILE
        // System.out.print(duck.noise); // DOES NOT COMPILE
    }
}
