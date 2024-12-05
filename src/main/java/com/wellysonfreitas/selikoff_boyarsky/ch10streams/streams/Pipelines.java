package com.wellysonfreitas.selikoff_boyarsky.ch10streams.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings({"ConstantValue", "EndlessStream", "SimplifyStreamApiCallChains", "ReplaceInefficientStreamCount"})
public class Pipelines {

    public static void main(String[] args) {
        var list = List.of("Toby", "Anna", "Leroy", "Alex");

        // Without streams
        List<String> filtered = new ArrayList<>();
        for (String name: list)
            if (name.length() == 4) filtered.add(name);
        
        Collections.sort(filtered);
        var iter = filtered.iterator();
        if (iter.hasNext()) System.out.println(iter.next());
        if (iter.hasNext()) System.out.println(iter.next());
        
        // With streams
        list.stream().filter(n -> n.length() == 4).sorted()
                .limit(2).forEach(System.out::println);
        
        // Another example
        Stream.generate(() -> "Elsa")
                .filter(n -> n.length() == 4)
                .sorted() // hangs on
                .limit(2)
                .forEach(System.out::println);
        
        // Another example
        Stream.generate(() -> "Elsa")
                .filter(n -> n.length() == 4)
                .limit(2)
                .sorted()
                .forEach(System.out::println); // prints Elsa twice

        // Another example
        Stream.generate(() -> "Olaf Lazisson")
                .filter(n -> n.length() == 4)
                .limit(2)
                .sorted()
                .forEach(System.out::println); // hangs on
        // hangs on because filter doesn't allow anything through, so limit() never sees two elements
        
        // Another example with two pipelines chained together
        long count = Stream.of("goldfish", "finch")
                .filter(s -> s.length() > 5)
                .collect(Collectors.toList())
                .stream() // second stream
                .count();
        System.out.println(count); // 1
        
        // Another style for the previous example
        List<String> helper = Stream.of("goldfish", "finch")
                .filter(s -> s.length() > 5)
                .collect(Collectors.toList());
        long count2 = helper.stream()
                .count();
        System.out.println(count2);
    }
}
