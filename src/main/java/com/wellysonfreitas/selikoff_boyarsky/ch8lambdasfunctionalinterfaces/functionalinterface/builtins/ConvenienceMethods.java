package com.wellysonfreitas.selikoff_boyarsky.ch8lambdasfunctionalinterfaces.functionalinterface.builtins;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ConvenienceMethods {

    public static void main(String[] args) {
        // USING CONVENIENCE METHODS
        
        // PREDICATE
        
        Predicate<String> egg = s -> s.contains("egg");
        Predicate<String> brown = s -> s.contains("brown");
        
        Predicate<String> brownEggs = s -> s.contains("egg") && s.contains("brown");
        Predicate<String> otherEggs = s -> s.contains("egg") && !s.contains("brown");
        
        // using and() and negate()
        Predicate<String> brownEggs2 = egg.and(brown);
        Predicate<String> otherEggs2 = egg.and(brown.negate());
        
        // CONSUMER
        
        Consumer<String> c1 = x -> System.out.println("1: " + x);
        Consumer<String> c2 = x -> System.out.println(",2: " + x);
        
        // using andThen()
        Consumer<String> combined = c1.andThen(c2);
        combined.accept("Annie"); // 1: Annie,2: Annie
        
        // FUNCTION

        Function<Integer, Integer> before = x -> x + 1;
        Function<Integer, Integer> after = x -> x * 2;
        
        // using compose()
        Function<Integer, Integer> combined2 = after.compose(before);
        System.out.println(combined2.apply(3)); // 8
    }
}
