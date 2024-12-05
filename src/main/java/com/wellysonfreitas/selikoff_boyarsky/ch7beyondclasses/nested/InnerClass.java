package com.wellysonfreitas.selikoff_boyarsky.ch7beyondclasses.nested;

/*

Inner classes have the following properties:
- Can be declared public, protected, package, or private.
- Can extend a class and implement interfaces.
- Can be marked abstract or final.
- Can access members of the outer class, including private members.

*/

@SuppressWarnings({"FieldCanBeLocal", "FieldMayBeFinal"})
class Home {
    private String greeting = "Hi"; // Outer class instance variable
    
    protected class Room { // Inner class declaration
        public int repeat = 3;
        public void enter() {
            for (int i = 0; i < repeat; i++) greet(greeting);
        }
        private static void greet(String message) { // nested classes can now have static members
            System.out.println(message);
        }
    }
    
    public void enterRoom() { // Instance method in outer class
        var room = new Room(); // Create the inner class instance
        room.enter();
    }
    
    public static void main(String[] args) {
        var home = new Home(); // Create the outer class instance
        home.enterRoom();

        // INSTANTIATING AN INSTANCE OF AN INNER CLASS
        var home2 = new Home();
        Room room = home2.new Room(); // Create the inner class instance
        room.enter();
        
        // Short
        new Home().new Room().enter();
    }
}

// REFERENCING MEMBERS OF AN INNER CLASS

@SuppressWarnings({"FieldMayBeFinal", "FieldCanBeLocal"})
class A {
    private int x = 10;
    class B {
        private int x = 20;
        class C {
            private int x = 30;
            public void allTheX() {
                System.out.println(x); // 30
                System.out.println(this.x); // 30
                System.out.println(B.this.x); // 20
                System.out.println(A.this.x); // 10
            }
        }
    }

    public static void main(String[] args) {
        A a = new A();
        
        B b = a.new B(); // works
        A.B b2 = a.new B();
        var b3 = new A().new B();
        
//        C c = b.new C(); // DOES NOT WORK
        A.B.C c = b.new C();
        var c2 = new A().new B().new C();
        
        c.allTheX();
    }
}

// INNER CLASSES REQUIRE AN INSTANCE

@SuppressWarnings("InnerClassMayBeStatic")
class Fox {
    private class Den{}
    public void goHome() {
        new Den(); // the call is associated with the `this` instance
    }
    public static void visitFriend() {
//        new Den(); // DOES NOT COMPILE (called inside a static method)
    }
}

class Squirrel {
    public void visitFox() {
//        new Den(); // DOES NOT COMPILE (even adding Fox reference won't work, since Den is private)
    }
}
