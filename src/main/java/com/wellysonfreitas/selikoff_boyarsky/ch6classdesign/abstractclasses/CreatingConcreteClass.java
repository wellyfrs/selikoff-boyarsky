package com.wellysonfreitas.selikoff_boyarsky.ch6classdesign.abstractclasses;

/*
 * A concrete class is a non-abstract class. 
 */

abstract class Animal {
    public abstract String getName(); // don't forget the semicolon
}

// class Walrus extends Animal {} // DOES NOT COMPILE

abstract class Mammal {
    abstract void showHorn();
    abstract void eatLeaf();
}

abstract class Rhino extends Mammal {
    void showHorn() {} // Inherited from Mammal
}

class BlackRhino extends Rhino {
    void eatLeaf() {} // Inherited form Mammal
}

//class Rhino2 extends Mammal { // DOES NOT COMPILE (missing implementation of eatLeft())
//    void showHorn() {}
//}

// Another example

abstract class Animal2 {
    abstract String getName();
}

abstract class BigCat extends Animal {
    protected abstract void roar();
}

class Lion extends BigCat {
    public String getName() {
        return "Lion";
    }
    
    public void roar() {
        System.out.println("The Lion lets out a loud ROAR!");
    }
}
