package com.wellysonfreitas.selikoff_boyarsky.ch10streams.streams;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings({
        "ConstantValue",
        "DataFlowIssue",
        "RedundantOperationOnEmptyContainer",
        "StringConcatenationInLoop",
        "Convert2MethodRef"
})
public class TerminalOps {

    public static void main(String[] args) {
        // COUNTING
        // Does not terminate infinite streams. Returns long value. It's a reduction.
        // public long count()

        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        System.out.println(s.count()); // 3
        
        // MINIMUM AND MAXIMUM
        // Does not terminate infinite streams. Returns Optional<T>. It's a reduction.
        // public Optional<T> min(Comparator<? super T> comparator)
        // public Optional<T> max(Comparator<? super T> comparator)

        // The animal with the fewest letters in its name
        Stream<String> s2 = Stream.of("monkey", "ape", "bonobo");
        Optional<String> min = s2.min((a, b) -> a.length() - b.length());
        min.ifPresent(System.out::println); // ape
        
        // When there is not a minimum
        Optional<?> minEmpty = Stream.empty().min((a, b) -> 0);
        System.out.println(minEmpty.isPresent()); // false
        
        // FINDING A VALUE
        // Terminates infinite streams. Returns Optional<T>. It's not a reduction.
        // public Optional<T> findAny()
        // public Optional<T> findFirst()

        Stream<String> s3 = Stream.of("monkey", "gorilla", "bonobo");
        Stream<String> infinite = Stream.generate(() -> "chimp");
        s3.findAny().ifPresent(System.out::println); // monkey (usually)
        infinite.findAny().ifPresent(System.out::println); // chimp
        
        // MATCHING
        // Sometimes terminates infinite streams. Returns boolean. It's not a reduction.
        // public boolean anyMatch(Predicate <? super T> predicate)
        // public boolean allMatch(Predicate <? super T> predicate)
        // public boolean noneMatch(Predicate <? super T> predicate)
        
        var list = List.of("monkey", "2", "chimp");
        Stream<String> infinite2 = Stream.generate(() -> "chimp");
        Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
        // The predicate is reused, but a new stream is required each time
        System.out.println(list.stream().anyMatch(pred)); // true
        System.out.println(list.stream().allMatch(pred)); // false
        System.out.println(list.stream().noneMatch(pred)); // false
        System.out.println(infinite2.anyMatch(pred)); // true
//        System.out.println(infinite2.allMatch(pred)); // runs forever
        
        // ITERATING
        // Does not terminate infinite streams. Returns void. It's not a reduction.
        // public void forEach(Consumer<? super T> action)
        
        Stream<String> s4 = Stream.of("Monkey", "Gorilla", "Bonobo");
        s4.forEach(System.out::println); // MonkeyGorillaBonobo
        // You can call forEach() directly on a Collection or on a Stream. Both approaches are fine.
        Collections.emptyList().forEach(System.out::println);
        
        // Can't use a traditional loop on a stream (streams don't implement Iterable)
        Stream<Integer> s5 = Stream.of(1);
//        for (Integer i: s5) {} // DOES NOT COMPILE
        
        // REDUCING
        // Combines a stream into a single object.
        // Does not terminate infinite streams. Return value varies. It's a reduction.
        
        // Identity is the initial value of the reduction.
        // Accumulator combines the current result with the current value in the stream.
        
        // public T reduce(T identity, BinaryOperator<T> accumulator)
        // public Optional<T> reduce(BinaryOperator<T> accumulator)
        // public <U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
        // This last one is useful with parallel streams.
        
        // Example of concatenating an array of strings
        // Without functional programming
        var array = new String[] { "w", "o", "l", "f" };
        var result = "";
        for (var str: array) result = result + str;
        System.out.println(result); // wolf
        
        // With functional programming
        Stream<String> stream = Stream.of("w", "o", "l", "f");
        String word = stream.reduce("", (str, c) -> str + c);
        System.out.println(word); // wolf
        
        // With a method reference
        String word2 = stream.reduce("", String::concat);
        System.out.println(word2); // wolf
        
        // Another example
        Stream<Integer> stream2 = Stream.of(3, 5, 6);
        System.out.println(stream2.reduce(1, (a, b) -> a*b)); // 90
        
        // In many cases, the identity is not necessary, so Java lets us omit it.
        // Java will return an Optional:
        // - if the stream is empty, an empty Optional is returned
        // - if the stream has one element, it is returned
        // - if the stream has multiple elements, the accumulator is applied to combine them
        BinaryOperator<Integer> op = (a, b) -> a * b;
        Stream<Integer> empty = Stream.empty();
        Stream<Integer> oneElement = Stream.of(3);
        Stream<Integer> threeElements = Stream.of(3, 5, 6);
        
        empty.reduce(op).ifPresent(System.out::println); // no input
        oneElement.reduce(op).ifPresent(System.out::println); // 3
        threeElements.reduce(op).ifPresent(System.out::println); // 90
        
        // Another example
        Stream<String> stream3 = Stream.of("w", "o", "l", "f");
        int length = stream3.reduce(0, (i, str) -> i + str.length(), (a, b) -> a + b);
        System.out.println(length); // 5
        
        // COLLECTING
        // Does not terminate infinite streams. Return value varies. It's a reduction.
        // public <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner)
        // public <R, A> R collect(Collector<? super T, A, R> collector)
        
        Stream<String> stream4 = Stream.of("w", "o", "l", "f");
        StringBuilder word3 = stream4.collect(
                StringBuilder::new,
                StringBuilder::append,
                StringBuilder::append
        );
        System.out.println(word3); // wolf
        
        // Another example
        Stream<String> stream5 = Stream.of("w", "o", "l", "f");
        TreeSet<String> set = stream5.collect(
                TreeSet::new,
                TreeSet::add,
                TreeSet::addAll
        );
        System.out.println(set); // [f, l, o, w]
        
        // With common collectors from Collectors
        TreeSet<String> set2 = stream.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set2); // [f, l, o, w]
        
        // Without sorting, it's even shorter
        Set<String> set3 = stream.collect(Collectors.toSet());
        System.out.println(set3); // [f, w, l, o]
    }
}
