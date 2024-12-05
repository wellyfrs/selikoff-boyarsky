package com.wellysonfreitas.selikoff_boyarsky.ch1buildingblocks.variables;

/*

GARBAGE COLLECTION (GC)

All Java objects are stored in the memory's heap. The heap, which is also referred to as the free store,
represents a large pool of unused memory allocated to your Java application.
If your program keeps instantiating objects and leaving them on the heap,
eventually it will run out of memory and crash.

Garbage collection refers to the process of automatically freeing memory on the heap
by deleting objects that are no longer reachable in your program.
GC allows the JVM to reclaim memory for other objects.
There are many different algorithms for garbage collection.

In Java and other languages, "eligible for garbage collection" refers to
an object's state of no longer being accessible in a program
and therefore able to be garbage collected.

An object is no longer reachable when one of two situations occurs:
- The object no longer has any references pointing to it.
- All references to the object have gone out of scope.

This does not mean garbage collection will occur immediately.
An object may be eligible for GC but never removed from the heap.

*/

@SuppressWarnings("StringOperationCanBeSimplified")
class GarbageCollection {
    public static void main(String[] args) {
        // Built-in method to help support garbage collection
        // where you can suggest that garbage collection run:
        System.gc();
        
        // ELIGIBILITY FOR GARBAGE COLLECTION
        
        String one, two;
        one = new String("a");
        two = new String("b");
        one = two; // "a" is eligible for GC
        String three = one;
        one = null; // "b" is eligible for GC
    }
}
