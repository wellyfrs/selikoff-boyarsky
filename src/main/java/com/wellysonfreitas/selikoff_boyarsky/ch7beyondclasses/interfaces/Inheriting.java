package com.wellysonfreitas.selikoff_boyarsky.ch7beyondclasses.interfaces;

abstract class Animal {
    abstract int getType();
}

interface Fly {
    void fly();
}

abstract class Bird extends Animal implements Fly {
    abstract boolean canSwoop();
}

interface Swim {
    void swim();
}

class Swan extends Bird implements Swim {

    @Override
    boolean canSwoop() { return false; }

    @Override
    int getType() { return 0; }

    @Override
    public void fly() {}

    @Override
    public void swim() {}
}

// Another example

interface HasTail {
    public int getTailLength();
}

interface HasWhiskers {
    public int getNumberOfWhiskers();
}

abstract class HarborSeal implements HasTail, HasWhiskers {}

//class CommonSeal extends HarborSeal {} // DOES NOT COMPILE (must be abstract or implement methods)

// MIXING CLASS AND INTERFACE KEYWORDS

interface CanRun {}
// class Cheetah extends CanRun {} // DOES NOT COMPILE

class Hyena {}
// interface HasFur extends Hyena {} // DOES NOT COMPILE

// INHERITING DUPLICATE ABSTRACT METHODS
// Java supports inheriting two abstract methods that have compatible method declarations.

interface Herbivore { public void eatPlants(); }

interface Omnivore { public void eatPlants(); }

class Bear implements Herbivore, Omnivore {
    public void eatPlants() {
        System.out.println("Eating plants");
    }
}

// Another example

interface Omnivore2 { public int eatPlants(); }

// class Tiger implements Herbivore, Omnivore2 {} // DOES NOT COMPILE
