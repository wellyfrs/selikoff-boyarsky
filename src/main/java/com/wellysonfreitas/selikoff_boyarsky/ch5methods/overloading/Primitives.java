package com.wellysonfreitas.selikoff_boyarsky.ch5methods.overloading;

class Ostrich {
    public void fly(int i) {
        System.out.print("int");
    }
    
    public void fly(long l) {
        System.out.print("long");
    }

    public static void main(String[] args) {
        var p = new Ostrich();
        
        // If we comment out the overloaded method with the int parameter the output becomes long-long.
        // Java has no problem calling a larger primitive.
        // However, it won't do so unless a better match is not found.
        p.fly(123); // uses fly(int)
        
        System.out.print("-");
        
        p.fly(123L);
        
        // prints int-long
    }
}
