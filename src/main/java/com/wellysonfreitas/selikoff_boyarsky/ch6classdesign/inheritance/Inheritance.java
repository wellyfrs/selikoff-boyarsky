package com.wellysonfreitas.selikoff_boyarsky.ch6classdesign.inheritance;

class BigCat {
    protected double size;
}

class Jaguar extends BigCat {
    public Jaguar() {
        size = 10.2;
    }
    
    public void printDetails() {
        System.out.print(size);
    }
}

class Spider {
    public void printDetails() {
//         System.out.print(size); // DOES NOT COMPILE
    }
}

// DECLARING A SUBCLASS

class Mammal {}

final class Rhinoceros extends Mammal {}

// class Clara extends Rhinoceros {} // DOES NOT COMPILE

// INHERITING OBJECT

@SuppressWarnings("ClassExplicitlyExtendsObject")
class Zoo extends java.lang.Object {} // equivalent to: class Zoo {}

// [Other example]

class Speedster {
    int numSpots;
}

public class Inheritance extends Speedster {
    int numSpots;
}
