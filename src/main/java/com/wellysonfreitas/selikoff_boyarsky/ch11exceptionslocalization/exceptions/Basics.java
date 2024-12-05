package com.wellysonfreitas.selikoff_boyarsky.ch11exceptionslocalization.exceptions;

import java.io.IOException;

@SuppressWarnings({
        "CallToPrintStackTrace",
        "MismatchedReadAndWriteOfArray",
        "DataFlowIssue",
        "ThrowableNotThrown",
        "CatchMayIgnoreException"
})
public class Basics {
    // CHECKED EXCEPTIONS
    // Any exception that must be declared or handled by the application code where it is thrown.
    
    void fall(int distance) throws IOException {
        if (distance > 10) {
            throw new IOException();
        }
    }

    void fall2(int distance) {
        try {
            if (distance > 10) {
                throw new IOException();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // UNCHECKED EXCEPTIONS
    // Any exception that does not need to be declared or handled by the application code where it is thrown.
    void fall3(String input) {
        System.out.println(input.toLowerCase()); // NullPointException can happen here
    }

    public static void main(String[] args) throws Exception {
        // TROWING AN EXCEPTION
        
        // Wrong code
        String[] animals = new String[0];
//        System.out.println(animals[0]); // ArrayIndexOutOfBoundsException
        
        // Explicitly requesting Java to throw an Exception
//        throw new Exception();
//        throw new Exception("Ow! I fell.");
//        throw new RuntimeException();
//        throw new RuntimeException("Ow! I fell.");
        
        // An Exception is an Object
        var e = new RuntimeException();
//        throw e; // this is legal
        
//        throw RuntimeException(); // DOES NOT COMPILE
        
        try {
            throw new RuntimeException();
//            throw new ArrayIndexOutOfBoundsException(); // DOES NOT COMPILE
        } catch (Exception e2) {}
    }
}

// CALLING METHODS THAT THROW EXCEPTIONS

class NoMoreCarrotsException extends Exception {}

class Bunny {

//    public static void main(String[] args) {
//        eatCarrot(); // DOES NOT COMPILE
//    }
    
    public static void main(String[] args) throws NoMoreCarrotsException {
        eatCarrot();
    }
    
    // or
    public static void main2(String[] args) {
        try {
            eatCarrot();
        } catch (NoMoreCarrotsException e) {
            System.out.print("sad rabbit");
        }
    }
    
    private static void eatCarrot() throws NoMoreCarrotsException {}
}

class Bunny2 {
    public void bad() {
//        try {
//            eatCarrot();
//        } catch (NoMoreCarrotsException e) { // DOES NOT COMPILE
//            System.out.print("sad rabbit"); // (unreachable code)
//        }
    }
    
    private static void eatCarrot() {}
}

// OVERRIDING METHODS WITH EXCEPTIONS

class CanNotHopException extends Exception {}

class Hopper {
    public void hop() {}
}

class Bunny3 extends Hopper {
//    public void hop() throws CanNotHopException {} // DOES NOT COMPILE
}

// An overridden method in a subclass is allowed to declare fewer exceptions than the superclass or interface

class Hopper2 {
    public void hop() throws CanNotHopException {}
}

class Bunny4 extends Hopper2 {
    public void hop() {} // This is fine
}

class CanNotHopSubclassException extends CanNotHopException {}

class Bunny5 extends Hopper2 {
    public void hop() throws CanNotHopSubclassException {} // This is also fine
}

// PRINTING AN EXCEPTION

@SuppressWarnings("CallToPrintStackTrace")
class PrintingException {

    public static void main(String[] args) {
        try {
            hop();
        } catch (Exception e) {
            System.out.println(e + "\n"); // java.lang.RuntimeException: cannot hop
            System.out.println(e.getMessage() + "\n"); // cannot hop
            e.printStackTrace();
            // java.lang.RuntimeException: cannot hop
            //  at ...PrintingException.hop(Basics.java:147)
            //  at ...PrintingException.main(Basics.java:137)
        }
    }
    private static void hop() {
        throw new RuntimeException("cannot hop");
    }
}
