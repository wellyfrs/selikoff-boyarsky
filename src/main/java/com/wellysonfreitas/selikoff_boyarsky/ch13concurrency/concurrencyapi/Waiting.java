package com.wellysonfreitas.selikoff_boyarsky.ch13concurrency.concurrencyapi;

// WAITING FOR RESULTS

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class WaitingResults {

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<?> future = service.submit(() -> System.out.println("Hello"));
    }
}

class CheckResults2 {
    private static int counter = 0;

    public static void main(String[] unused) throws Exception {
        ExecutorService service = Executors.newSingleThreadExecutor();
        try {
            Future<?> result = service.submit(() -> {
                for (int i = 0; i < 1_000_000; i++) counter++;
            });
            result.get(10, TimeUnit.SECONDS); // Returns null for Runnable
        } catch (TimeoutException e) {
            System.out.println("Not reached in time");
        } finally {
            service.shutdown();
        }
    }
}

/*

INTRODUCING CALLABLE

What is the difference between Runnable and Callable?

Callable interface is often preferable over Runnable,
since it allows more details to be retrieved easily from the task after it is completed.

@FunctionalInterface
public interface Callable<V> {
    V call() throws Exception;
}

*/

class IntroducingCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var service = Executors.newSingleThreadExecutor();
        try {
            Future<Integer> result = service.submit(() -> 30 + 11);
            System.out.println(result.get()); // 41
        } finally {
            service.shutdown();
        }
    }
}

// WAITING FOR ALL TASKS TO FINISH

@SuppressWarnings({"EmptyTryBlock", "ResultOfMethodCallIgnored"})
class WaitingAllTasksToFinish {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        try {
            // Add tasks to the thread executor
        } finally {
            service.shutdown();
        }
        service.awaitTermination(1, TimeUnit.MINUTES);
        // Check whether all tasks are finished
        if (service.isTerminated()) System.out.println("Finished!");
        else System.out.println("At least one task is still running");
    }
}
