package com.wellysonfreitas.selikoff_boyarsky.ch5methods.variables;

/*
 * Rules for creating a method with a varargs parameter
 * 1. A method can have at most one varargs parameter.
 * 2. If a method contains a varargs parameter, it must be the last parameter in the list.
 */

@SuppressWarnings("UnnecessaryLocalVariable")
class VisitAttractions {

    public void walk1(int... steps) {
        int[] step2 = steps; // Not necessary, but shows steps is of type int[]
        System.out.println(step2.length);
    }
    
    public void walk2(int start, int... steps) {}
    
    // public void walk3(int... steps, int start) {} // DOES NOT COMPILE
    // public void walk4(int... start, int... steps) {} // DOES NOT COMPILE
    
    // CALLING METHODS WITH VARARGS
    public static void main(String[] args) {
        var visitAttractions = new VisitAttractions();
        
        // Pass an array
        int[] data = new int[] {1, 2, 3};
        visitAttractions.walk1(data);
        
        // Pass a list of values
        visitAttractions.walk1(1, 2, 3);
        
        // Omitting the varargs values, Java will create an array of length zero
        visitAttractions.walk1();
        
        run(11, 77); // prints 77
    }

    // ACCESSING ELEMENTS OF A VARARG
    public static void run(int... steps) {
        System.out.println(steps[1]); // Like accessing an array
    }
}

@SuppressWarnings({"ConfusingArgumentToVarargsMethod", "DataFlowIssue"})
class DogWalker {

    // USING VARARGS WITH OTHER METHOD PARAMETERS
    public static void walkDog(int start, int... steps) {
        System.out.println(steps.length);
    }

    public static void main(String[] args) {
        walkDog(1); // 0
        walkDog(1, 2); // 1
        walkDog(1, 2, 3); // 2
        walkDog(1, new int[] {4, 5}); // 2
        
        // PASSING NULL DOES COMPILE
        // since null isn't an int, Java treats it as an array reference that happens to be null
        walkDog(1, null); // Triggers NullPointerException in walkDog()
    }
}
