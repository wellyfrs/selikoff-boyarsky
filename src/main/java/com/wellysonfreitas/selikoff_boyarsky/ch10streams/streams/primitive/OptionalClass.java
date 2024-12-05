package com.wellysonfreitas.selikoff_boyarsky.ch10streams.streams.primitive;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@SuppressWarnings("OptionalGetWithoutIsPresent")
public class OptionalClass {

    public static void main(String[] args) {
        // Calculating the average
        var stream = IntStream.rangeClosed(1, 10);
        OptionalDouble optional = stream.average();
        
        // What is the difference between Optional<Double> and OptionalDouble?
        // Optional<Double> is for wrapper Double class
        // OptionalDouble is for primitive double
        
        optional.ifPresent(System.out::println); // 5.5
        System.out.println(optional.getAsDouble()); // 5.5 (getAsDouble() instead of get())
        System.out.println(optional.orElseGet(() -> Double.NaN)); // 5.5
        
        // Another example
        LongStream longs = LongStream.of(5, 10);
        long sum = longs.sum();
        System.out.println(sum); // 15
        DoubleStream doubles = DoubleStream.generate(() -> Math.PI);
//        OptionalDouble min = doubles.min(); // runs infinitely
    }

    // SUMMARIZING STATISTICS
    private static int max(IntStream ints) {
//        OptionalInt optional = ints.max();
//        return optional.orElseThrow(RuntimeException::new);
        
        // Let's say we need to return the range max() - min().
        // But these functions are terminal operations, and we would need two streams.
        // Solution is use summary statistics
        IntSummaryStatistics stats = ints.summaryStatistics();
        if (stats.getCount() == 0) throw new RuntimeException();
        return stats.getMax()-stats.getMin();
        
        // Statistics includes count, average, sum, min, and max.
    }
}
