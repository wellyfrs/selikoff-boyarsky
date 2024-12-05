package com.wellysonfreitas.selikoff_boyarsky.ch9collectionsgenerics.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@SuppressWarnings({"Java8ListSort", "FieldMayBeFinal"})
class Duck2 implements Comparable<Duck2> {
    private String name;
    private int weight;

    public Duck2(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
    
    public int getWeight() {
        return this.weight;
    }
    
    public String toString() { return name; }
    
    public int compareTo(Duck2 d) {
        return name.compareTo(d.name);
    }

    public static void main(String[] args) {
        Comparator<Duck2> byWeight = new Comparator<Duck2>() {
            public int compare(Duck2 d1, Duck2 d2) {
                return d1.getWeight() - d2.getWeight();
            }
        };
        var ducks = new ArrayList<Duck2>();
        ducks.add(new Duck2("Quack", 7));
        ducks.add(new Duck2("Puddles", 10));
        Collections.sort(ducks);
        System.out.println(ducks); // [Puddles, Quack]
        Collections.sort(ducks, byWeight);
        System.out.println(ducks); // [Quack, Puddles]
        
        // Alternatives
        Comparator<Duck2> byWeight2 = (d1, d2) -> d1.getWeight() - d2.getWeight();
        Comparator<Duck2> byWeight3 = Comparator.comparing(Duck2::getWeight);
        
        // COMPARING Comparable AND Comparator
        
//        var byWeight4 = new Comparator<Duck2>() { // DOES NOT COMPILE
//            public int compareTo(Duck2 d1, Duck2 d2) {
//                return d1.getWeight() - d2.getWeight();
//            }
//        };
    }
}

// COMPARING MULTIPLE FIELDS

@SuppressWarnings("FieldMayBeFinal")
class Squirrel {
    private int weight;
    private String species;
    
    public Squirrel(int weight, String species) {
        this.weight = weight;
        this.species = species;
    }
    
    public int getWeight() {
        return this.weight;
    }
    
    public String getSpecies() {
        return this.species;
    }
}

class MultiFieldComparator implements Comparator<Squirrel> {
    public int compare(Squirrel s1, Squirrel s2) {
        int result = s1.getSpecies().compareTo(s2.getSpecies());
        if (result != 0) return result;
        return s1.getWeight() - s2.getWeight();
    }

    // Alternatively, use chaining and method reference
    public static void main(String[] args) {
        Comparator<Squirrel> c = Comparator.comparing(Squirrel::getSpecies)
                .thenComparingInt(Squirrel::getWeight);
        
        // Another example in descending order
        var c2 = Comparator.comparing(Squirrel::getSpecies)
                .reversed();
    }
}

// SORTING AND SEARCHING

@SuppressWarnings({"Java8ListSort", "ComparatorCombinators"})
class SortRabbits {
    static record Rabbit(int id) {}

    public static void main(String[] args) {
        List<Rabbit> rabbits = new ArrayList<>();
        rabbits.add(new Rabbit(3));
        rabbits.add(new Rabbit(1));
//        Collections.sort(rabbits); // DOES NOT COMPILE
        
        Comparator<Rabbit> c = (r1, r2) -> r1.id - r2.id;
        Collections.sort(rabbits, c);
        System.out.println(rabbits); // [Rabbit[id=1], Rabbit[id=3]]
        
        // Descending order
        Comparator<Rabbit> c2 = (r1, r2) -> r1.id - r2.id;
        Collections.sort(rabbits, c2);
        Collections.reverse(rabbits);
        System.out.println(rabbits); // [Rabbit[id=3], Rabbit[id=1]]
        
        // Reviewing binarySearch()
        List<Integer> list = Arrays.asList(6, 9, 1, 8);
        Collections.sort(list); // [1, 6, 8, 9]
        System.out.println(Collections.binarySearch(list, 6)); // 1
        System.out.println(Collections.binarySearch(list, 3)); // -2
        
        // Sorting with binarySearch()
        var names = Arrays.asList("Fluffy", "Hoppy");
        Comparator<String> c3 = Comparator.reverseOrder();
        var index = Collections.binarySearch(names, "Hoppy", c3);
        System.out.println(index); // answer is not defined (ascending sorting precondition is not met)
    }
}

@SuppressWarnings({"MismatchedQueryAndUpdateOfCollection", "SortedCollectionWithNonComparableKeys", "ComparatorCombinators"})
class UseTreeSet {
    static class Rabbit { int id; }

    public static void main(String[] args) {
        Set<Duck2> ducks = new TreeSet<>();
        ducks.add(new Duck2("Puddles", 10));
        Set<Rabbit> rabbits = new TreeSet<>();
        rabbits.add(new Rabbit()); // ClassCastException
        
        // sorting by ID
        Set<Rabbit> rabbits2 = new TreeSet<>((r1, r2) -> r1.id - r2.id);
        rabbits2.add(new Rabbit());
    }
}

// SORTING A LIST

@SuppressWarnings({"Convert2MethodRef", "ComparatorCombinators"})
class SortingList {

    public static void main(String[] args) {
        List<String> bunnies = new ArrayList<>();
        bunnies.add("long ear");
        bunnies.add("floppy");
        bunnies.add("hoppy");
        System.out.println(bunnies); // [long ear, floppy, hoppy]
        bunnies.sort((b1, b2) -> b1.compareTo(b2));
        System.out.println(bunnies); // [floppy, hoppy, long ear]
    }
}
