package com.wellysonfreitas.selikoff_boyarsky.ch13concurrency.concurrencyapi;

/*

Concurrency API -> java.util.concurrent

The essence of the Concurrency API is to do complex things with threads
without having to manage threads directly.

*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Executor {
    public static void main(String[] args) {
        // SINGLE-THREAD EXECUTOR

        Runnable printInventory = () -> System.out.println("Printing zoo inventory");
        Runnable printRecords = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Printing record: " + i);
            }
        };
        
        ExecutorService service = Executors.newSingleThreadExecutor();
        try {
            System.out.println("begin");
            service.execute(printInventory);
            service.execute(printRecords);
            service.execute(printInventory);
            System.out.println("end");
        } finally {
            service.shutdown(); // Must shutdown(), because it's a non-daemon
        }
    }
}

// SHUTTING DOWN A THREAD EXECUTOR
// shutdown()
// shutdownNow()

// SUBMITTING TASKS
// execute() (returns void)
// submit() (returns Future)
