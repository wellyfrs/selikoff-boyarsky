// Same package as Bird
package com.wellysonfreitas.selikoff_boyarsky.ch5methods.accessmodifiers.protectedaccess.pond.shore;

public class BirdWatcher {
    public void watchBird() {
        Bird bird = new Bird();
        bird.floatInWater(); // protected access is ok
        System.out.print(bird.text); // protected access is ok
    }
}
