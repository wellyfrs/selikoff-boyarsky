package com.wellysonfreitas.selikoff_boyarsky.ch14io.basics;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

public class ManipulatingFiles {
    public static void main(String[] args) throws IOException {
        // MAKING DIRECTORIES
        // public static Path createDirectory(Path dir, FileAttribute<?>... attrs) throws IOException
        // public static Path createDirectories(Path dir, FileAttribute<?>... attrs) throws IOException
        
        Files.createDirectory(Path.of("/bison/field"));
        Files.createDirectories(Path.of("/bison/field/pasture/green"));
        
        // COPYING FILES
        // public static Path copy(Path source, Path target, CopyOption... options) throws IOException
        
        Files.copy(Paths.get("/panda/bamboo.txt"),
                Paths.get("/panda-save/bamboo.txt"));
        
        var sourceDir = Paths.get("/turtle");
        var targetDir = Paths.get("/turtleCopy");
        
        // Shallow copy of dirs
        Files.copy(sourceDir, targetDir);
        
        // Deep copy of dirs (with recursion)
        copyPath(sourceDir, targetDir);
        
        // COPYING AND REPLACING FILES
        
        Files.copy(Paths.get("book.txt"), Paths.get("movie.txt"),
                StandardCopyOption.REPLACE_EXISTING); // without REPLACE_EXISTING,
        // will throw an exception if the file already exists
        
        // COPYING FILES WITH I/O STREAMS
        // public static long copy(InputStream in, Path target, CopyOption... options) throws IOException
        // public static long copy(Path source, OutputStream out) throws IOException
        
        // Copying a stream (a file stream in this case) to a file
        try (var is = new FileInputStream("source-data.txt")) {
            // Write I/O stream data to a file
            Files.copy(is, Paths.get("/mammals/wolf.txt"));
        }
        
        // Printing the contents of a file directly to the System.out stream
        Files.copy(Paths.get("/fish/clown.xsl"), System.out);
        
        // COPYING FILES INTO A DIRECTORY
        
        var file = Paths.get("food.txt");
        
        var directory = Paths.get("/enclosure");
        Files.copy(file, directory); // throws an exception (trying to create a file named /enclosure, which exists)
        
        // Correct:
        var directory2 = Paths.get("/enclosure/food.txt");
        Files.copy(file, directory2);
        
        // MOVING OR RENAMING PATHS WITH move()
        // public static Path move(Path source, Path target, CopyOption... options) throws IOException
        
        // Renames dir zoo to zoo-new
        Files.move(Path.of("C:\\zoo"), Path.of("C:\\zoo-new"));
        
        // Moves address.txt from user dir to zoo-new, renaming to address2.txt
        Files.move(Path.of("C:\\user\\address.txt"), Path.of("C:\\zoo-new\\address2.txt"));
        
        // SIMILARITIES BETWEEN move() AND copy()
        // Requires REPLACE_EXISTING to overwrite the target if it exists; otherwise throws an exception.
        // Won't put a file in a dir if the source is a file and the target is a dir,
        // it will create a new file with the name of the dir.
        
        // PERFORMING AN ATOMIC MOVE
        
        Files.move(Path.of("mouse.txt"), Path.of("gerbil.txt"),
                StandardCopyOption.ATOMIC_MOVE);
        
        // DELETING A FILE WITH delete() AND deleteIfExists()
        // public static void delete(Path path) throws IOException
        // public static boolean deleteIfExists(Path path) throws IOException
        // Directories must be empty to be deleted.
        // If the path is symbolic link, just the link is deleted, not the path that it points to.
        
        Files.delete(Paths.get("/vulture/feathers.txt")); // throws NoSuchFileException if file or dir do not exist
        Files.deleteIfExists(Paths.get("/pigeon"));
    }
    
    private static void copyPath(Path source, Path target) {
        try {
            Files.copy(source, target);
            if (Files.isDirectory(source))
                try (Stream<Path> s = Files.list(source)) { // JVM won't follow symbolic links when using list()
                    s.forEach(p -> copyPath(p,
                            target.resolve(p.getFileName())));
                }
        } catch (IOException e) {
            // Handle exception
        }
    }
}
