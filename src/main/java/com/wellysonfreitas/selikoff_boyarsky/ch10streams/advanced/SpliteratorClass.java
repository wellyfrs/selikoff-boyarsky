package com.wellysonfreitas.selikoff_boyarsky.ch10streams.advanced;

/*

Spliterator (short for "Splittable Iterator") is an interface introduced in Java 8
design to traverse and partition elements of a source, such as a `Collection`, for parallel processing.

*/

import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;

public class SpliteratorClass {

    public static void main(String[] args) {
        var stream = List.of("bird-", "bunny-", "cat-", "dog-", "fish-", "lamb-", "mouse-");
        Spliterator<String> originalBagOfFood = stream.spliterator();
        Spliterator<String> emmasBag = originalBagOfFood.trySplit();
        emmasBag.forEachRemaining(System.out::print); // bird-bunny-cat-
        
        Spliterator<String> jillsBag = originalBagOfFood.trySplit();
        jillsBag.tryAdvance(System.out::print); // dog-
        jillsBag.forEachRemaining(System.out::print); // fish-
        
        originalBagOfFood.forEachRemaining(System.out::print); // lamb-mouse-
        
        var originalBag = Stream.iterate(1, n -> ++n)
                .spliterator();
        
        Spliterator<Integer> newBag = originalBag.trySplit();
        
        newBag.tryAdvance(System.out::print); // 1
        newBag.tryAdvance(System.out::print); // 2
        newBag.tryAdvance(System.out::print); // 3
    }
}
