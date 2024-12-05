package com.wellysonfreitas.selikoff_boyarsky.ch2operators.binary;

@SuppressWarnings({"ConstantValue", "UnnecessaryBoxing", "UnnecessaryLocalVariable", "CastCanBeRemovedNarrowingVariableType"})
class RelationalOperators {
    public static void main(String[] args) {
        // NUMERIC COMPARISON OPERATORS
        
        int gibbonNumFeet = 2, wolfNumFeet = 4, ostrichNumFeet = 2;
        System.out.println(gibbonNumFeet < wolfNumFeet); // true
        System.out.println(gibbonNumFeet <= wolfNumFeet); // true
        System.out.println(gibbonNumFeet >= ostrichNumFeet); // true
        System.out.println(gibbonNumFeet > ostrichNumFeet); // false
    
        // instanceof OPERATOR
        
        Integer zooTime = Integer.valueOf(9);
        Number num = zooTime;
        Object obj = zooTime;

        System.out.println(zooTime instanceof Integer); // true
        System.out.println(zooTime instanceof Number); // true
        System.out.println(zooTime instanceof Object); // true

        Number time = zooTime;
        
        if (time instanceof Integer)
            System.out.println((Integer)time + "O'Clock");
        else
            System.out.println(time);
        
//        System.out.println(time instanceof String); // DOES NOT COMPILE (incompatible types)

        System.out.println(null instanceof Object); // false
        
        Object noObjectHere = null;
        System.out.println(noObjectHere instanceof String); // false
        
//        System.out.println(null instanceof null); // DOES NOT COMPILE
    }
}
