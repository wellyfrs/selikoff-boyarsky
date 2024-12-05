package com.wellysonfreitas.selikoff_boyarsky.ch6classdesign.overriding;

class Carnivore {
    protected boolean hasFur = false;
}

@SuppressWarnings("UnnecessaryLocalVariable")
class Meerkat extends Carnivore {
    protected boolean hasFur = true;

    public static void main(String[] args) {
        Meerkat m = new Meerkat();
        Carnivore c = m;
        System.out.println(m.hasFur); // true
        System.out.println(c.hasFur); // false
    }
}
