package com.wellysonfreitas.selikoff_boyarsky.ch13concurrency.collections;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryConsistencyErrors {

    public static void main(String[] args) {
        // ConcurrentModificationException can happen even in a single thread
        var foodData = new HashMap<String, Integer>();
        foodData.put("penguin", 1);
        foodData.put("flamingo", 2);
        for (String key : foodData.keySet()) {
            foodData.remove(key); // throws a ConcurrentModificationException in the 2nd iteration
        }
        
        // ConcurrentHashMap
        var foodData2 = new ConcurrentHashMap<String, Integer>();
        foodData2.put("penguin", 1);
        foodData2.put("flamingo", 2);
        for (String key : foodData2.keySet()) {
            foodData2.remove(key); // OK
        }
    }
}
