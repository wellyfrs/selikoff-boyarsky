package com.wellysonfreitas.selikoff_boyarsky.ch6classdesign.immutable;

/*

IMMUTABLE CLASS

Immutable object is one that cannot change state after it is created.

Rules:

1. Mark the class as final OR make all of the constructors private.
2. Mark all the instance variables private and final.
3. Don't define any setter methods.
4. Don't allow referenced mutable objects to be modified.
5. Use a constructor to set all properties of the object, making a copy if needed.

*/

import java.util.ArrayList;
import java.util.List;

// Mutable example

final class Animal { // Not an immutable object declaration
    private final ArrayList<String> favoriteFoods;
    
    public Animal() {
        this.favoriteFoods = new ArrayList<String>();
        this.favoriteFoods.add("Apples");
    }
    
    public List<String> getFavoriteFoods() {
        return favoriteFoods;
    }

    public static void main(String[] args) {
        var zebra = new Animal();
        System.out.println(zebra.getFavoriteFoods()); // [Apples]
        
        zebra.getFavoriteFoods().clear();
        zebra.getFavoriteFoods().add("Chocolate Chip Cookies"); // object is changed
        System.out.println(zebra.getFavoriteFoods()); // [Chocolate Chip Cookies]
    }
}

// Immutable

final class Animal2 { // An immutable object declaration
    private final List<String> favoriteFoods;
    
    public Animal2() {
        this.favoriteFoods = new ArrayList<String>();
        this.favoriteFoods.add("Apples");
    }
    
    public int getFavoriteFoodsCount() {
        return favoriteFoods.size();
    }
    
    public String getFavoriteFoodsItem(int index) {
        return favoriteFoods.get(index);
    }

    // Alternative is make a copy,
    // which can be expensive operation if called frequently by the caller.
    public ArrayList<String> getFavoriteFoods() {
        return new ArrayList<String>(this.favoriteFoods);
    }
}
