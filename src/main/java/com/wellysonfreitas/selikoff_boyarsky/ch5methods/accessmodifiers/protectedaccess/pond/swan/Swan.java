// Different package than Bird
package com.wellysonfreitas.selikoff_boyarsky.ch5methods.accessmodifiers.protectedaccess.pond.swan;

import com.wellysonfreitas.selikoff_boyarsky.ch5methods.accessmodifiers.protectedaccess.pond.shore.Bird;

/**
 * Protected rules apply under two scenarios:
 * - A member is used without referring to a variable (through inheritance)
 * - A member is used through a variable (if it's a subclass).
 */
public class Swan extends Bird { // Swan is a subclass of Bird

    public void swim() {
        floatInWater(); // protected access is ok
        System.out.print(text); // protected access is ok
    }
    
    public void helpOtherSwanSwim() {
        Swan other = new Swan();
        other.floatInWater(); // subclass access to superclass
        System.out.print(other.text); // subclass access to superclass
    }
    
    // Tricky code:
    public void helpOtherBirdSwim() {
        Bird other = new Bird(); // using variable (not subclass of Bird)
        // other.floatInWater(); // DOES NOT COMPILE
        // System.out.print(other.text); // DOES NOT COMPILE
    }
}
