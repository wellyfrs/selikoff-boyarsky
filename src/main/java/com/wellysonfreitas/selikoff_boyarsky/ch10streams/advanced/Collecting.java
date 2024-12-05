package com.wellysonfreitas.selikoff_boyarsky.ch10streams.advanced;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.minBy;

@SuppressWarnings("Convert2MethodRef")
public class Collecting {

    public static void main(String[] args) {
        // USING BASIC COLLECTORS
        
        var ohMy = Stream.of("lions", "tigers", "bears");
        String result = ohMy.collect(Collectors.joining(","));
        System.out.println(result); // lions,tigers,bears
        
        // Another example
        var ohMy2 = Stream.of("lions", "tigers", "bears");
        Double result2 = ohMy2.collect(Collectors.averagingInt(String::length));
        System.out.println(result2); // 5.333333333333333
        
        // Stream and Collector
        var ohMy3 = Stream.of("lions", "tigers", "bears");
        TreeSet<String> result3 = ohMy3
                .filter(s -> s.startsWith("t"))
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(result3); // [tigers]
        
        // COLLECTING INTO MAPS
        
        // Map (example: { name: key }
        var ohMy4 = Stream.of("lions", "tigers", "bears");
        Map<String, Integer> map = ohMy4.collect(
                Collectors.toMap(s -> s, String::length));
        System.out.println(map); // {lions=5, bears=5, tigers=6}
     
        // Map (example: { length: name }
        // Incorrect
//        var ohMy5 = Stream.of("lions", "tigers", "bears");
//        Map<Integer, String> map2 = ohMy5.collect(Collectors.toMap(
//                String::length,
//                k -> k)); // BAD - IllegalStateException: Duplicate key 5
        
        // Correct
        var ohMy6 = Stream.of("lions", "tigers", "bears");
        Map<Integer, String> map3 = ohMy6.collect(Collectors.toMap(
                String::length,
                k -> k,
                (s1, s2) -> s1 + "," + s2));
        System.out.println(map3); // {5=lions,bears, 6=tigers}
        System.out.println(map3.getClass()); // class java.util.HashMap
        
        // TreeMap
        var ohMy7 = Stream.of("lions", "tigers", "bears");
        TreeMap<Integer, String> map4 = ohMy7.collect(Collectors.toMap(
                String::length,
                k -> k,
                (s1, s2) -> s1 + "," + s2,
                TreeMap::new));
        System.out.println(map); // {5=lions,bears 6=tigers}
        System.out.println(map.getClass()); // class java.util.TreeMap
        
        // GROUPING, PARTITIONING, AND MAPPING
        
        // GROUPING
        
        var ohMy8 = Stream.of("lions", "tigers", "bears");
        Map<Integer, List<String>> map5 = ohMy8.collect(
                groupingBy(String::length));
        System.out.println(map5); // {5=[lions, bears], 6=[tigers]}
        
        // Changing the type of the map values (from List to Set) using a downstream collector
        var ohMy9 = Stream.of("lions", "tigers", "bears");
        Map<Integer, Set<String>> map6 = ohMy9.collect(
                groupingBy(
                        String::length,
                        Collectors.toSet())); // downstream collector
        System.out.println(map6); // {5=[lions, bears], 6=[tigers]}
        
        // Change the type of Map returned (from HashMap to TreeMap)
        var ohMy10 = Stream.of("lions", "tigers", "bears");
        TreeMap<Integer, Set<String>> map7 = ohMy10.collect(
                groupingBy(
                        String::length,
                        TreeMap::new,
                        Collectors.toSet()));
        System.out.println(map7); // {5=[lions, bears], 6=[tigers]}
        
        // Changing the type of the map (TreeMap) values (from Set to List)
        var ohMy11 = Stream.of("lions", "tigers", "bears");
        TreeMap<Integer, List<String>> map8 = ohMy11.collect(
                groupingBy(
                        String::length,
                        TreeMap::new,
                        Collectors.toList()));
        System.out.println(map8); // {5=[lions,bears], 6=[tigers]}
        
        // PARTITIONING
        
        // Partitioning is a special case of grouping.
        // With partitioning, there are only two possible groups: true and false.
        // Partitioning is like splitting a list into two parts.
        
        var ohMy12 = Stream.of("lions", "tigers", "bears");
        Map<Boolean, List<String>> map9 = ohMy12.collect(
                Collectors.partitioningBy(s -> s.length() <= 5)); // predicate
        System.out.println(map9); // {false=[tigers], true=[lions, bears]}
        
        // Changing the predicate
        var ohMy13 = Stream.of("lions", "tigers", "bears");
        Map<Boolean, List<String>> map10 = ohMy13.collect(
                Collectors.partitioningBy(s -> s.length() <= 7));
        System.out.println(map10); // {false=[], true=[lions, tigers, bears]}
        
        // Changing the type of the Map values (from List to Set) with a downstream collector
        var ohMy14 = Stream.of("lions", "tigers", "bears");
        Map<Boolean, Set<String>> map11 = ohMy14.collect(
                Collectors.partitioningBy(
                        s -> s.length() <= 7,
                        Collectors.toSet())); // downstream collector
        System.out.println(map11); // {false=[], true=[lions, tigers, bears]}
        
        var ohMy15 = Stream.of("lions", "tigers", "bears");
        Map<Integer, Long> map12 = ohMy15.collect(
                groupingBy(
                        String::length,
                        Collectors.counting()));
        System.out.println(map12); // {5=2, 6=1}
        
        // MAPPING
        
        // The most complicated thing you need to understand for the exam
        var ohMy16 = Stream.of("lions", "tigers", "bears");
        Map<Integer, Optional<Character>> map13 = ohMy16.collect(
                groupingBy(
                        String::length,
                        mapping(
                                s -> s.charAt(0),
                                minBy((a, b) -> a - b))));
        System.out.println(map13); // {5=Optional[b], 6=Optional[t]}
        
        // Using var, static imports, and less indentation (difficult to read)
        var ohMy17 = Stream.of("lions", "tigers", "bears");
        var map14 = ohMy17.collect(groupingBy(String::length,
                mapping(s -> s.charAt(0), minBy((a, b) -> a - b))));
        System.out.println(map14); // {5=Optional[b], 6=Optional[t]}
        
        // TEEING COLLECTORS

        record Separations(String spaceSeparated, String commaSeparated) {}
        var list = List.of("x", "y", "z");
        Separations result4 = list.stream()
                .collect(Collectors.teeing(
                        Collectors.joining(" "),
                        Collectors.joining(","),
                        (s, c) -> new Separations(s, c)));
        System.out.println(result4); // Separations[spaceSeparated=x y z, commaSeparated=x,y,z]
    }
}
