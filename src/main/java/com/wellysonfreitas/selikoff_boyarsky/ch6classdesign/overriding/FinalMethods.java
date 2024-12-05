package com.wellysonfreitas.selikoff_boyarsky.ch6classdesign.overriding;

@SuppressWarnings("FinalStaticMethod")
class Bird {
    public final boolean hasFeathers() {
        return true;
    }
    
    public final static void flyAway() {}
}

class Penguin extends Bird {
    // public final boolean hasFeathers() { // DOES NOT COMPILE
    //     return false;
    // }
    
    // public final static void flyAway() {} // DOES NOT COMPILE
}
