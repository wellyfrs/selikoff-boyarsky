package com.wellysonfreitas.selikoff_boyarsky.ch10streams.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@SuppressWarnings("Convert2MethodRef")
public class IntermediateOps {

    public static void main(String[] args) {
        // FILTERING
        // public Stream<T> filter(Predicate<? super T> predicate)

        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        s.filter(x -> x.startsWith("m"))
                .forEach(System.out::print); // monkey
        
        // REMOVING DUPLICATES
        // public Stream<T> distinct()
        
        Stream<String> s2 = Stream.of("duck", "duck", "duck", "goose");
        s2.distinct()
                .forEach(System.out::print); // duckgoose
        
        // RESTRICTING BY POSITION
        // public Stream<T> limit(long maxSize)
        // public Stream<T> skip(long n)
        
        Stream<Integer> s3 = Stream.iterate(1, n -> n + 1);
        s3.skip(5)
                .limit(2)
                .forEach(System.out::print); // 67
        
        // MAPPING
        // public <R> Stream<R> map(Function<? super T, ? extends R> mapper)
        Stream<String> s4 = Stream.of("monkey", "gorilla", "bonobo");
        s4.map(String::length)
                .forEach(System.out::print); // 676
        
        // USING FLATMAP
        // public <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)

        List<String> zero = List.of();
        var one = List.of("Bonobo");
        var two = List.of("Mama Gorilla", "Baby Gorilla");
        Stream<List<String>> animals = Stream.of(zero, one, two);
        
        animals.flatMap(m -> m.stream())
                .forEach(System.out::println);
        // prints:
        // Bonobo
        // Mama Gorilla
        // Baby Gorilla
        
        // You don't need flatMap to concatenate streams,
        // you can use `concat`
        var oneStream = Stream.of(one);
        var twoStream = Stream.of(two);
        Stream.concat(oneStream, twoStream)
                .forEach(System.out::println);
        
        // SORTING
        // public Stream<T> sorted()
        // public Stream<T> sorted(Comparator<? super T> comparator)
        
        Stream<String> s5 = Stream.of("brown-", "bear-");
        s5.sorted()
                .forEach(System.out::print); // bear-brown-
        
        // With a Comparator
        Stream<String> s6 = Stream.of("brown bear-", "grizzly-");
        s6.sorted(Comparator.reverseOrder())
                .forEach(System.out::print); //  grizzly-brown bear-
        
        // Tricky
        Stream<String> s7 = Stream.of("brown bear-", "grizzly-");
//        s7.sorted(Comparator::reverseOrder); // DOES NOT COMPILE (reverseOrder() is a Supplier<Comparator>
        
        // TAKING A PEEK
        // peek() is an intermediate version of forEach() that returns the original stream to you.
        // public Stream<T> peek(Consumer<? super T? action)
        
        var stream = Stream.of("black bear", "grizzly");
        long count = stream.filter(str -> str.startsWith("g"))
                .peek(System.out::println).count(); // grizzly
        System.out.println(count); // 1
        
        // Danger: Changing State with peek()
        var numbers = new ArrayList<>();
        var letters = new ArrayList<>();
        numbers.add(1);
        letters.add('a');
        Stream<List<?>> stream2 = Stream.of(numbers, letters);
        stream2.map(List::size).forEach(System.out::print); // 11
        
        // Bad usage of peek(), which is modifying the data structure that is used in the stream
        Stream<List<?>> bad = Stream.of(numbers, letters);
        bad.peek(x -> x.remove(0))
                .map(List::size)
                .forEach(System.out::print); // 00
    }
}
