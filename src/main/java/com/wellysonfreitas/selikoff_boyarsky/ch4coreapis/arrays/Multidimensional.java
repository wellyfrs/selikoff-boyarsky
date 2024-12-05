package com.wellysonfreitas.selikoff_boyarsky.ch4coreapis.arrays;

/*

MULTIDIMENSIONAL ARRAYS

Arrays of arrays that, properly managed, offer a multidimensional effect.

*/

@SuppressWarnings({"CStyleArrayDeclaration", "MismatchedReadAndWriteOfArray", "ForLoopReplaceableByForEach"})
class Multidimensional {
    public static void main(String[] args) {
        int[][] vars1; // 2D array
        int vars2 [][]; // 2D array
        int[] vars3[]; // 2D array
        int[] vars4 [], space [][]; // a 2D AND a 3D array
        
        String[][] rectangle = new String[3][2];
        rectangle[0][1] = "set";
        
        // ASYMMETRIC MULTIDIMENSIONAL ARRAYS
        
        int[][] differentSizes = {{1,4}, {3}, {9,8,7}};
        
        int [][] args2 = new int[4][];
        args2[0] = new int[5];
        args2[1] = new int[3];
        
        var twoD = new int[3][2];
        for (int i = 0; i < twoD.length; i++) {
            for(int j = 0; j < twoD[i].length; j++) {
                System.out.print(twoD[i][j] + " "); // print element
            }
            System.out.println(); // time for a new row
        }
        
        for (int[] inner: twoD) {
            for (int num: inner) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
