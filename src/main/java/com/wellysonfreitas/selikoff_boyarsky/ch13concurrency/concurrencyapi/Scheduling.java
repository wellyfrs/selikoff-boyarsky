package com.wellysonfreitas.selikoff_boyarsky.ch13concurrency.concurrencyapi;

// SCHEDULING TASKS

// While tasks are scheduled in the future, the actual execution may be delayed.
// There may be no threads available to perform the tasks.
// The executor could be also shut down before the tasks start executing.

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class SchedulingTasks {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        Runnable task1 = () -> System.out.println("Hello Zoo");
        Callable<String> task2 = () -> "Monkey";
        ScheduledFuture<?> r1 = service.schedule(task1, 10, TimeUnit.SECONDS);
        ScheduledFuture<?> r2 = service.schedule(task2, 8, TimeUnit.MINUTES);
    }
}
