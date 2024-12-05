package com.wellysonfreitas.selikoff_boyarsky.ch8lambdasfunctionalinterfaces.functionalinterface.builtins;

/*

Consumer is used to do something with a parameter but not return anything.
BiConsumer does the same thing, except that it takes two parameters.

Defined as follows:

@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
    // omitted default method
}

@FunctionalInterface
public interface BiConsumer<T, U> {
    void accept(T t, U u);
    // omitted default method
}

*/

import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

@SuppressWarnings({"Convert2MethodRef", "MismatchedQueryAndUpdateOfCollection"})
class ImplementingConsumerAndBiConsumer {

    public static void main(String[] args) {
        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = x -> System.out.println(x);
        
        c1.accept("Annie"); // prints Annie
        c2.accept("Annie"); // prints Annie
        
        // Parameters don't need to be the same type
        var map = new HashMap<String, String>();
        BiConsumer<String, String> b1 = map::put;
        BiConsumer<String, String> b2 = (k, v) -> map.put(k, v);
        
        b1.accept("chicken", "Cluck");
        b2.accept("chick", "Tweep");

        System.out.println(map); // {chicken=Cluck, chick=Tweep}
    }
}
