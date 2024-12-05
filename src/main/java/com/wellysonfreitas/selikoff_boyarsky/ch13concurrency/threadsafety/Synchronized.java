package com.wellysonfreitas.selikoff_boyarsky.ch13concurrency.threadsafety;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// IMPROVING ACCESS WITH synchronized BLOCKS

// A monitor, also called a lock, is a structure that supports mutual exclusion,
// which is the property that at most one thread is executing a particular segment of code at a given time.
// In Java, any Object can be used as a monitor, along with synchronized keyword.

// To synchronize access across multiple threads, each thread must have access to the same Object.
// If each thread synchronizes on different objects, the code is not thread-safe.

@SuppressWarnings("Convert2MethodRef")
class SheepManagerWithSynchronizedBlock {
    private int sheepCount = 0;
    private void incrementAndReport() {
        synchronized (this) {
            System.out.println((++sheepCount) + " ");
        }
    }
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(20);
        try {
            var manager = new SheepManagerWithSynchronizedBlock();
            for (int i = 0; i < 10; i++)
                service.submit(() -> manager.incrementAndReport());
        } finally {
            service.shutdown();
        }
    }
}
// Only possible output:
// 1 2 3 4 5 6 7 8 9 10

// SYNCHRONIZING ON METHODS

class SynchronizingOnMethods {
    void sing() {
        synchronized (this) {
            System.out.println("La la la");
        }
    }
    // is equivalent to
    synchronized void sing2() {
        System.out.println("La la la");
    }
    
    // Static
    static void dance() {
        synchronized (SynchronizingOnMethods.class) {
            System.out.println("Time to dance!");
        }
    }
    // is equivalent to
    static synchronized void dance2() {
        System.out.println("Time to dance!");
    }
}
