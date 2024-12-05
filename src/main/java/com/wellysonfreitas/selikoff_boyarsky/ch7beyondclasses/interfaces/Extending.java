package com.wellysonfreitas.selikoff_boyarsky.ch7beyondclasses.interfaces;

interface Nocturnal {
    public int hunt();
}

interface CanFly {
    public void flap();
}

interface HasBigEyes extends Nocturnal, CanFly {}

class Owl implements HasBigEyes {
    public int hunt() { return 5; }
    public void flap() { System.out.println("Flap!"); }
}
