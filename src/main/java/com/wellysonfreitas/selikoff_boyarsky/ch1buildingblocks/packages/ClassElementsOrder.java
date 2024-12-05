// Comment allowed here.
// Think of the acronym PIC (picture): package, import, and class

package com.wellysonfreitas.selikoff_boyarsky.ch1buildingblocks.packages; // package must be first non-comment

// import java.util.*; // import must come after package

public class ClassElementsOrder { // then comes the class
    double weight; // fields and methods can go in either order
    
    public double getWeight() {
        return weight;
    }
    
    double height; // another field = they don't need to be together
}
