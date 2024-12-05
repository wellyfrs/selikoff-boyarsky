package com.wellysonfreitas.selikoff_boyarsky.ch8lambdasfunctionalinterfaces.lambda;

import java.util.function.BiFunction;

public class LocalVariablesInLambdaBody {

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> f1 = (a, b) -> { int c = 0; return 5; };
//        BiFunction<Integer, Integer, Integer> f2 = (a, b) -> { int a = 0; return 5; }; // DOES NOT COMPILE (re-declaring local variable)
    }
    
    public void variables(int a) {
        int b = 1;
//        Predicate<Integer> p1 = a -> { // error: re-declaring `a` (method parameter)
//            int b = 0; // error: re-declaring `b` (local variable)
//            int c = 0;
//            return b == c;
//        } // missing semicolon
    }
}
