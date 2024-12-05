package com.wellysonfreitas.selikoff_boyarsky.ch14io.basics;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

// INTERACTING WITH NIO.2 PATHS

@SuppressWarnings("ResultOfMethodCallIgnored")
class PathAPIs {
    public static void main(String[] args) throws IOException {
        Path p = Path.of("whale"); // Path instances are immutable
        p.resolve("krill"); // p is not changed; result of method is ignored
        System.out.println(p); // whale
        
        // Example of chaining
        Path.of("/zoo/../home").getParent().normalize().toAbsolutePath();
        
        // VIEWING THE PATH
        // toString(), getNameCount(), getName()
        
        Path path = Paths.get("/land/hippo/harry.happy");
        // toString() is the only method to return String
        System.out.println("The Path Name is: " + path); // The Path Name is: /land/hippo/harry.happy
        // getNameCount() and getName()
        for (int i = 0; i < path.getNameCount(); i++)
            System.out.println("  Element " + i + " is: " + path.getName(i));
            // Element 0 is: land
            // Element 1 is: hippo
            // Element 2 is: harry.happy
        
        // The root element is not included in the list of names
        var p2 = Path.of("/");
        System.out.println(p.getNameCount()); // 0
//        System.out.println(p.getName(0)); // IllegalArgumentException
        
        // CREATING PART OF THE PATH
        // subpath()
        
        var p3 = Paths.get("/mammal/omnivore/raccoon.image");
        System.out.println("Path is: " + p3); // Path is: /mammal/omnivore/raccoon.image
        for (int i = 0; i < p3.getNameCount(); i++) {
            System.out.println("  Element " + i + " is: " + p3.getName(i));
            // Element 0 is: mammal
            // Element 1 is: omnivore
            // Element 2 is: raccoon.image
        }
        System.out.println();
        System.out.println("subpath(0,3): " + p3.subpath(0, 3)); // subpath(0,3): mammal/omnivore/raccoon.image
        System.out.println("subpath(1,2): " + p3.subpath(1, 2)); // subpath(1,2): omnivore
        System.out.println("subpath(1,3): " + p3.subpath(1, 3)); // subpath(1,3): omnivore/raccoon.image
        
        // subpath() is also zero-indexed and does not include the root.
        // subpath() throws an exception if invalid indices are provided:
//        var q = p3.subpath(0, 4); // IllegalArgumentException
//        var x = p3.subpath(1, 1); // IllegalArgumentException
        
        // ACCESSING PATH ELEMENTS
        
        // getFileName() returns the Path element of the current file or directory.
        
        // getParent() returns the full path of the containing directory.
        // It returns null if operated on the root path or at the top of a relative path.
        
        // getRoot() return the root element of the file within the file system, or null if the path is relative path
        
        printPathInformation(Path.of("zoo"));
        // Filename is: zoo
        //   Root is: null (returned null because path is relative)
        
        printPathInformation(Path.of("/zoo/armadillo/shells.txt"));
        // Filename is: shells.txt
        //   Root is: /
        //   Current parent is: /zoo/armadillo
        //   Current parent is: /zoo
        //   Current parent is: /
        
        printPathInformation(Path.of("./armadillo/../shells.txt"));
        // Filename is: shells.txt
        //   Root is: null (returned null because path is relative)
        //   Current parent is: ./armadillo/.. (treats `.` and `..` symbols as part of the path)
        //   Current parent is: ./armadillo
        //   Current parent is: .
        
        // RESOLVING PATHS
        // resolve() (when you see resolve(), think [Path] concatenation)
        
        Path path1 = Path.of("/cats/../panther"); // relative path
        Path path2 = Path.of("food");
        System.out.println(path1.resolve(path2)); // /cats/../panther/food
        
        // If an absolute path is provided as input to the method, that is the value returned.
        // Simply put, you cannot combine two absolute paths using resolve().
        Path path3 = Path.of("/turkey/food"); // absolute path
        System.out.println(path3.resolve("/tiger/cage")); // tiger/cage
        
        // RELATIVIZING A PATH
        // relativize()
        // What steps are needed to take to reach the other path?
        
        var path4 = Path.of("fish.txt");
        var path5 = Path.of("friendly/birds.txt");
        System.out.println(path4.relativize(path5)); // ../friendly/birds.txt
        System.out.println(path5.relativize(path4)); // ../../fish.txt
        
        // If both paths are relative, relativize() computes the paths as if they are in the same current workdir.
        // If both are absolute, it computes the relative path from one absolute location to another,
        // regardless of the current workdir.
        Path path6 = Paths.get("E:\\habitat");
        Path path7 = Paths.get("E:\\sanctuary\\raven\\poe.txt");
        System.out.println(path6.relativize(path7)); // ..\sanctuary\raven\poe.txt
        System.out.println(path7.relativize(path6)); // ..\..\..\habitat
        
        // relativize() requires both paths to be absolute or relative
        Path path8 = Paths.get("/primate/chimpanzee");
        Path path9 = Paths.get("bananas.txt");
//        path8.relativize(path9); // IllegalArgumentException
        
        // On Windows-based systems, it also requires that if absolute paths are used,
        // both paths must have the same root directory or drive letter
        Path path10 = Paths.get("C:\\primate\\chimpanzee");
        Path path11 = Paths.get("D:\\storage\\bananas.txt");
//        path10.relativize(path11); // IllegalArgumentException
        
        // NORMALIZING A PATH
        // normalize() - eliminate unnecessary redundancies in a path
        
        var p4 = Path.of("./armadillo/../shells.txt");
        System.out.println(p4.normalize()); // shells.txt

        var p5 = Path.of("/cats/../panther/food");
        System.out.println(p5.normalize()); // /panther/food

        var p6 = Path.of("../../fish.txt");
        System.out.println(p6.normalize()); // ../../fish.txt
        
        // Comparing equivalent paths
        var p8 = Paths.get("/pony/../weather.txt");
        var p9 = Paths.get("/weather.txt");
        System.out.println(p8.equals(p9)); // false
        System.out.println(p8.normalize().equals(p9.normalize())); // true
        
        // RETRIEVING THE REAL FILE SYSTEM PATH
        // toRealPath() - verify that the path exists withing the file
        // similar to normalize() and toAbsolutePath(), but will throw an exception if the path doesn't exist
        // and will also follow symbolic links, with an optional LinkOption varargs param to ignore them

        // Let's say there is a symbolic link from /zebra to /horse
        System.out.println(Paths.get("/zebra/food.txt").toRealPath()); // horse/food.txt
        System.out.println(Paths.get(".././food.txt").toRealPath()); // horse/food.txt

        // Gaining access to the current workdir as a Path object
        System.out.println(Paths.get(".").toRealPath());
    }

    private static void printPathInformation(Path path) {
        System.out.println("Filename is: " + path.getFileName());
        System.out.println("  Root is: " + path.getRoot());
        Path currentParent = path;
        while((currentParent = currentParent.getParent()) != null)
            System.out.println("  Current parent is: " + currentParent);
        System.out.println();
    }
}
