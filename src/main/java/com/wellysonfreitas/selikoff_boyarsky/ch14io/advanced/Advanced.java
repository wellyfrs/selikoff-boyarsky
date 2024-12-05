package com.wellysonfreitas.selikoff_boyarsky.ch14io.advanced;

/*

Manipulating (InputStream and Reader):

public boolean markSupported()
public void mark(int readLimit)
public void reset() throws IOException
public long skip(long n) throws IOException

*/

import java.io.IOException;
import java.io.InputStream;

public class Advanced {
    // MARKING DATA
    public void readData(InputStream is) throws IOException {
        System.out.println((char) is.read()); // L
        if (is.markSupported()) {
            is.mark(100); // Marks up to 100 bytes
            System.out.println((char) is.read()); // I
            System.out.println((char) is.read()); // O
            is.reset(); // Resets stream to position before I
        }
        System.out.println((char) is.read()); // I
        System.out.println((char) is.read()); // O
        System.out.println((char) is.read()); // N
    }
    
    public static void main(String[] args) {
        // SKIPPING DATA
    }
}
