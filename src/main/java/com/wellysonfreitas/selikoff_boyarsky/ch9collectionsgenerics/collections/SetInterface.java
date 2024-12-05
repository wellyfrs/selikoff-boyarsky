package com.wellysonfreitas.selikoff_boyarsky.ch9collectionsgenerics.collections;

/*

Set is used for collections without duplicate entries.

Implementations:

- HashSet: stores its elements in a hash table.
HashSet uses the hashCode() method of the object to retrieve them more efficiently.
The hashCode() doesn't mean every object will get a unique value,
but the method is often written so that hash values are spread out over a large range to reduce collisions.

- TreeSet: stores its elements in a sorted tree structure.
Benefit is that the set is always in sorted order.
Trade-off: adding and checking whether an element exists takes longer than
with a HashSet, especially as the tree grows larger.

*/

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@SuppressWarnings({"OverwrittenKey", "ConstantValue"})
public class SetInterface {

    public static void main(String[] args) {
        // WORKING WITH Set METHODS
        
        Set<Character> letters = Set.of('z', 'o', 'o');
        Set<Character> copy = Set.copyOf(letters);
        
        Set<Integer> set = new HashSet<>();
        boolean b1 = set.add(66); // true
        boolean b2 = set.add(10); // true
        boolean b3 = set.add(66); // false
        boolean b4 = set.add(8); // true
        set.forEach(System.out::println);
        // prints (arbitrary order):
        // 66
        // 8
        // 10
        
        // Same example with TreeSet
        Set<Integer> set2 = new TreeSet<>();
        boolean b5 = set.add(66); // true
        boolean b6 = set.add(10); // true
        boolean b7 = set.add(66); // false
        boolean b8 = set.add(8); // true
        set.forEach(System.out::println);
        // prints (ordered):
        // 8
        // 10
        // 66
    }
}
