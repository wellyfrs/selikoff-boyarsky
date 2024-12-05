package com.wellysonfreitas.selikoff_boyarsky.ch9collectionsgenerics.generics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"MismatchedQueryAndUpdateOfCollection", "UnnecessaryBoxing", "DataFlowIssue"})
class UnboundedWildcards {
    public static void printList(List<Object> list) {
        for (Object x: list)
            System.out.println(x);
    }
    
    public static void printList2(List<?> list) {
        for (Object x: list)
            System.out.println(x);
    }

    public static void main(String[] args) {
        List<String> keywords = new ArrayList<>();
        keywords.add("java");
//        printList(keywords); // DOES NOT COMPILE
        printList2(keywords);
        
        List<Integer> numbers = new ArrayList<>();
        numbers.add(Integer.valueOf(42));
//        List<Object> objects = numbers; // DOES NOT COMPILE
//        objects.add("forty two");
        System.out.println(numbers.get(1));
        
        // These are not equivalent
        List<?> x1 = new ArrayList<>(); // x1 is a List
        var x2 = new ArrayList<>(); // x2 is an ArrayList; can only assign to a List<Object>
    }
}

@SuppressWarnings({"rawtypes", "InnerClassMayBeStatic"})
class upperBoundedWildcards {
    
    public static long total(List<? extends Number> list) {
        long count = 0;
        for (Number number: list)
            count += number.longValue();
        return count;
    }
    
    // after compiling, this method will be equivalent to:
    public static long total2(List list) {
        long count = 0;
        for (Object obj: list) {
            Number number = (Number) obj;
            count += number.longValue();
        }
        return count;
    }
    
    static class Sparrow extends Bird {}
    static class Bird {}

    public static void main(String[] args) {
//        ArrayList<Number> list = new ArrayList<Integer>(); // DOES NOT COMPILE
        List<? extends Number> list = new ArrayList<Integer>();
        
        List<? extends Bird> birds = new ArrayList<Bird>();
//        birds.add(new Sparrow()); // DOES NOT COMPILE (can't add a Sparrow to List<? extends Bird)
//        birds.add(new Bird()); // DOES NOT COMPILE (can't add a Bird to List<Sparrow>)
        // both scenarios are equally possible, so neither is allowed
    }
    
    // Another example with an interface
    interface Flyer { void fly(); }
    class HangGlider implements Flyer { public void fly() {} }
    class Goose implements Flyer { public void fly() {} }
    
    private void anyFlyer(List<Flyer> flyer) {}
    private void groupOfFlyers(List<? extends Flyer> flyer) {}
}

@SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
class lowerBoundedWildcards {

    public static void addSound(List<? super String> list) {
        list.add("quack");
    }
    
    public static void main(String[] args) {
        List<String> strings = new ArrayList<String>();
        strings.add("tweet");
        
        List<Object> objects = new ArrayList<Object>(strings);
        addSound(strings);
        addSound(objects);
        
        // Understanding Generic Supertypes
        List<? super IOException> exceptions = new ArrayList<Exception>();
//        exceptions.add(new Exception()); // DOES NOT COMPILE
        exceptions.add(new IOException());
        exceptions.add(new FileNotFoundException());
    }
}
