package com.wellysonfreitas.selikoff_boyarsky.ch6classdesign.overriding;

/*

@Override ANNOTATION

*/

class Fish {
    public void swim() {};
}

// When used correctly, the annotation doesn't impact the code.

@SuppressWarnings("RedundantMethodOverride")
class Shark extends Fish {
    @Override
    public void swim() {}
}

// When used incorrectly, it prevents from making mistakes.

class Shark2 extends Fish {
    // DOES NOT COMPILE
//    @Override
    public void swim(int speed) {} // DOES NOT COMPILE
}

class Shark3 extends Fish {
    // DOES NOT COMPILE
//    @Override
//    public void inexistent() {}
}
