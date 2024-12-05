package com.wellysonfreitas.selikoff_boyarsky.ch11exceptionslocalization.exceptions;

/*

Java includes the try-with-resources statement to automatically close all resources opened in a try clause.
This feature is also known as automatic resource management, because Java automatically takes care of the closing.

Only classes that implement the AutoCloseable interface can be used in a try-with-resources statement.

interface AutoCloseable {
    public void close() throws Exception;
}

*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

@SuppressWarnings({"CallToPrintStackTrace", "EmptyTryBlock", "CatchMayIgnoreException", "resource"})
class TryWithResource {

    // Without try-with-resources
    public void readFile(String file) {
        FileInputStream is = null;
        try {
            is = new FileInputStream("myfile.txt");
            // Read file data
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
    
    // With try-with-resources
    public void readFile2(String file) {
        try (FileInputStream is = new FileInputStream("myfile.txt")) {
            // Read file data
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Shorter method declaring exception
    public void readFile3(String file) throws IOException { // <----------------------- throws exception!
        try (FileInputStream is = new FileInputStream("myfile.txt")) {
            // Read file data
        }
    }

    public static void main(String[] args) throws Exception {
        try (var in = new FileInputStream("data.txt");
             var out = new FileOutputStream("myfile.txt");) {
            // Protected code
        } catch (IOException e) {
            // Exception handler
        } finally {
            System.out.println("The End.");
            // finally block
        }

        // CONSTRUCTING TRY-WITH-RESOURCES STATEMENTS
        
//        try (String reptile = "lizard") {} // DOES NOT COMPILE
        
        // DECLARING RESOURCES
        
//        try (MyFileClass is = new MyFileClass(1), // DOES NOT COMPILE
//             os = new MyFileClass(2)) {
//        }
        
//        try (MyFileClass ab = new MyFileClass(1), // DOES NOT COMPILE
//             MyFileClass cd = new MyFileClass(2)) {
//        }
        
        // DECLARING USING VAR
        
        try (var f = new BufferedInputStream(new FileInputStream("it.txt"))) {
            // Process file
        } catch (Exception e) {}

        // SCOPE OF TRY-WITH-RESOURCES
        
        try (Scanner s = new Scanner(System.in)) {
            s.nextLine();
        } catch(Exception e) {
//            s.nextInt(); // DOES NOT COMPILE
        } finally {
//            s.nextInt(); // DOES NOT COMPILE
        }
        
        // FOLLOWING ORDER OF OPERATIONS
        
        try (MyFileClass bookReader = new MyFileClass(1);
             MyFileClass movieReader = new MyFileClass(2)) {
            System.out.println("Try Block"); // 1
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("Catch Block"); // 2
        } finally {
            System.out.println("Finally Block"); // 3
        }
        
        // APPLYING EFFECTIVELY FINAL
        // For variables in the try-with-resources not declared in the try clause, make sure it is effectively final.
        
        final var bookReader = new MyFileClass(4); // this is final
        MyFileClass movieReader = new MyFileClass(5); // this is effectively final
        try (bookReader;
             var tvReader = new MyFileClass(6);
             movieReader) {
            System.out.println("Try Block");
        } finally {
            System.out.println("Finally Block");
        }
        // prints:
        // Try Block
        // Closing: 5
        // Closing: 6
        // Closing: 4
        // Finally Block
        
        // Another example
        var writer = Files.newBufferedWriter(Path.of("")); // this is not effectively final
//        try (writer) { // DOES NOT COMPILE
//            writer.append("Welcome to the zoo!");
//        }
        writer = null;
        
        // Accessing a resource after it has been closed is not allowed
        var writer2 = Files.newBufferedWriter(Path.of("myfile.txt"));
        writer2.append("This write is permitted but a really bad idea!");
        try (writer2) {
            writer2.append("Welcome to the zoo!");
        }
        writer2.append("This write will fail!"); // IOException
    }
}

class MyFileClass implements AutoCloseable {
    private final int num;
    public MyFileClass(int num) {
        this.num = num;
    }
    @Override public void close() {
        System.out.println("Closing " + num);
    }
}
