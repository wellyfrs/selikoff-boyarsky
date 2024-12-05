package com.wellysonfreitas.selikoff_boyarsky.ch7beyondclasses.polymorphism;

class Primate {
    public boolean hasHair() {
        return true;
    }
}

interface HasTail {
    public abstract boolean isTailStriped();
}

@SuppressWarnings({"UnnecessaryLocalVariable"})
class Lemur extends Primate implements HasTail {
    public boolean isTailStriped() {
        return false;
    }
    public int age = 10;
    public static void main(String[] args) {
        Lemur lemur = new Lemur(); // only this object is created
        System.out.println(lemur.age);
        
        HasTail hasTail = lemur;
        System.out.println(hasTail.isTailStriped());
        
        Primate primate = lemur;
        System.out.println(primate.hasHair());
        
        // prints:
        // 10
        // false
        // true

//        System.out.println(hasTail.age); // DOES NOT COMPILE
//        System.out.println(primate.isTailStriped()); // DOES NOT COMPILE
    }
}
