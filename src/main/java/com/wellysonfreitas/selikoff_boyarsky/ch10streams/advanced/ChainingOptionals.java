package com.wellysonfreitas.selikoff_boyarsky.ch10streams.advanced;

import java.util.Optional;

@SuppressWarnings({"ConstantValue", "OptionalUsedAsFieldOrParameterType"})
public class ChainingOptionals {
    private static void threeDigit(Optional<Integer> optional) {
        // without functional programming
        if (optional.isPresent()) { // outer if
            var num = optional.get();
            var string = "" + num;
            if (string.length() == 3) { // inner if
                System.out.println(string);
            }
        }
        
        // with functional programming
        optional.map(n -> "" + n) // part 1
                .filter(s -> s.length() == 3) // part 2
                .ifPresent(System.out::println); // part 3
    }
    
    private static Optional<Integer> calculator(String text) {
        return Optional.of(text.length());
    }

    public static void main(String[] args) {
        var strOpt = Optional.of("");
        Optional<Integer> result = strOpt.map(String::length);

//        Optional<Integer> resul2 = strOpt.map(ChainingOptionals::calculator); // DOES NOT COMPILE
        
        Optional<Integer> result3 = strOpt.flatMap(ChainingOptionals::calculator);
    }
}
