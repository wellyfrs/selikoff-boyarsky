package com.wellysonfreitas.selikoff_boyarsky.ch13concurrency.parallelstreams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// CREATING PARALLEL STREAMS
class CreatingParallelStreams {
    public static void main(String[] args) {
        Collection<Integer> collection = List.of(1, 2);
        
        Stream<Integer> p1 = collection.stream().parallel();
        Stream<Integer> p2 = collection.parallelStream();
    }
}

// PERFORMING A PARALLEL DECOMPOSITION
@SuppressWarnings({"CatchMayIgnoreException", "Convert2MethodRef"})
class PerformingParallelStreams {
    private static int doWork(int input) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {}
        return input;
    }
    
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List.of(1, 2, 3, 4, 5)
//                .stream() // using serial stream prints: 1 2 3 4 5 \ Time: 25 seconds
                .parallelStream() // using parallel stream prints: 3 4 2 1 4 (any order) \ Time: 5 seconds
                .map(w -> doWork(w))
//                .forEachOrdered(s -> System.out.println(s + " ")); // prints: 1 2 3 4 5 (ordered) \ Time: 5 seconds
                .forEach(s -> System.out.println(s + " ")); // prints: 1 5 4 3 2 (any order) \ Time: 5 seconds
        System.out.println();
        var timeTaken = (System.currentTimeMillis() - start) / 1000;
        System.out.println("Time: " + timeTaken + " seconds");
    }
}

// PROCESSING PARALLEL REDUCTIONS

@SuppressWarnings({"OptionalGetWithoutIsPresent", "SimplifyStreamApiCallChains", "ResultOfMethodCallIgnored"})
class ProcessingParallelReductions {
    public static void main(String[] args) {
        // PERFORMING ORDER-BASED TASKS
        System.out.println(List.of(1, 2, 3, 4, 5)
                .parallelStream()
                .findAny() // neither the serial nor the parallel stream is guaranteed to return the first value
                .get()); // random return
        
        // Creating unordered streams
        List.of(1, 2, 3, 4, 5, 6).stream().unordered(); // no effect
        List.of(1, 2, 3, 4, 5, 6).stream().unordered().parallel(); // improve performance
        
        // COMBINING RESULTS WITH reduce()
        // <U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
        // On parallel streams, the reduce() method works by applying the reduction to pairs of elements within the
        // stream to create intermediate values and then combining those intermediate values to produce a final result.
        // With parallel streams, we now have to be concerned about order. Make sure that the accumulator and combiner
        // produce the same result regardless of the order they are called in.

        System.out.println(List.of('w', 'o', 'l', 'f')
                .parallelStream()
                .reduce(
                        "",
                        (s1,c) -> s1 + c,
                        (s2,s3) -> s2 + s3)); // wolf

        System.out.println(List.of(1,2,3,4,5,6)
                .parallelStream()
                .reduce(0, (a,b) -> (a-b))); // PROBLEMATIC ACCUMULATOR

        System.out.println(List.of("w", "o", "l", "f")
                .parallelStream()
                .reduce("X", String::concat)); // XwXoXlXf (on a serial stream, it prints Xwolf)
        
        // COMBINING RESULTS WITH collect()
        // <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R,R> combiner)
        
        Stream<String> stream = Stream.of("w", "o", "l", "f").parallel();
        SortedSet<String> set = stream.collect(ConcurrentSkipListSet::new,
                Set::add,
                Set::addAll);
        System.out.println(set); // [f, l, o, w]
        
        // PERFORMING A PARALLEL REDUCTION ON A COLLECTOR
        // Requirements for Parallel Reduction with collect():
        // - The stream is parallel
        // - The parameter of the collect() operation has the Characteristics.CONCURRENT characteristic.
        // - Either the stream is unordered or the collector has the characteristic Characteristics.UNORDERED

        Stream<String> stream2 = Stream.of("lions", "tigers", "bears").parallel();
        stream2.collect(Collectors.toSet()); // Not a parallel reduction
        
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears").parallel();
        ConcurrentMap<Integer, String> map = ohMy
                .collect(Collectors.toConcurrentMap(String::length, 
                        k -> k,
                        (s1, s2) -> s1 + ", " + s2));
        System.out.println(map); // {5=lions,bears, 6=tigers}
        System.out.println(map.getClass()); // java.util.concurrent.ConcurrentHashMap
        
        var ohMy2 = Stream.of("lions", "tigers", "bears").parallel();
        ConcurrentMap<Integer, List<String>> map2 = ohMy2.collect(
                Collectors.groupingByConcurrent(String::length));
        System.out.println(map2); // {5=[lions,bears], 6=[tigers]}
    }
}

// AVOIDING STATEFUL STREAMS

@SuppressWarnings("Convert2MethodRef")
class AvoidingStatefulStreams {
    public static List<Integer> addValues(IntStream source) {
        var data = Collections.synchronizedList(new ArrayList<Integer>());
        source.filter(s -> s % 2 == 0)
                .forEach(i -> { data.add(i); }); // STATEFUL: DON'T DO THIS!
        return data;
    }
    
    public static List<Integer> addValuesBetter(IntStream source) {
        return source.filter(s -> s % 2 == 0)
                .boxed()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        var list = addValues(IntStream.range(1, 11));
        System.out.println(list); // [2, 4, 6, 8, 10]
        
        var list2 = addValues(IntStream.range(1, 11).parallel());
        System.out.println(list2); // [6, 8, 10, 2, 4]
    }
}
