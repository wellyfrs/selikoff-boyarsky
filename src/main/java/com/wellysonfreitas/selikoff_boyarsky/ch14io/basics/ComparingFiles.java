package com.wellysonfreitas.selikoff_boyarsky.ch14io.basics;

/*

Considering the following file structure:
 
 animals/
 ├── cobra/
 ├── monkey/
 │   ├── tail.gif
 │   └── ears.png
 ├── wolf/
 │   └── ears.png
 └── snake -> cobra (link snake pointing to cobra)
 
*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ComparingFiles {
    public static void main(String[] args) throws IOException {
        System.out.println(Files.isSameFile(
                Path.of("/animals/cobra"),
                Path.of("/animals/snake"))); // true

        System.out.println(Files.isSameFile(
                Path.of("/animals/monkey/ears.png"),
                Path.of("/animals/wolf/ears.png"))); // false
        
        // To compare the contents of the file, use mismatch()
        // It returns -1 if the files are the same;
        // otherwise, the index of the first position in the file that differs.
        // The mismatch() method is symmetric and returns the same result regardless of the order of the parameters.
        System.out.println(Files.mismatch(
                Path.of("/animals/monkey.txt"),
                Path.of("/animals/wolf.txt")));
    }
}
