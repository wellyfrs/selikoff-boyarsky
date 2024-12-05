package com.wellysonfreitas.selikoff_boyarsky.ch7beyondclasses.interfaces;

/*

DEFAULT INTERFACE METHOD

A default method is a method defined in an interface with the default keyword and includes a method body.

Useful for backward compatibility, since an interface can be modified without affecting all old classes implementing it.

DEFAULT INTERFACE METHOD DEFINITION RULES

1. only within an interface
2. default keyword and body are required
3. implicitly public
4. cannot be abstract, final, or static
5. can be overridden by a class that implements the interface
6. if a class inherits two or more default methods with the same method signature, then it must override the method

*/

interface IsColdBlooded {
    boolean hasScales();
    
    default double getTemperature() {
        return 10.0;
    }
}

class Snake implements IsColdBlooded {
    public boolean hasScales() { // Required override
        return true;
    }
    
    public double getTemperature() { // Optional override
        return 12;
    }
}

interface Carnivore {
//    public default void eatMeat(); // DOES NOT COMPILE
//    public int getRequiredFoodAmount() { // DOES NOT COMPILE
//        return 13;
//    }
}

// INHERITING DUPLICATE DEFAULT METHODS

interface Walk {
    public default int getSpeed() { return 5; }
}

interface Run {
    public default int getSpeed() { return 10; }
}

//class Cat implements Walk, Run {} // DOES NOT COMPILE

class Cat implements Walk, Run {
    public int getSpeed() { return 1; }
}

// CALLING A HIDDEN DEFAULT METHOD

class Cat2 implements Walk, Run {
    public int getSpeed() {
        return 1;
    }
    
    public int getWalkSpeed() {
        return Walk.super.getSpeed();
    }
}
