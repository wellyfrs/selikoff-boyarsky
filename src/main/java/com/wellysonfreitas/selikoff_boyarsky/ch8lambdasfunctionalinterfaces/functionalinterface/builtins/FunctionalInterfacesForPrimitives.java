package com.wellysonfreitas.selikoff_boyarsky.ch8lambdasfunctionalinterfaces.functionalinterface.builtins;

import java.util.function.BooleanSupplier;

public class FunctionalInterfacesForPrimitives {

    public static void main(String[] args) {
        // BOOLEAN
        
        BooleanSupplier b1 = () -> true;
        BooleanSupplier b2 = () -> Math.random()> .5;
        System.out.println(b1.getAsBoolean()); // true
        System.out.println(b2.getAsBoolean()); // false
        
        // DOUBLE, INT, AND LONG
        // Supplier, Consumer, Predicate, Function, UnaryOperator, BinaryOperator
    }
}
