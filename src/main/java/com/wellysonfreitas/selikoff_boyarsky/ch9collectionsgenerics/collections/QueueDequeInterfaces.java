package com.wellysonfreitas.selikoff_boyarsky.ch9collectionsgenerics.collections;

/*

Queue is used to add and remove elements in a specific order,
like FIFO (first-in, first-out), or LIFO (last-in, first-out), also known as stacks.

Deque (double-ended queue) allows insert and remove elements from both the front (head) and back (tail).

Implementations:

- LinkedList: implements both List and Deque.
Main benefit is access, add to, and remove from the beginning and end of the list in constant time.
Trade-off: dealing with an arbitrary index takes linear time.
Good when you'll be using it as Deque.
You can use ArrayDeque if you don't need the List methods.

*/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings({"MismatchedQueryAndUpdateOfCollection", "ResultOfMethodCallIgnored"})
public class QueueDequeInterfaces {

    public static void main(String[] args) {
        // Queue
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(4);
        System.out.println(queue.remove()); // 10
        System.out.println(queue.peek()); // 4

        // Deque
        Deque<Integer> deque = new LinkedList<>();
        deque.offerFirst(10); // true (10)
        deque.offerLast(4); // true (10)-(4)
        deque.peekFirst(); // 10 (10)-(4)
        deque.pollFirst(); // 10 (4)
        deque.pollLast(); // 4
        deque.pollFirst(); // null
        deque.peekFirst(); // null
        
        // USING A Deque AS A STACK
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(10); // (10)
        stack.push(4); // (4)-(10)
        stack.peek(); // 4 (4)-(10)
        stack.poll(); // 4 (10)
        stack.poll(); // 10
        stack.peek(); // null
    }
}
