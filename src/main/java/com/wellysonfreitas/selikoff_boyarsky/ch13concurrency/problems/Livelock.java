package com.wellysonfreitas.selikoff_boyarsky.ch13concurrency.problems;

/*

LIVELOCK

Occurs when two or more threads are conceptually blocked forever,
although they are each still active and trying to complete their task.
Livelock is a special case of resource starvation in which two or more threads actively try to
acquire a set of locks, are unable to do so, and restart part of the process.
Livelock is often a result of two threads trying to resolve a deadlock.
Livelock if often difficult issue to detect.
Threads in a livelock state appear active and able to respond to request,
even when they are stuck in an endless cycle.

*/

public class Livelock {

}
