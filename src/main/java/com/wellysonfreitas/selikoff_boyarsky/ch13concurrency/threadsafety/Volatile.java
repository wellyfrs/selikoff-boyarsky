package com.wellysonfreitas.selikoff_boyarsky.ch13concurrency.threadsafety;

/*

Thread-safety is the property of an object that guarantees safe execution by multiple threads at the same time.

- Individual variables
- Blocks of code and locks
- Orchestrating complex tasks with many steps

*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Example of NOT thread-safe code
@SuppressWarnings("Convert2MethodRef")
class SheepManager {
    private int sheepCount = 0;
    private void incrementAndReport() {
        System.out.println((++sheepCount) + " "); // problem is here (operator ++ is not thread-safe)
    }
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(20);
        try {
            SheepManager manager = new SheepManager();
            for (int i = 0; i < 10; i++)
                service.submit(() -> manager.incrementAndReport());
        } finally {
            service.shutdown();
        }
    }
}
// Possible outputs:
// 1 2 3 4 5 6 7 8 9 10
// 1 9 8 7 3 6 6 2 4 5 (repeating 6, missing 10)
// 1 8 7 3 2 6 5 4 2 9 (repeating 2, missing 10)

// ACCESSING DATA WITH VOLATILE
// The keyword `volatile` is used to guarantee that access to data within memory is consistent.
// However, it does not provide thread-safety. For example, incrementing a volatile variable is still two operations.
// In practice, `volatile` is rarely used.

@SuppressWarnings({"NonAtomicOperationOnVolatileField", "Convert2MethodRef"})
class SheepManagerWithVolatileVariable {
    private volatile int sheepCount = 0; // using volatile variable
    private void incrementAndReport() {
        System.out.println((++sheepCount) + " "); // still not thread-safe (increment is a non-atomic operation) 
    }
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(20);
        try {
            SheepManagerWithVolatileVariable manager = new SheepManagerWithVolatileVariable();
            for (int i = 0; i < 10; i++)
                service.submit(() -> manager.incrementAndReport());
        } finally {
            service.shutdown();
        }
    }
}
// Possible outputs:
// 2 6 1 7 5 3 2 9 4 8 (repeating 2, missing 10) - still missing numbers
