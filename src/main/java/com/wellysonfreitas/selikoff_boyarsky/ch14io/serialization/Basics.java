package com.wellysonfreitas.selikoff_boyarsky.ch14io.serialization;

/*

Rules:
- The class must be marked Serializable.
- Every instance member of the class must be serializable,
  marked transient,
  or have a null value at the time of serialization.

*/

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable; // Serializable MUST BE IMPORTED
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"MissingSerialAnnotation", "FieldCanBeLocal", "FieldMayBeFinal"})
class Gorilla implements Serializable {
    private static final long serialVersionUID = 1L; // good practice
    private String name;
    private int age;
    private Boolean friendly;
    private transient String favoriteFood; // not saved
    
    public Gorilla(String name, int age, Boolean friendly, String favoriteFood) {
        this.name = name;
        this.age = age;
        this.friendly = friendly;
        this.favoriteFood = favoriteFood;
    }
    
    public Gorilla(String name, int age, Boolean friendly) {
        this(name, age, friendly, null);
    }
}

// Examples of classes not serializable
@SuppressWarnings("FieldMayBeFinal")
class Car implements Serializable {
    private Tail tail = new Tail();
}

@SuppressWarnings("FieldMayBeFinal")
class Tail implements Serializable {
    private Fur fur = new Fur();
}

class Fur {}

// Fixing

@SuppressWarnings("FieldMayBeFinal")
class Tail2 implements Serializable {
    private transient Fur fur = new Fur();
}
// or
class Fur2 implements Serializable {}

// SERIALIZING RECORDS

record Record(String name) {} // not serializable
record Record2(String name) implements Serializable {} // serializable

// STORING DATA WITH ObjectOutputStream AND ObjectInputStream
// public Object readObject() throws IOException, ClassNotFoundException
// public void writeObject(Object object) throws IOException

@SuppressWarnings("InfiniteLoopStatement")
class StoringDataWithObjectStreams {
    static <T> void saveToFile(List<T> animals, File dataFile) throws IOException {
        try (var out = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(dataFile)))) {
            for (T animal : animals) {
                out.writeObject(animal);
            }
        }
    }
    
    static <T> List<T> readFromFile(File dataFile, Class<T> clazz) throws IOException, ClassNotFoundException {
        var animals = new ArrayList<T>();
        try (var in = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(dataFile)))) {
            while (true) {
                var object = in.readObject();
                if (clazz.isInstance(object))
                    animals.add(clazz.cast(object));
            }
        } catch (EOFException e) {
            // File end reached
        }
        return animals;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var gorillas = new ArrayList<Gorilla>();
        gorillas.add(new Gorilla("Grodd", 5, false));
        gorillas.add(new Gorilla("Ishmael", 8, true));
        File dataFile = new File("gorilla.data");
        
        saveToFile(gorillas, dataFile);
        var gorillasFromDisk = readFromFile(dataFile, Gorilla.class);
        System.out.println(gorillasFromDisk);
        // prints:
        // [
        //   [name=Grodd, age=5, friendly=false],
        //   [name=Ishmael, age=8, friendly=true]
        // ]
        
        // UNDERSTANDING THE DESERIALIZATION CREATION PROCESS
        
        var chimpanzees = new ArrayList<Chimpanzee>();
        chimpanzees.add(new Chimpanzee("Ham", 2, 'A'));
        chimpanzees.add(new Chimpanzee("Enos", 4, 'B'));
        File dataFile2 = new File("chimpanzee.data");
        
        saveToFile(chimpanzees, dataFile2);
        var chimpanzeesFromDisk = readFromFile(dataFile2, Chimpanzee.class);
        System.out.println(chimpanzeesFromDisk);
        // prints:
        // [
        //   [name=null,age=0,type=B],
        //   [name=null,age=0,type=B]
        // ]
    }
}

// The constructor and any instance initialization defined in
// the serialized class are ignored during the deserialization process.
// Java only calls the constructor of the first non-serializable parent class in the class hierarchy.
@SuppressWarnings({"MissingSerialAnnotation", "FieldMayBeFinal", "AccessStaticViaInstance"})
class Chimpanzee implements Serializable {
    private static final long serialVersionUID = 2L;
    private transient String name; // initialized to null in deserialization
    private transient int age; // initialized to 0 in deserialization
    private static char type = 'C';
    { this.age = 14; } // not executed in deserialization
    
    // Constructors are not called in deserialization
    
    public Chimpanzee() {
        this.name = "Unknown";
        this.age = 12;
        this.type = 'Q';
    }
    
    public Chimpanzee(String name, int age, char type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }
}

// This subclass is serializable because the superclass has implemented Serializable.
@SuppressWarnings({"FieldMayBeFinal", "MissingSerialAnnotation"})
class BabyChimpanzee extends Chimpanzee {
    private static final long serialVersionUID = 3L;
    
    private String mother = "Mom";
    
    public BabyChimpanzee() { super(); }
    
    public BabyChimpanzee(String name,char type) {
        super(name, 0, type);
    }
}
