package com.wellysonfreitas.selikoff_boyarsky.ch6classdesign.constructors;

@SuppressWarnings("InstantiationOfUtilityClass")
class Rabbit1 {
    public static void main(String[] args) {
        new Rabbit1(); // Calls the default constructor
    }
}

@SuppressWarnings("InstantiationOfUtilityClass")
class Rabbit2 {
    public Rabbit2() {}

    public static void main(String[] args) {
        new Rabbit2(); // Calls the user-defined constructor
    }
}

class Rabbit3 {
    public Rabbit3(boolean b) {}
}

class Rabbit4 {
    private Rabbit4() {}
}

@SuppressWarnings("InstantiationOfUtilityClass")
class RabbitsMultiply {

    public static void main(String[] args) {
        var r1 = new Rabbit1();
        var r2 = new Rabbit2();
        var r3 = new Rabbit3(true);
        // var r4 = new Rabbit4(); // DOES NOT COMPILE
    }
}
