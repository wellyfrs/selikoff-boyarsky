package com.wellysonfreitas.selikoff_boyarsky.ch11exceptionslocalization.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

// EXAMPLE

public class Handling {
    void explore() {
        try {
            fall();
            System.out.println("never get here");
        } catch (RuntimeException e) {
            getUp();
        }
        seeAnimals();
    }
    void fall() { throw new RuntimeException(); }
    private void getUp() {}
    private void seeAnimals() {}
    
    void explore2() {
//        try // DOES NOT COMPILE (missing braces)
//            fall();
//        catch (Exception e)
//            System.out.println("get up");
        
//        try { // DOES NOT COMPILE (missing clause)
//            fall();
//        }
    }
}

// CHAINING catch BLOCKS

class AnimalsOutForAWalk extends RuntimeException {}

class ExhibitClosed extends RuntimeException {}

class ExhibitClosedForLunch extends RuntimeException {}

@SuppressWarnings({"EmptyTryBlock", "CatchMayIgnoreException", "ThrowablePrintedToSystemOut"})
class Zoo {
    public void visitPorcupine() {
        try {
            seeAnimal();
        } catch(AnimalsOutForAWalk e) { // first catch block
            System.out.print("try back later");
        } catch(ExhibitClosed e) { // second catch block
            System.out.print("not today");
        }
    }

    public void visitMonkeys() {
        try {
            seeAnimal();
        } catch (ExhibitClosedForLunch e) { // subclass exception
            System.out.print("try back later");
        } catch (ExhibitClosed e) { // Superclass exception
            System.out.print("not today");
        }
    }
    
    public void visitMonkeys2() {
        try {
            seeAnimal();
        } catch (ExhibitClosed e) {
            System.out.print("not today");
        } catch (ExhibitClosedForLunch e) { // DOES NOT COMPILE
            System.out.print("try back later");
        }
    }
    
    public void visitSnakes() {
        try {
        } catch (IllegalArgumentException e) {
        }// catch (NumberFormatException e) {} // DOES NOT COMPILE
    }
    
    public void visitManatees() {
        try {
        } catch (NumberFormatException e1) {
            System.out.println(e1);
        } catch (IllegalArgumentException e2) {
//            System.out.println(e1); // DOES NOT COMPILE
        }
    }

    void seeAnimal() {}
}

// APPLYING A MULTI-CATCH BLOCK

class Exception1 extends Exception {}
class Exception2 extends Exception {}
class Exception3 extends Exception {}

@SuppressWarnings({"CatchMayIgnoreException"})
class MultiCatchBlock {
    
    public static void main(String[] args) {
        // Without multi-catch block
        try {
            System.out.println(Integer.parseInt(args[1]));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Missing or invalid input");
        } catch (NumberFormatException e) {
            System.out.println("Missing or invalid input"); // identical catch
        }
        
        // With multi-catch block
        try {
            System.out.println(Integer.parseInt(args[1]));
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Missing or invalid input");
        }
        
        // Syntax
//        try { throwException(); } catch (Exception1 e | Exception2 e | Exception3 e) {} // DOES NOT COMPILE
//        try { throwException(); } catch (Exception1 e | Exception2 e | Exception3 e) {} // DOES NOT COMPILE
        try { throwException(); } catch (Exception1 | Exception2 | Exception3 e) {}
        
        // Related exceptions in the multi-catch is redundant and does not compile
        // Put in other words, in a multi-catch expression, two classes cannot be subtypes of each other
//        try { throw new IOException(); } catch (FileNotFoundException | IOException p) {} // DOES NOT COMPILE
        
        try { throw new IOException(); } catch (IOException e) {}
    }
    
    private static void throwException() throws Exception1, Exception2, Exception3 {}
}

// ADDING A FINALLY BLOCK

@SuppressWarnings({"UnusedReturnValue", "finally", "ReturnInsideFinallyBlock", "EmptyTryBlock", "DataFlowIssue"})
class FinallyBlock {
    void explore() {
        try {
            seeAnimals();
            fall();
        } catch (Exception e) {
            getHugFromDaddy();
        } finally {
            seeMoreAnimals();
        }
        goHome();

//        try { // DOES NOT COMPILE
//            fall();
//        } finally {
//            System.out.println("all better");
//        } catch (Exception e) {
//            System.out.println("get up");
//        }
        
//        try { // DOES NOT COMPILE
//            fall();
//        }
        
        try {
            fall();
        } finally {
            System.out.println("all better");
        }
        
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("t");
        } catch (Exception e) {
            sb.append("c");
        } finally {
            sb.append("f");
        }
        sb.append("a");
        System.out.print(sb.toString()); // tfa
    }

    int goHome() {
        try {
            // Optionally throw an exception here
            System.out.print("1");
            return -1;
        } catch (Exception e) {
            System.out.print("2");
            return -2;
        } finally {
            System.out.println("3");
            return -3;
        }
    }
    
    String goHome2() {
        Info info = null;
        try {
            
        } finally {
            info.printDetails();
            System.out.print("Exiting");
            return "zoo";
        }
    }
    
    void systemExit() {
        try {
            System.exit(0);
        } finally {
            System.out.print("Never going to get here"); // Not printed
        }
    }
    
    private void seeAnimals() {}
    private void fall() {}
    private void getHugFromDaddy() {}
    private void seeMoreAnimals() {}
}

class Info {
    void printDetails() {}
}
