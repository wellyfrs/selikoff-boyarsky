package com.wellysonfreitas.selikoff_boyarsky.ch5methods.accessmodifiers.protectedaccess.pond.duck;

import com.wellysonfreitas.selikoff_boyarsky.ch5methods.accessmodifiers.protectedaccess.pond.goose.Goose;

public class GooseWatcher {
    public void watch() {
        Goose goose = new Goose();
        // goose.floatInWater(); // DOES NOT COMPILE
    }
}
