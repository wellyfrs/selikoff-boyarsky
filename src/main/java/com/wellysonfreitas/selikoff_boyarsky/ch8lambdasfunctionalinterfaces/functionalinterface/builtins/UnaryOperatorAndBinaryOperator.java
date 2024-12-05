package com.wellysonfreitas.selikoff_boyarsky.ch8lambdasfunctionalinterfaces.functionalinterface.builtins;

/*

UnaryOperator transforms its value into one of the same type.
BinaryOperator merges two values into one of the same type.

Both require all type parameters to be the same type.

Defined as follows:

@FunctionalInterface
public interface UnaryOperator<T> extends Function<T, T> {
    // omitted static method
}

@FunctionalInterface
public interface BinaryOperator<T> extends BiFunction<T, T, T> {
    // omitted static methods
}

Method signatures look like this:

T apply(T t); // UnaryOperator
T apply(T t1, T t2); // BinaryOperator

*/

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

@SuppressWarnings("Convert2MethodRef")
class ImplementingUnaryOperatorAndBinaryOperator {

    public static void main(String[] args) {
        UnaryOperator<String> u1 = String::toUpperCase;
        UnaryOperator<String> u2 = x -> x.toUpperCase();

        System.out.println(u1.apply("chirp")); // CHIRP
        System.out.println(u2.apply("chirp")); // CHIRP
        
        BinaryOperator<String> b1 = String::concat;
        BinaryOperator<String> b2 = (string, toAdd) -> string.concat(toAdd);

        System.out.println(b1.apply("baby", "chick")); // baby chick
        System.out.println(b2.apply("baby", "chick")); // baby chick
    }
}
