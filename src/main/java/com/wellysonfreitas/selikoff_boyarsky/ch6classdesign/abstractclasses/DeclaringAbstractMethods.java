package com.wellysonfreitas.selikoff_boyarsky.ch6classdesign.abstractclasses;

abstract class Llama {
    public void chew() {} // This is not an abstract method. Abstract classes do not require abstract methods
}

class Egret {
    // public abstract void peck(); // DOES NOT COMPILE (abstract method outside abstract class)
}

// abstract modifier can be placed before or after access modifier in class and method declarations
abstract public class DeclaringAbstractMethods {
    abstract public int claw();
}

// public class abstract Bear { // DOES NOT COMPILE
//     public int abstract howl(); // DOES NOT COMPILE   
// }
