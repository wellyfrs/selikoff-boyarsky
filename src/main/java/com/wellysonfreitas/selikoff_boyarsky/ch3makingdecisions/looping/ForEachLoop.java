package com.wellysonfreitas.selikoff_boyarsky.ch3makingdecisions.looping;

import java.util.Arrays;
import java.util.List;

/*

FOR-EACH LOOP (enhanced loop)
 
The for-each loop is a specialized structure designed to
iterate over arrays and various Collections Framework classes.
The for-each loop declaration is composed of an initialization
section and an object to be iterated over. The right side of the
for-each loop must be one of the following:

- A build-in Java array.
- An object whose type implements java.lang.Iterable.

*/

@SuppressWarnings("ForLoopReplaceableByForEach")
class ForEachLoop {
    public static void main(String[] args) {
        String[] arrayOfNames = {"Bob", "Alice"};
        
        for (int counter = 0; counter < arrayOfNames.length; counter++)
            System.out.println(arrayOfNames[counter]);
        
        for (var name: arrayOfNames)
            System.out.println(name);
        
        // List implements Iterable
        List<String> listOfNames = Arrays.asList("Alice", "Bob");
        for (var name: listOfNames)
            System.out.println(name);
        
        String birds = "Jay";
        // DOES NOT COMPILE
//        for (String bird: birds)
//            System.out.println(bird + " ");
        
        String[] sloths = new String[3];
        // DOES NOT COMPILE
//        for (int sloth: sloths)
//            System.out.println(sloth + " ");
    }
}
