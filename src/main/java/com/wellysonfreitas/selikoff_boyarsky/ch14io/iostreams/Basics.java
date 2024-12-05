package com.wellysonfreitas.selikoff_boyarsky.ch14io.iostreams;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class Basics {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // LOW-LEVEL VS. HIGH-LEVEL STREAMS
        
        // High-level I/O streams can take low-level I/O streams as input
        try (var br = new BufferedReader(new FileReader("zoo-data.txt"))) {
            System.out.println(br.readLine());
        }
        
        // High-level I/O streams can also take other high-level I/O streams as input
        try(var ois = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream("zoo-data.txt")))) {
            System.out.println(ois.readObject());
        }
        
        // STREAM BASE CLASSES
        
        // I/O stream classes that are not compatible with each other
//        new BufferedInputStream(new FileReader("z.txt")); // DOES NOT COMPILE
//        new BufferedWriter(new FileOutputStream("z.txt")); // DOES NOT COMPILE
//        new ObjectInputStream(new FileOutputStream("z.txt")); // DOES NOT COMPILE
//        new BufferedInputStream(new InputStream()); // DOES NOT COMPILE
    }
}
