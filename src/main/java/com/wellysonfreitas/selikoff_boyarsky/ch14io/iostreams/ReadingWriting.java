package com.wellysonfreitas.selikoff_boyarsky.ch14io.iostreams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

class ReadingWriting {
    void copyStream(InputStream in, OutputStream out) throws IOException {
        int b; // Java uses instead of byte to use an extra value to indicate the end of an I/O stream
        while ((b = in.read()) != -1) {
            out.write(b);
        }
    }
    
    void copyStream(Reader in, Writer out) throws IOException {
        int b;
        while ((b = in.read()) != -1) {
            out.write(b);
        }
    }
    
    // Buffer using only low-level I/O streams
    void copyStream2(InputStream in, OutputStream out) throws IOException {
        int batchSize = 1024;
        var buffer = new byte[batchSize];
        int lengthRead;
        while ((lengthRead = in.read(buffer, 0, batchSize)) > 0) {
            out.write(buffer, 0, lengthRead); // offset: 0, size: lengthRead 
            out.flush(); // write immediately to the disk (there is a cost, so use wisely)
        }
    }
    
    // Buffer using high-level I/O streams
    void copyTextFile(File src, File dest) throws IOException {
        try (var reader = new BufferedReader(new FileReader(src));
        var writer = new BufferedWriter(new FileWriter(dest))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }}}
    
    // Even shorter with PrintWriter
    void copyTextFile2(File src, File dest) throws IOException {
        try (var reader = new BufferedReader(new FileReader(src));
             var writer = new PrintWriter(new FileWriter(dest))) {
            String line = null;
            while ((line = reader.readLine()) != null)
                writer.println(line); // println() decides the line separator (`\n` or `\r\n`)
        }
    }
}

// ENHANCING WITH FILES

@SuppressWarnings("resource")
class EnhancingWithFiles {
    private void copyPathAsString(Path input, Path output) throws IOException {
        String string = Files.readString(input);
        Files.writeString(output, string);
    }
    
    private void copyPathAsBytes(Path input, Path output) throws IOException {
        byte[] bytes = Files.readAllBytes(input);
        Files.write(output, bytes);
    }
    
    private void copyPathAsLines(Path input, Path output) throws IOException {
        List<String> lines = Files.readAllLines(input);
        Files.write(output, lines);
    }
    
    // Reading lazily to avoid OutOfMemoryError
    private void readLazily(Path path) throws IOException {
        try (Stream<String> s = Files.lines(path)) {
            s.forEach(System.out::println);
        }
    }
    
    public static void main(String[] args) throws IOException {
        // Another example of reading lazily
        var path = Path.of("file.txt");
        try (var s = Files.lines(path)) {
            s.filter(f -> f.startsWith("WARN:"))
                    .map(f -> f.substring(5))
                    .forEach(System.out::println);
        }

        // Files.readAllLines() vs. Files.lines()
        Files.readAllLines(Paths.get("birds.txt")).forEach(System.out::println); // everything in memory
        Files.lines(Paths.get("birds.txt")).forEach(System.out::println); // lazily
        
        // Tricky (DOES NOT COMPILE)
//        Files.readAllLines(Paths.get("birds.txt")) // returns a List, not a Stream
//                .filter(s -> s.length() > 2)
//                .forEach(System.out::println);
    }
}

// COMBINING WITH newBufferedReader() AND newBufferedWriter()

class MixingIOStreamsAndNIO2 {
    private void copyPath(Path input, Path output) throws IOException {
        try (var reader = Files.newBufferedReader(input); // reads file specified at the Path using BufferedReader
             var writer = Files.newBufferedWriter(output)) { // writes file specified at the Path using BufferedWriter
            String line = null;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }}}
}
