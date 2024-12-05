package com.wellysonfreitas.selikoff_boyarsky.ch5methods.overloading;

/*

METHOD CHOICE ORDER

1. Exact match by type
2. Larger primitive type
3. Autoboxed type
4. Varargs

*/

class Glider {
    // Exact match by type
    public static String glide(int i, int j) {
        return "1";
    }
    
    // Larger primitive type
    public static String glide(long i, long j) {
        return "2";
    }
    
    // Autoboxed type
    public static String glide(Integer i, Integer j) {
        return "3";
    }
    
    // Varargs
    public static String glide(int... nums) {
        return "4";
    }
    
    public static void main(String[] args) {
        System.out.print(glide(1, 2));
    }
}

// Another example

class Glider2 {
    public static String glide(String s) {
        return "1";
    }
    
    public static String glide(String... s) {
        return "2";
    }
    
    public static String glide(Object o) {
        return "3";
    }
    
    public static String glide(String s, String t) {
        return "4";
    }

    public static void main(String[] args) {
        System.out.print(glide("a")); // 1
        System.out.print(glide("a", "b")); // 4
        System.out.print(glide("a", "b", "c")); // 2
        // prints 142
    }
}
