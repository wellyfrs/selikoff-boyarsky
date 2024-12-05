package com.wellysonfreitas.selikoff_boyarsky.ch9collectionsgenerics.generics;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"rawtypes", "ForLoopReplaceableByForEach", "unchecked"})
class Basics {
    static void printNames(List list) {
        for (int i = 0; i < list.size(); i++) {
            String name = (String) list.get(i); // ClassCastException
            System.out.println(name);
        }
    }
    
    public static void main(String[] args) {
        List names = new ArrayList<>();
        names.add(new StringBuilder("Webby"));
        printNames(names); // ClassCastException
        
        List<String> names2 = new ArrayList<String>();
//        names.add(new StringBuilder("Webby")); // DOES NOT COMPILE
    }
}

class Crate<T> {
    private T contents;
    public T lookInCrate() {
        return contents;
    }
    public void packCrate(T contents) {
        this.contents = contents;
    }
}

@SuppressWarnings({"FieldCanBeLocal", "FieldMayBeFinal"})
class SizeLimitedCrate<T, U> {
    private T contents;
    private U sizeLimit;
    public SizeLimitedCrate(T contents, U sizeLimit) {
        this.contents = contents;
        this.sizeLimit = sizeLimit;
    }
}

class Elephant {}
class Zebra {}
class Robot {}

class CreatingGenerics {

    public static void main(String[] args) {
        Elephant elephant = new Elephant();
        Crate<Elephant> crateForElephant = new Crate<>();
        crateForElephant.packCrate(elephant);
        Elephant inNewHome = crateForElephant.lookInCrate();
        
        Crate<Zebra> crateForZebra = new Crate<>();
        
        Robot joeBot = new Robot();
        Crate<Robot> robotCrate = new Crate<>();
        robotCrate.packCrate(joeBot);
        
        // skip to Houston
        Robot atDestination = robotCrate.lookInCrate();
        
        Integer numPounds = 15_000;
        SizeLimitedCrate<Elephant, Integer> c1 = new SizeLimitedCrate<>(elephant, numPounds);
    }
}
