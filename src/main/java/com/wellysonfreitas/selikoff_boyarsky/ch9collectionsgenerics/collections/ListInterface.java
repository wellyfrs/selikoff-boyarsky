package com.wellysonfreitas.selikoff_boyarsky.ch9collectionsgenerics.collections;

/*

List is used for ordered collection that can contain duplicate entries.

Implementations:

- ArrayList: like a resizable array.
Main benefit is look up any element in constant time.
Adding or removing an element is slower than access an element.
Good when reading more often than writing.

- LinkedList: implements both List and Deque.
Main benefit is access, add to, and remove from the beginning and end of the list in constant time.
Trade-off: dealing with an arbitrary index takes linear time.
Good when you'll be using it as Deque.

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings({"MismatchedQueryAndUpdateOfCollection", "StatementWithEmptyBody", "MismatchedReadAndWriteOfArray"})
public class ListInterface {

    public static void main(String[] args) {
        // CREATING A LIST WITH A FACTORY
        
        String[] array = new String[] {"a", "b", "c"};
        List<String> asList = Arrays.asList(array); // [a, b, c]
        List<String> of = List.of(array); // [a, b, c] (immutable)
        List<String> copy = List.copyOf(asList); // [a, b, c] (immutable)
        
        array[0] = "z";

        System.out.println(asList); // [z, b, c]
        System.out.println(of); // [a, b, c]
        System.out.println(copy); // [a, b, c]
        
        // In the case of Arrays.asList(),
        // changing the list will change the underlying array
        asList.set(0, "x");
        System.out.println(Arrays.toString(array)); // [x, b, c]
        
        // Adding and removing are not supported (UnsupportedOperationException)
//        asList.add("y");
//        asList.remove("a");
//        of.add("y");
//        of.remove("a");
//        copy.add("y");
//        copy.remove("a");

        // Replacing
        asList.set(0, "x"); // replacing element is supported for Arrays.asList()!
//        of.set(0, "x"); // UnsupportedOperationException
//        copy.set(0, "x"); // UnsupportedOperationException
        
        // CREATING A LIST WITH A CONSTRUCTOR
        
        var linked1 = new LinkedList<String>(); // creates empty LinkedList containing all the defaults
        var linked2 = new LinkedList<String>(linked1); // copies a LinkedList
        
        var linked3 = new ArrayList<String>(10); // with initial capacity
    
        // USING var WITH ArrayList
        
        var strings = new ArrayList<String>(); // inferred type is ArrayList<String>
        strings.add("a");
        for (String s: strings) {}
        
        var list = new ArrayList<>(); // inferred type is ArrayList<Object>
        list.add("a");
//        for (String s: list) {} // DOES NOT COMPILE
        for (Object o: list) {}
        
        // WORKING WITH List METHODS
        
        List<String> list2 = new ArrayList<>();
        list2.add("SD"); // [SD]
        list2.add(0, "NY"); // [NY, SD]
        list2.set(1, "FL"); // [NY, FL]
        System.out.println(list2.get(0)); // NY
        list2.remove("NY"); // [FL]
        list2.remove(0); // []
        list2.set(0, "?"); // IndexOutOfBoundsException
        
        var numbers = Arrays.asList(1, 2, 3);
        numbers.replaceAll(x -> x * 2);
        System.out.println(numbers); // [2, 4, 6]
        
        // OVERLOADED remove() METHODS
        
        var list3 = new LinkedList<Integer>();
        list3.add(3);
        list3.add(2);
        list3.add(1);
        list3.remove(2);
        list3.remove(Integer.valueOf(2));
        System.out.println(list3); // [3]
        
        // CONVERTING FROM List TO AN ARRAY
        
        List<String> list4 = new ArrayList<>();
        list4.add("hawk");
        list4.add("robin");
        Object[] objectArray = list4.toArray();
        String[] stringArray = list4.toArray(new String[0]);
        list4.clear();
        System.out.println(objectArray.length); // 2
        System.out.println(stringArray.length); // 2
    }
}
