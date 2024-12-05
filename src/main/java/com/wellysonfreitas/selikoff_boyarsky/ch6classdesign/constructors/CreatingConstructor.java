package com.wellysonfreitas.selikoff_boyarsky.ch6classdesign.constructors;

@SuppressWarnings("MethodNameSameAsClassName")
class Bunny {
    public Bunny() {
        System.out.print("hop");
    }
    
    // public bunny() {} // DOES NOT COMPILE
    
    public void Bunny() {} // Not a constructor
}

class Bonobo {
    // public Bonobo(var food) {} // DOES NOT COMPILE
}

class Turtle {
    private String name;
    
    public Turtle() {
        name = "John Doe";
    }
    
    public Turtle(int age) {}
    
    public Turtle(long age) {}
    
    public Turtle(String newName, String... favoriteFoods) {
        name = newName;
    }

    public static void main(String[] args) {
        new Turtle(15);
    }
}
