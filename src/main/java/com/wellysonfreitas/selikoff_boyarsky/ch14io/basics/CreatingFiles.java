package com.wellysonfreitas.selikoff_boyarsky.ch14io.basics;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SuppressWarnings("DuplicateExpressions")
public class CreatingFiles {
    public static void main(String[] args) {
        // CREATING A FILE
        
        File zooFile1 = new File("/home/tiger/data/stripes.txt");
        File zooFile2 = new File("/home/tiger", "data/stripes.txt");
        
        File parent = new File("/home/tiger");
        File zooFile3 = new File(parent, "data/stripes.txt");
        
        File parent2 = null;
        File zooFile4 = new File(parent2, "data/stripes.txt"); // null parent is ignored

        System.out.println(zooFile1.exists());
        
        // CREATING A PATH
        
        Path zooPath1 = Path.of("/home/tiger/data/stripes.txt");
        Path zooPath2 = Path.of("/home", "tiger", "data", "stripes.txt");

        Path zooPath3 = Paths.get("/home/tiger/data/stripes.txt");
        Path zooPath4 = Paths.get("/home", "tiger", "data", "stripes.txt");

        System.out.println(Files.exists(zooPath1));
        
        // SWITCHING BETWEEN FILE AND PATH
        
        File file = new File("rabbit");
        Path nowPath = file.toPath();
        File backToFile = nowPath.toFile();
        
        // OBTAINING A PATH FROM THE FILESYSTEMS CLASS
        
        Path zooPath5 = FileSystems.getDefault()
                .getPath("/home/tiger/data/stripes.txt");
        Path zooPath6 = FileSystems.getDefault()
                .getPath("/home", "tiger", "data", "stripes.txt");
    }
}
