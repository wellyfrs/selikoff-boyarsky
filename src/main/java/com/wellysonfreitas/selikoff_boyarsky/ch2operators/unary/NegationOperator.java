package com.wellysonfreitas.selikoff_boyarsky.ch2operators.unary;

class NegationOperator {
    public static void main(String[] args) {
        double zooTemperature = 1.21;
        System.out.println(zooTemperature); // 1.21
        zooTemperature = -zooTemperature;
        System.out.println(zooTemperature); // -1.21
//        zooTemperature = --zooTemperature; // This is a decrement operation
        zooTemperature = -(-zooTemperature);
        System.out.println(zooTemperature); // -1.21
        
        // Unary operator `-` cannot be applied to boolean value/variable
        // boolean penguin = -true; // DOES NOT COMPILE
    }
}
