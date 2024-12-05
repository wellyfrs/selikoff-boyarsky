package com.wellysonfreitas.selikoff_boyarsky.ch9collectionsgenerics.sorting;

/*

public interface Comparable<T> {
    int compareTo(T o);
}

- The number 0 is returned when the current object is equivalent to the argument to compareTo().
- A negative number (less than 0) is returned when the current object is smaller than the argument to compareTo().
- A positive number (greater than 0) is returned when the current object is larger than the argument to compareTo().

*/

import java.util.*;

@SuppressWarnings("FieldMayBeFinal")
class Duck implements Comparable<Duck> {
    private String name;
    public Duck(String name) {
        this.name = name;
    }
    public String toString() { // use readable output
        return name;
    }
    @Override
    public int compareTo(Duck d) {
        return name.compareTo(d.name); // sorts ascendingly by name
    }
    public static void main(String[] args) {
        var ducks = new ArrayList<Duck>();
        ducks.add(new Duck("Quack"));
        ducks.add(new Duck("Puddles"));
        Collections.sort(ducks); // sort by name
        System.out.println(ducks); // [Puddles, Quack]
    }
}

// Another example

@SuppressWarnings("EqualsWithItself")
class Animal implements Comparable<Animal> {
    private int id;
    public int compareTo(Animal a) {
//        return a.id - id; // sorts in descending order
        return id - a.id; // sorts ascending by id
    }
    public static void main(String[] args) {
        var a1 = new Animal();
        var a2 = new Animal();
        a1.id = 5;
        a2.id = 7;
        System.out.println(a1.compareTo(a2)); // -2
        System.out.println(a1.compareTo(a1)); // 0
        System.out.println(a2.compareTo(a1)); // 2
    }
}

// CASTING THE compareTo() ARGUMENT

@SuppressWarnings({"rawtypes", "NullableProblems"})
class LegacyDuck implements Comparable {
    private String name;
    public int compareTo(Object obj) {
        LegacyDuck d = (LegacyDuck) obj; // cast because no generics
        return name.compareTo(d.name);
    }
}

// CHECKING FOR null

class MissingDuck implements Comparable<MissingDuck> {
    private String name;
    public int compareTo(MissingDuck quack) {
        if (quack == null)
            throw new IllegalArgumentException("Poorly formed duck!");
        if (this.name == null && quack.name == null)
            return 0;
        else if (this.name == null) return -1;
        else if (quack.name == null) return 1;
        else return name.compareTo(quack.name);
    }
}

// KEEPING compareTo() AND equals() CONSISTENT

// A natural ordering that uses compareTo() is said to be consistent with equals if,
// and only if, x.equals(y) is true whenever x.compareTo(y) equals 0.
// Similarly, x.equals(y) must be false whenever x.compareTo(y) is not 0.

@SuppressWarnings("PatternVariableCanBeUsed")
class Product implements Comparable<Product> {
    private int id;
    private String name;
    
    public int hashCode() { return id; }
    public boolean equals(Object obj) {
        if (!(obj instanceof Product)) return false;
        var other = (Product) obj;
        return this.id == other.id;
    }
    public int compareTo(Product obj) {
        return this.name.compareTo(obj.name);
    }
}
