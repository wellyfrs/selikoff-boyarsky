package com.wellysonfreitas.selikoff_boyarsky.ch14io.basics;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

@SuppressWarnings("DataFlowIssue")
class SharedFunctionality {
    // Example using legacy I/O APIs
    public static void io() {
        var file = new File("C:\\data\\zoo.txt");
        if (!file.exists()) {
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("Is Directory: " + file.isDirectory());
            System.out.println("Parent Path: " + file.getParent());
            if (file.isFile()) {
                System.out.println("Size: " + file.length());
                System.out.println("Last Modified: " + file.lastModified());
            } else {
                for (File subfile: file.listFiles()) {
                    System.out.println(" " + subfile.getName());
                }
            }
        }
    }
    // Output for a valid file:
    // Absolute Path: C:\data\zoo.txt
    // Is Directory: false
    // Parent Path: C:\data
    // Size: 12382
    // Last Modified: 1650610000000

    // Output for a valid directory:
    // Absolute Path: C:\data
    // Is Directory: true
    // Parent Path: C:\
    //  employees.txt
    //  zoo.txt
    //  zoo-backup.txt

    // Example using NIO.2
    public static void nio() throws IOException {
        var path = Path.of("C:\\data\\zoo.txt");
        if (Files.exists(path)) {
            System.out.println("Absolute Path: " + path.toAbsolutePath());
            System.out.println("Is Directory: " + Files.isDirectory(path));
            System.out.println("Parent Path: " + path.getParent());
            if (Files.isRegularFile(path)) {
                System.out.println("Size: " + Files.size(path));
                System.out.println("Last Modified: "
                        + Files.getLastModifiedTime(path));
            } else {
                try (Stream<Path> stream = Files.list(path)) {
                    stream.forEach(p ->
                            System.out.println(" " + p.getName(0)));
                }
            }
        }
    }
}
