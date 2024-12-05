package com.wellysonfreitas.selikoff_boyarsky.ch13concurrency.collections;

// WORKING WITH CONCURRENT CLASSES

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

// CopyOnWrite classes
// Create a copy of the collection any time a reference is added, removed, or changed in the collection
// and then update the original collection reference to point to the copy.
// Commonly used to ensure an iterator doesn't see modifications to the collection.
// Also, they can use a lot of memory. Are commonly used in multithreaded environment situations
// where reads are far more common that writes.
// Similar to an immutable object,
// but the reference to the object stays the same even while the underlying data is changed.
class CopyOnWrite {
    public static void main(String[] args) {
        List<Integer> favNumbers = new CopyOnWriteArrayList<>(List.of(4, 3, 42));
        for (var n: favNumbers) { // the iterator is not modified
            System.out.println(n + " "); // 4 3 42
            favNumbers.add(n + 1);
        }
        System.out.println();
        System.out.println("Size: " + favNumbers.size()); // Size 6
    }
}
