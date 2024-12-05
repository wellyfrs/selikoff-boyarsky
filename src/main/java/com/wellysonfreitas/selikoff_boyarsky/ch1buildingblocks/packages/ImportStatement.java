package com.wellysonfreitas.selikoff_boyarsky.ch1buildingblocks.packages;

/*

IMPORT STATEMENT

*/

// java.lang is automatically imported
import java.lang.System; // unnecessary

import java.util.Random;

// WILDCARDS

// import java.util.*;
// import java.util.concurrent.*;
// import java.util.concurrent.atomic.*;

// REDUNDANT IMPORTS

// import java.nio.file.*;
import java.nio.file.Files;
import java.nio.file.Paths;

// WRONG IMPORTS

// import java.nio.*;
// import java.nio.*.*;
// import java.nio.file.Paths.*;

// NAMING CONFLICTS

// Consider this import:
// import java.sql.*;

// Causes Date declaration to not compile:
// import java.util.*;

// Solution:
import java.util.Date; // Importing by class name takes precedence over wildcards.

public class ImportStatement {
    
    Date date;
    java.sql.Date sqlDate; // fully qualified class name

    public static void main(String[] args) {
        Random r = new Random();
        System.out.println(r.nextInt(10));
    }
    
    public void read(Files file) {
        Paths.get("name");
    }
}
