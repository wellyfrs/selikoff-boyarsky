package com.wellysonfreitas.selikoff_boyarsky.ch6classdesign.basics;

class Reptile {
    protected int speed = 10;
}

class Crocodile extends Reptile {
    protected int speed = 20;
    
    public int getSpeed() {
        // return speed;
        return super.speed;
    }

    public static void main(String[] data) {
        var croc = new Crocodile();
        System.out.println(croc.getSpeed()); // 20
    }
}

// Another example

class Insect {
    protected int numberOfLegs = 4;
    String label = "buggy";
}

class Beetle extends Insect {
    protected int numberOfLegs = 6;
    short age = 3;

    public void printData() {
        System.out.println(this.label); // buggy
        System.out.println(super.label); // buggy
        System.out.println(this.age); // 3
        // System.out.println(super.age); // DOES NOT COMPILE
        System.out.println(numberOfLegs); // 6
    }

    public static void main(String[] args) {
        new Beetle().printData();
    }
}
