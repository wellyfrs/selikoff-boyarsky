package com.wellysonfreitas.selikoff_boyarsky.ch7beyondclasses.interfaces;

/*

STATIC INTERFACE METHOD DEFINITION RULES

1. A static method must be marked with the static keyword and include a method body.
2. A static method without an access modifier is implicitly public.
3. A static method cannot be marked abstract or final.
4. A static method is not inherited and cannot be accessed in a class implementing the interface without a reference to the interface name.

*/

interface Hop {
    static int getJumpHeight() {
        return 8;
    }
}

class Skip {
    public int skip() {
        return Hop.getJumpHeight();
    }
}

class Bunny implements Hop {
    public void printDetails() {
//        System.out.println(getJumpHeight()); // DOES NOT COMPILE
    }
}

class Bunny2 implements Hop {
    public void printDetails() {
        System.out.println(Hop.getJumpHeight());
    }
}
