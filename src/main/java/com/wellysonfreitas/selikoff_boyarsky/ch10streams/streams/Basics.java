package com.wellysonfreitas.selikoff_boyarsky.ch10streams.streams;

/*

A stream in Java is a sequence of data.

A stream pipeline consists of the operations that run on a stream to produce a result.

*/

import java.util.List;
import java.util.stream.Stream;

public class Basics {

    public static void main(String[] args) {
        Stream<String> empty = Stream.empty(); // count = 0
        Stream<Integer> singleElement = Stream.of(1); // count = 1
        Stream<Integer> fromVarargs = Stream.of(1, 2, 3); // count = 3
        
        var arr = new int[]{ 1, 2, 3 };
//        Stream<Integer> fromArray = Stream.of(arr); // DOES NOT COMPILE

        var list = List.of("a", "b", "c");
        
        // Converting a collection to a stream
        Stream<String> fromList = list.stream();
        
        // Parallel Stream
        Stream<String> fromListParallel = list.parallelStream();
        
        // CREATING INFINITE STREAMS
        
        Stream<Double> randoms = Stream.generate(Math::random);
        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
        
//        randoms.forEach(System.out::println); // will print random numbers until you kill it
        
        // Stream Reference
        System.out.println(empty); // java.util.stream.ReferencePipeline$3@4517d9a3
        
        // Overloaded version of iterate()
        Stream<Integer> oddNumberUnder100 = Stream.iterate(
                1, // seed
                n -> n < 100, // Predicate to specify when done
                n -> n + 2 // UnaryOperator to get next value
        );
    }
}
