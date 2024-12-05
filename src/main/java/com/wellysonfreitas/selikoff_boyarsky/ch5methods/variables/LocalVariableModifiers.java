package com.wellysonfreitas.selikoff_boyarsky.ch5methods.variables;

@SuppressWarnings({"WriteOnlyObject", "InnerClassMayBeStatic", "MismatchedReadAndWriteOfArray"})
public class LocalVariableModifiers {

    public void zooAnimalCheckup(boolean isWeekend) {
        final int rest;

//        if (isWeekend) rest = 5; // DOES NOT COMPILE
//        System.out.print(rest); // DOES NOT COMPILE

        if (isWeekend) rest = 5; else rest = 20;
        System.out.print(rest);

        final var giraffe = new Animal();
        final int[] friends = new int[5];
        
//        rest = 10; // DOES NOT COMPILE
//        giraffe = new Animal(); // DOES NOT COMPILE
//        friends = null; // DOES NOT COMPILE

        giraffe.setName("George");
        friends[2] = 2;
    }
}

@SuppressWarnings("FieldCanBeLocal")
class Animal {
    private String name;

    public void setName(String name) {
        this.name = name;
    }
}
