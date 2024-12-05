package com.wellysonfreitas.selikoff_boyarsky.ch2operators.unary;

@SuppressWarnings("ConstantValue")
class LogicalComplement {
    public static void main(String[] args) {
        boolean isAnimalAsleep = false;
        System.out.println(isAnimalAsleep); // false
        
        isAnimalAsleep = !isAnimalAsleep;
        System.out.println(isAnimalAsleep); // true
        
        // int pelican = !5; // DOES NOT COMPILE
        // boolean peacock = !0; // DOES NOT COMPILE
    }
}
