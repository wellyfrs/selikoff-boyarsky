package com.wellysonfreitas.selikoff_boyarsky.ch13concurrency.problems;

/*

DEADLOCK

Occurs when two or more threads are blocked forever, each waiting on the other.
Both participants are permanently blocked, waiting on resources that will never become available.

*/

import java.util.concurrent.Executors;

class Food {}
class Water {}

@SuppressWarnings({"SynchronizationOnLocalVariableOrMethodParameter", "CatchMayIgnoreException"})
record Fox(String name) {
    public void eatAndDrink(Food food, Water water) {
        synchronized (food) {
            System.out.println(name() + " Got Food!");
            move();
            synchronized (water) {
                System.out.println(name() + " Got Water!");
            }
        }
    }
    public void drinkAndEat(Food food, Water water) {
        synchronized (water) {
            System.out.println(name() + " Got Water!");
            move();
            synchronized (food) {
                System.out.println(name() + " Got Food!");
            }
        }
    }
    public void move() {
        try { Thread.sleep(100); } catch (InterruptedException e) { }
    }
    public static void main(String[] args) {
        // Create participants and resources
        var foxy = new Fox("Foxy");
        var tails = new Fox("Tails");
        var food = new Food();
        var water = new Water();
        // Process data
        var service = Executors.newScheduledThreadPool(10);
        try {
            service.submit(() -> foxy.eatAndDrink(food, water));
            service.submit(() -> tails.drinkAndEat(food, water));
        } finally {
            service.shutdown();
        }
    }
}
// Output:
// Foxy Got Food!
// Tails Got Water! (and hangs indefinitely)
