package com.wellysonfreitas.selikoff_boyarsky.ch8lambdasfunctionalinterfaces.lambda;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

@SuppressWarnings({"Convert2MethodRef", "ComparatorCombinators"})
public class ListingParameters {

    public static void main(String[] args) {
        // all equivalent
        Predicate<String> p1 = x -> true;
        Predicate<String> p2 = (var x) -> true;
        Predicate<String> p3 = (String x) -> true;
    }
    
    public void WhatAmI() {
        // What is the type of x?
        consume((var x) -> System.out.println(x), 123); // Integer
    }
    
    public void consume(Consumer<Integer> c, int num) {
        c.accept(num);
    }
    
    // Another example
    
    public void counts(List<Integer> list) {
        // What is the type of x?
        list.sort((var x, var y) -> x.compareTo(y)); // Integer

        // Can add modifiers (e.g. final or an annotation) to lambda parameters
        list.sort((final var x, @Deprecated var y) -> x.compareTo(y));
    }
    
    // PARAMETER LIST FORMATS
    public void parameterListFormats(List<Integer> list) {
        // Three formats for specifying parameters types within a lambda: without types, with types, and with var.
        // The compiler requires all parameters in the lambda to use the same format
//        BiFunction<String, String, String> p1 = (var x, y) -> "Hello"; // DOES NOT COMPILE
//        BiFunction<String, String, Boolean> p2 = (var x, Integer y) -> true; // DOES NOT COMPILE
//        TriFunction<String, String, Integer, Boolean> p3 = (String x, var y, Integer z) -> true; // DOES NOT COMPILE
//        BiFunction<Integer, Integer, String> p4 = (Integer x, y) -> "goodbye"; // DOES NOT COMPILE
    }

    @FunctionalInterface
    interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }
}
