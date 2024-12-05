package com.wellysonfreitas.selikoff_boyarsky.ch9collectionsgenerics.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"Convert2Diamond", "ConstantValue", "Convert2MethodRef", "EqualsBetweenInconvertibleTypes"})
public class CommonMethods {

    public static void main(String[] args) {
        // DIAMOND OPERATOR
        
        // without diamond
        List<Integer> list = new ArrayList<Integer>();
        Map<Long, List<Integer>> mapLists = new HashMap<Long, List<Integer>>();
        
        // with diamond
        List<Integer> list2 = new ArrayList<>();
        Map<Long, List<Integer>> mapOfLists = new HashMap<>();
        
//        List<> list = new ArrayList<Integer>(); // DOES NOT COMPILE
        
        class InvalidUse {
//            void use(List<> data) {} // DOES NOT COMPILE
        }
        
        // ADDING DATA
        // public boolean add(E element)
        
        Collection<String> list3 = new ArrayList<>();
        System.out.println(list3.add("Sparrow")); // true
        System.out.println(list3.add("Sparrow")); // true

        Collection<String> set = new HashSet<>();
        System.out.println(set.add("Sparrow")); // true
        System.out.println(set.add("Sparrow")); // true
        
        // REMOVING DATA
        // public boolean remove(Object object)
        
        Collection<String> birds = new ArrayList<>();
        birds.add("hawk"); // [hawk]
        birds.add("hawk"); // [hawk, hawk]
        System.out.println(birds.remove("cardinal")); // false
        System.out.println(birds.remove("hawk")); // true
        System.out.println(birds); // [hawk]
        
        // COUNTING ELEMENTS
        // public boolean isEmpty()
        // public int size()
        
        Collection<String> birds2 = new ArrayList<>();
        System.out.println(birds2.isEmpty()); // true
        System.out.println(birds2.size()); // 0
        birds2.add("hawk"); // [hawk]
        birds2.add("hawk"); // [hawk, hawk]
        System.out.println(birds2.isEmpty()); // false
        System.out.println(birds2.size()); // 2
        
        // CLEARING THE COLLECTION
        // public void clear()
        
        Collection<String> birds3 = new ArrayList<>();
        birds3.add("hawk"); // [hawk]
        birds3.add("hawk"); // [hawk, hawk]
        System.out.println(birds3.isEmpty()); // false
        System.out.println(birds3.size()); // 2
        birds3.clear(); // []
        System.out.println(birds3.isEmpty()); // true
        System.out.println(birds3.size()); // 0
        
        // CHECK CONTENTS
        // public boolean contains(Object object)
        
        Collection<String> birds4 = new ArrayList<>();
        birds4.add("hawk"); // [hawk]
        System.out.println(birds4.contains("hawk")); // true
        System.out.println(birds4.contains("hawk")); // false
        
        // REMOVING WITH CONDITIONS
        // public boolean removeIf(Predicate<? super E> filter)
        
        Collection<String> list4 = new ArrayList<>();
        list4.add("Magician");
        list4.add("Assistant");
        System.out.println(list4); // [Magician, Assistant]
        list4.removeIf(s -> s.startsWith("A"));
        System.out.println(list3); // [Magician]
        
        // Another example
        Collection<String> set2 = new HashSet<>();
        set2.add("Wand");
        set2.add("");
        set2.removeIf(String::isEmpty); // s -> s.isEmpty()
        System.out.println(set2); // [Wand]
        
        // ITERATING
        // public void forEach(Consumer<? super T> action)
        
        Collection<String> cats = List.of("Annie", "Ripley");
        cats.forEach(System.out::println);
        cats.forEach(c -> System.out.println(c));
        
        // DETERMINING EQUALITY
        // boolean equals(Object object)
        
        var list5 = List.of(1, 2);
        var list6 = List.of(2, 1);
        var set3 = Set.of(1, 2);
        var set4 = Set.of(2, 1);

        System.out.println(list5.equals(list6)); // false
        System.out.println(set3.equals(set4)); // true
        System.out.println(list5.equals(set3)); // false
        
        // UNBOXING NULLS
        var heights = new ArrayList<Integer>();
        heights.add(null);
        int h = heights.get(0); // NullPointerException
    }
}
