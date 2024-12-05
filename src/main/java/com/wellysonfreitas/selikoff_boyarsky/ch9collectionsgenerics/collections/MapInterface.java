package com.wellysonfreitas.selikoff_boyarsky.ch9collectionsgenerics.collections;

/*

Map is used to identify values by a key.

Implementations:

- HashMap: stores the keys in a hash table.
Main benefit is adding elements and retrieving the element by key in constant time.
Trade-off: lose the order in which you inserted the elements.

- TreeMap: stores the keys in a sorted tree structure.
Main benefit is that keys are always in sorted order.
Trade-off: like a TreeSet, adding and checking whether a key is present,
takes longer as the tree grows larger.

*/

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiFunction;

@SuppressWarnings({"ConstantValue", "Java8MapForEach", "Convert2MethodRef"})
public class MapInterface {

    public static void main(String[] args) {
        // HashMap
        Map<String, String> map = new HashMap<>();
        map.put("koala", "bamboo");
        map.put("lion", "meat");
        map.put("giraffe", "leaf");
        String food = map.get("koala"); // bamboo
        for (String key: map.keySet())
            System.out.print(key + ","); // koala,giraffe,lion,
        
        // TreeMap
        Map<String, String> map2 = new TreeMap<>();
        map2.put("koala", "bamboo");
        map2.put("lion", "meat");
        map2.put("giraffe", "leaf");
        String food2 = map2.get("koala"); // bamboo
        for (String key: map2.keySet())
            System.out.println(key + ","); // giraffe,koala,lion, (ordered)
        
        // Boolean checks
        // contains() method is on the Collection interface but not the Map interface
//        System.out.println(map2.contains("lion")); // DOES NOT COMPILE
        System.out.println(map2.containsKey("lion")); // true
        System.out.println(map2.containsValue("lion")); // false
        System.out.println(map2.size()); // 3
        map2.clear();
        System.out.println(map2.size()); // 0
        System.out.println(map2.isEmpty()); // true
        
        // ITERATING THROUGH A MAP
        
        Map<Integer, Character> map3 = new HashMap<>();
        map3.put(1, 'a');
        map3.put(2, 'b');
        map3.put(3, 'c');
        map3.forEach((k, v) -> System.out.print(v)); // not using the key, so:
        map3.values().forEach(System.out::println);
        
        map3.entrySet().forEach(e -> System.out.print(e.getKey() + " " + e.getValue()));
        
        // GETTING VALUES SAFELY
        
        Map<Character, String> map4 = new HashMap<>();
        map4.put('x', "spot");
        System.out.println("X marks the " + map4.get('x')); // X marks the spot
        System.out.println("X marks the " + map4.getOrDefault('x', "")); // X marks the spot
        System.out.println("Y marks the " + map4.get('y')); // Y marks the null
        System.out.println("Y marks the " + map4.getOrDefault('y', "")); // Y marks the 
        
        // REPLACING VALUES
        
        Map<Integer, Integer> map5 = new HashMap<>();
        map5.put(1, 2);
        map5.put(2, 4);
        Integer original = map5.replace(2, 10); // 4
        System.out.println(map5); // {1=2, 2=10}
        map5.replaceAll((k, v) -> k + v);
        System.out.println(map); // {1=3, 2=12}
        
        // PUTTING IF ABSENT
        // putIfAbsent() sets a value in the map but skips it if the value is already set to a non-null value
        
        Map<String, String> favorites = new HashMap<>();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", null);
        favorites.putIfAbsent("Jenny", "Tram");
        favorites.putIfAbsent("Sam", "Tram");
        favorites.putIfAbsent("Tom", "Tram");
        System.out.println(favorites); // {Tom=Tram, Jenny=Bus Tour, Sam=Tram}
        
        // MERGING DATA
        // merge() adds logic of what to choose

        BiFunction<String, String, String> mapper = (v1, v2)
         -> v1.length() > v2.length() ? v1 : v2;
        
        Map<String, String> favorites2 = new HashMap<>();
        favorites2.put("Jenny", "Bus Tour");
        favorites2.put("Tom", "Tram");
        
        String jenny = favorites2.merge("Jenny", "Skyride", mapper);
        String tom = favorites2.merge("Tom", "Skyride", mapper);

        System.out.println(favorites2); // {Tom=Skyride, Jenny=Bus Tour}
        System.out.println(jenny); // Bus Tour
        System.out.println(tom); // Skyride
        
        // null values or missing keys
        
        BiFunction<String, String, String> mapper2 =
         (v1, v2) -> v1.length() > v2.length() ? v1 : v2;
        Map<String, String> favorites3 = new HashMap<>();
        favorites3.put("Sam", null);
        favorites3.merge("Tom", "Skyride", mapper2);
        favorites3.merge("Sam", "Skyride", mapper2);
        System.out.println(favorites3); // {Tom=Skyride, Sam=Skyride}
        
        BiFunction<String, String, String> mapper3 = (v1, v2) -> null;
        Map<String, String> favorites4 = new HashMap<>();
        favorites4.put("Jenny", "Bus Tour");
        favorites4.put("Tom", "Bus Tour");
        
        favorites4.merge("Jenny", "Skyride", mapper3);
        favorites4.merge("Sam", "Skyride", mapper3);
        System.out.println(favorites4); // {Tom=Bus Tour, Sam=Skyride}
    }
}
