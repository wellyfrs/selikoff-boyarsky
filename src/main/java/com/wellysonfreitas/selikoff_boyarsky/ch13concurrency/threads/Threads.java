package com.wellysonfreitas.selikoff_boyarsky.ch13concurrency.threads;

/*

How to create a thread and its associated task:

- Provide a Runnable object or lambda expression to the Thread constructor; or
- Create a class that extends Thread and overrides the run() method.

Runnable interface:

@FunctionalInterface
public interface Runnable {
    void run();
}

*/

@SuppressWarnings("CallToThreadRun")
public class Threads {

    public static void main(String[] args) {
        // Creating a Thread object passing a Runnable
        new Thread(() -> System.out.println("Hello")).start();
        System.out.println("World");
        // the printing order ("Hello" or "World") is not guaranteed
        
        // Another example
        
        Runnable printInventory = () -> System.out.println("Printing zoo inventory");
        Runnable printRecords = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Printing record: " + i);
            }
        };

        System.out.println("begin");
        new Thread(printInventory).start();
        new Thread(printRecords).start();
        new Thread(printInventory).start();
        System.out.println("end");
        
        // CALLING run() INSTEAD OF start()
        // Calling run() on a Thread or a Runnable does not start a new thread.

        System.out.println("begin");
        new Thread(printInventory).run();
        new Thread(printRecords).run();
        new Thread(printInventory).run();
        System.out.println("end");
    }
}

// DISTINGUISHING THREAD TYPES

@SuppressWarnings({"Convert2MethodRef", "CatchMayIgnoreException"})
class Zoo {
    public static void pause() { // Defines the thread task
        try {
            Thread.sleep(10_000); // Wait for 10 seconds
        } catch (InterruptedException e) {}
        System.out.println("Thread finished!");
    }

    public static void main(String[] unused) {
        var job = new Thread(() -> pause()); // Create thread
//        job.setDaemon(true); // makes terminate without printing in pause()
        job.start(); // Start thread
        System.out.println("Main method finished!");
    }
}

// MANAGING A THREAD'S LIFE CYCLE

// POLLING WITH SLEEP

class CheckResults {
    private static int counter = 0;
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) counter++;
        }).start();
        while (counter < 1_000_000) {
            System.out.println("Not reached yet");
        }
        System.out.println("Reached: " + counter);
    }
}

@SuppressWarnings("BusyWait")
class CheckResultsWithSleep {
    private static int counter = 0;
    public static void main(String[] a) {
        new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) counter++;
        }).start();
        while (counter < 1_000_000) {
            System.out.println("Not reached yet");
            try {
                Thread.sleep(1_000); // 1 SECOND
            } catch (InterruptedException e) {
                System.out.println("Interrupted!");
            }
        }
        System.out.println("Reached: " + counter);
    }
}

// INTERRUPTING A THREAD

@SuppressWarnings("BusyWait")
class CheckResultsWithSleepAndInterrupt {
    private static int counter = 0;
    public static void main(String[] a) {
        final var mainThread = Thread.currentThread();
        new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) counter++;
            mainThread.interrupt();
        }).start();
        while (counter < 1_000_000) {
            System.out.println("Not reached yet");
            try {
                Thread.sleep(1_000); // 1 SECOND
            } catch (InterruptedException e) {
                System.out.println("Interrupted!");
            }
        }
        System.out.println("Reached: " + counter);
    }
}
