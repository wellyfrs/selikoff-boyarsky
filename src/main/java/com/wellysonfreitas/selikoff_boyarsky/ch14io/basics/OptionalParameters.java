package com.wellysonfreitas.selikoff_boyarsky.ch14io.basics;

// PROVIDING NIO.2 OPTIONAL PARAMETERS

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

class OptionalParameters {
    public static void main(String[] args) throws IOException {
        // Example
        Path path = Paths.get("schedule.xml");
        boolean exists = Files.exists(path, LinkOption.NOFOLLOW_LINKS); // option to not follow symbolic links

        // Another example
        var source = Path.of("source");
        var target = Path.of("target");
        Files.move(source, target, // throws IOException
                LinkOption.NOFOLLOW_LINKS,
                StandardCopyOption.ATOMIC_MOVE);
    }
}
