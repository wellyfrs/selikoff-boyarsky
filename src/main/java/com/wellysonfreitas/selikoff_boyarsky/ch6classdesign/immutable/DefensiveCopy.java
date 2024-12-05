package com.wellysonfreitas.selikoff_boyarsky.ch6classdesign.immutable;

import java.util.ArrayList;

@SuppressWarnings("SizeReplaceableByIsEmpty")
final class Animal3 {
    private final ArrayList<String> favoriteFoods;
    
    public Animal3(ArrayList<String> favoriteFoods) {
        if (favoriteFoods == null || favoriteFoods.size() == 0)
            throw new RuntimeException("favoriteFoods is required");
        // this.favoriteFoods = favoriteFoods; // without defensive copy
        this.favoriteFoods = new ArrayList<String>(favoriteFoods); // with defensive copy
    }
    
    public int getFavoriteFoodsCount() {
        return favoriteFoods.size();
    }
    
    public String getFavoriteFoodsItem(int index) {
        return favoriteFoods.get(index);
    }

    public static void main(String[] args) {
        var favorites = new ArrayList<String>();
        favorites.add("Apples");
        
        var zebra = new Animal3(favorites); // Caller still has access to favorites
        System.out.println(zebra.getFavoriteFoodsItem(0)); // [Apples]
        
        favorites.clear();
        favorites.add("Chocolate Chip Cookies");
        // Without defensive copy:
        // System.out.println(zebra.getFavoriteFoodsItem(0)); // [Chocolate Chip Cookies]
        
        // With defensive copy:
        System.out.println(zebra.getFavoriteFoodsItem(0)); // [Apples]
    }
}
