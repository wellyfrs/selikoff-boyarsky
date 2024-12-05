// Different package than Bird
package com.wellysonfreitas.selikoff_boyarsky.ch5methods.accessmodifiers.protectedaccess.pond.inland;

import com.wellysonfreitas.selikoff_boyarsky.ch5methods.accessmodifiers.protectedaccess.pond.shore.Bird;

public class BirdWatcherFromAfar { // Not a subclass of Bird
    public void watchBird() {
        Bird bird = new Bird();
        // bird.floatInWater(); // DOES NOT COMPILE
        // System.out.print(bird.text); // DOES NOT COMPILE
    }
}
