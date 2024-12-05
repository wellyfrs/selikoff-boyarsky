package com.wellysonfreitas.selikoff_boyarsky.ch10streams.optional;

import java.util.Optional;

@SuppressWarnings({
        "OptionalIsPresent",
        "OptionalGetWithoutIsPresent",
        "ConstantValue",
        "rawtypes",
        "OptionalOfNullableMisuse",
        "Convert2MethodRef"
})
public class OptionalClass {

    public static Optional<Double> average(int... scores) {
        if (scores.length == 0) return Optional.empty();
        int sum = 0;
        for (int score : scores) sum += score;
        return Optional.of((double) sum / scores.length);
    }
    
    public static void main(String[] args) {
        System.out.println(average(90, 100)); // Optional[95.0]
        System.out.println(average()); // Optional.empty
        
        // check value
        Optional<Double> opt = average(90, 100);
        if (opt.isPresent())
            System.out.println(opt.get()); // 95.0
        
        Optional<Double> opt2 = average();
        System.out.println(opt2.get()); // NoSuchElementException
        
        Integer value = null;
        
        // Ternary operator
        Optional o = (value == null) ? Optional.empty() : Optional.of(value);
        
        // Equivalent factory method
        Optional o2 = Optional.ofNullable(value);
        
        // Consumer
        Optional<Double> opt3 = average(90, 100);
        opt3.ifPresent(System.out::println);
        
        // DEALING WITH AN EMPTY OPTIONAL
        
        System.out.println(opt2.orElse(Double.NaN)); // NaN
        System.out.println(opt2.orElseGet(() -> Math.random())); // 0.49775932295380165
        
        System.out.println(opt2.orElseThrow()); // NoSuchElementException
        
        System.out.println(opt2.orElseThrow(() -> new IllegalStateException()));

//        System.out.println(opt2.orElseGet(() -> new IllegalStateException())); // DOES NOT COMPILE

        System.out.println(opt3.orElse(Double.NaN)); // 95.0
        System.out.println(opt3.orElseGet(() -> Math.random())); // 95.0
        System.out.println(opt3.orElseThrow()); // 95.0
    }
}
