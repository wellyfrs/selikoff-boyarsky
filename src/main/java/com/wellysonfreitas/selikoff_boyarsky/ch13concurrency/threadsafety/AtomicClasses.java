package com.wellysonfreitas.selikoff_boyarsky.ch13concurrency.threadsafety;

// PROTECTING DATA WITH ATOMIC CLASSES
// Atomic is the property of an operation to be carried out as a single unit of execution
// without any interference from another thread.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings({"FieldMayBeFinal", "Convert2MethodRef"})
class SheepManagerWithAtomicType {
    private AtomicInteger sheepCount = new AtomicInteger(0);
    private void incrementAndReport() {
        System.out.println(sheepCount.incrementAndGet() + " ");
    }
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(20);
        try {
            SheepManagerWithAtomicType manager = new SheepManagerWithAtomicType();
            for (int i = 0; i < 10; i++)
                service.submit(() -> manager.incrementAndReport());
        } finally {
            service.shutdown();
        }
    }
}
// Possible outputs (not missing numbers, but still out of order):
// 2 3 1 4 5 6 7 8 9 10
// 1 4 3 2 5 6 7 8 9 10
// 1 4 3 5 6 2 7 8 10 9
