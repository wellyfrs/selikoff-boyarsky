package com.wellysonfreitas.selikoff_boyarsky.ch10streams.streams.primitive;

import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@SuppressWarnings({"Convert2MethodRef", "OptionalGetWithoutIsPresent", "MismatchedQueryAndUpdateOfCollection", "RedundantOperationOnEmptyContainer", "SimplifyStreamApiCallChains"})
public class Basics {

    public static void main(String[] args) {
        // Calculating the sum of numbers in a finite stream
        Stream<Integer> stream = Stream.of(1, 2, 3);
        System.out.println(stream.reduce(0, (s, n) -> s + n)); // 6
        
        // Another way
        Stream<Integer> stream2 = Stream.of(1, 2, 3);
        System.out.println(stream2.mapToInt(x -> x).sum()); // 6
        
        // Calculating average
        IntStream intStream = IntStream.of(1, 2, 3);
        OptionalDouble avg = intStream.average();
        System.out.println(avg.getAsDouble()); // 2.0
        
        // CREATING PRIMITIVE STREAMS
        // Three types:
        // - IntStream: used for the primitive types int, short, byte, and char
        // - LongStream: used for the primitive type long
        // - DoubleStream: used for the primitive types double and float.

        // Examples
        DoubleStream empty = DoubleStream.empty();
        
        DoubleStream oneValue = DoubleStream.of(3.14);
        oneValue.forEach(System.out::println);
        
        DoubleStream varargs = DoubleStream.of(1.0, 1.1, 1.2);
        varargs.forEach(System.out::println);
        // prints:
        // 3.14
        // 1.0
        // 1.1
        // 1.2
        
        // Two methods for creating infinite streams
        var random = DoubleStream.generate(Math::random);
        var fractions = DoubleStream.iterate(.5, d -> d / 2);
        random.limit(3).forEach(System.out::println);
        fractions.limit(3).forEach(System.out::println);
        
        // start inclusive, end exclusive
        IntStream range = IntStream.range(1, 6);
        range.forEach(System.out::println); // 12345
        
        // both start and end inclusive
        IntStream rangeClosed = IntStream.rangeClosed(1, 5);
        rangeClosed.forEach(System.out::println); // 12345
        
        // MAPPING STREAMS
        
        Stream<String> objStream = Stream.of("penguin", "fish");
        IntStream intStream2 = objStream.mapToInt(s -> s.length());
        
        // Using flatMap()
        
        var integerList = new ArrayList<Integer>();
        IntStream ints = integerList.stream()
                .flatMapToInt(x -> IntStream.of(x));
        DoubleStream doubles = integerList.stream()
                .flatMapToDouble(x -> DoubleStream.of(x));
        LongStream longs = integerList.stream()
                .flatMapToLong(x -> LongStream.of(x));
    }

    // Creating a Stream from a primitive stream in two ways
    
    private static Stream<Integer> mapping(IntStream stream) {
        return stream.mapToObj(x -> x);
    }
    
    private static Stream<Integer> boxing(IntStream stream) {
        return stream.boxed();
    }
}
