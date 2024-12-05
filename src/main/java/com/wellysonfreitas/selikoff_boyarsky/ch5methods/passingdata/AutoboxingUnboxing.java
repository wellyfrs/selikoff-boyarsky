package com.wellysonfreitas.selikoff_boyarsky.ch5methods.passingdata;

/*

Autoboxing: primitive -> wrapper
Unboxing: wrapper -> primitive

*/

@SuppressWarnings({"UnnecessaryBoxing", "UnnecessaryUnboxing", "DataFlowIssue", "UnnecessaryLocalVariable"})
class AutoboxingUnboxing {
    public static void main(String[] args) {
        int quack = 5;
        
        // Explicitly converting between primitives and wrapper classes
        Integer quackquack = Integer.valueOf(quack); // Convert int to Integer
        int quackquackquack = quackquack.intValue(); // Convert Integer to int
    
        // Java automatically converting
        quackquack = quack; // Autoboxing
        quackquackquack = quackquack; // Unboxing
        
        Short tail = 8; // Autoboxing
        
        Character p = Character.valueOf('p');
        char paw = p; // Unboxing
        
        Boolean nose = true; // Autoboxing
        
        // Memorize "WLP": wrapper -> larger primitive is OK
        long largerPrimitive = Integer.valueOf(8); // wrapper to larger primitive is OK
//        int smallerPrimitive = Long.valueOf(8L); // DOES NOT COMPILE
//        Integer smallerWrapper = 8L; // DOES NOT COMPILE
//        Long largerWrapper = 8; // DOES NOT COMPILE
        
        Character elephant = null;
        char badElephant = elephant = null; // NullPointerException
    }
}

class Chimpanzee {
    
    public void climb(long t) {}
    public void swing(Integer u) {}
    public void jump(int v) {}

    public static void main(String[] args) {
        var c = new Chimpanzee();
        c.climb(123);
        c.swing(123);
        // Java will not automatically convert to a narrower type
        // c.jump(123L); // DOES NOT COMPILE
    }
}

class Gorilla {
    public void rest(Long x) {
        System.out.println("long");
    }
    
    public static void main(String[] args) {
        var g = new Gorilla();
        // Java will cast or autobox the value automatically, but not both at the same time
        // g.rest(8); // DOES NOT COMPILE
    }
}
