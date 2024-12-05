package com.wellysonfreitas.selikoff_boyarsky.ch13concurrency.threadsafety;

// UNDERSTANDING THE LOCK FRAMEWORK
// Lock interface is conceptually similar to using the synchronized keyword
// but with a lot more bells and whistles. Instead of synchronizing on any Object, though,
// we can "lock" only on an object that implements the Lock interface.

// APPLYING A ReentrantLock

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@SuppressWarnings("SynchronizationOnLocalVariableOrMethodParameter")
class ApplyingReentrantLock {

    public static void main(String[] args) {
        // Implementation #1 with a synchronized block
        Object object = new Object();
        synchronized(object) {
            // Protected code
        }

        // Implementation #2 with a Lock
        Lock lock = new ReentrantLock(); // ReentrantLock is a simple monitor that implements Lock interface
        try {
            lock.lock();
            // Protected code
        } finally {
            lock.unlock(); // using try/finally block with Lock instances is a good practice
        }

        // FAIRNESS
        // If fair param is true, lock will usually be granted to each thread in the order it was requested
        Lock lock2 = new ReentrantLock(true); // fair: true
        // It is false by default when using the no-argument constructor
        Lock lock3 = new ReentrantLock(false); // fair: false
        // is equivalent to
        Lock lock4 = new ReentrantLock();

        // Only release a lock that you have
        Lock lock5 = new ReentrantLock();
        lock5.unlock(); // IllegalMonitorStateException (trying to release lock without having it -- lock())
    }
}

// ATTEMPTING TO ACQUIRE A LOCK

class AttemptingToAcquireLock {
    public static void printHello(Lock lock) {
        try {
            lock.lock(); // requests lock and blocks until lock is acquired
            System.out.println("Hello");
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        // tryLock()
        Lock lock = new ReentrantLock();
        new Thread(() -> printHello(lock)).start();
        if (lock.tryLock()) { // requests lock and returns immediately a boolean indicating success or not
            try {
                System.out.println("Lock obtained, entering protected code");
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("Unable to acquire lock, doing something else");
        }

        // tryLock(long, TimeUnit)
        Lock lock2 = new ReentrantLock();
        new Thread(() -> printHello(lock2)).start();
        if (lock2.tryLock(10, TimeUnit.SECONDS)) {
            try {
                System.out.println("Lock obtained, entering protected code");
            } finally {
                lock2.unlock();
            }
        } else {
            System.out.println("Unable to acquire lock, doing something else");
        }
    }
}

// ACQUIRING THE SAME LOCK TWICE
// It is critical that you release a lock the same number of times it is acquired!

class AcquiringTheSameLockTwice {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        if (lock.tryLock()) { // first time granted
            try {
                lock.lock(); // granted twice
                System.out.println("Lock obtained, entering protected code");
            } finally {
                lock.unlock(); // releasing once
            }
        }

        new Thread(() -> System.out.print(lock.tryLock())).start(); // false
    }
}


/*

REVIEWING THE LOCK FRAMEWORK

ReentrantLock supports the same features as a synchronized block with improvements:
- Ability to request a lock without blocking.
- Ability to request a lock while blocking for a specified amount of time.
- A lock can be created with a fairness property, in which the lock is granted to threads
in the order in which it was requested.

*/
