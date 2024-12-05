package com.wellysonfreitas.selikoff_boyarsky.ch4coreapis.arrays;

@SuppressWarnings({
        "CStyleArrayDeclaration",
        "UnnecessaryLocalVariable",
        "ArrayEquals",
        "ImplicitArrayToString",
        "ConstantValue",
        "DataFlowIssue",
        "CStyleArrayDeclaration",
        "MismatchedReadAndWriteOfArray",
        "CommentedOutCode",
        "JavaExistingMethodCanBeUsed"
})
class Arrays {
    public static void main(String[] args) {
        // PRIMITIVE ARRAYS
        
        // The most common way to create an array
        // (all elements are set to the default value for that type):
        int[] numbers = new int[3];
        
        // Another way to create it specifying all the elements it should start out with:
        int[] moreNumbers = new int[] { 42, 55, 99 };
        
        // Variables
        int one = 1;
        var doubles = new double[] {one};
        
        // ANONYMOUS ARRAY
        // The previous form is redundant:
        // 1. Java knows the type on the left side
        // 2. Java knows the size by the initial values
        // Therefore, can use shortcut:
        int[] moreNumbers2 = { 42, 55, 99 };
        
        // Alternatives:
        int[] numAnimals;
        int [] numAnimals2;
        int []numAnimals3;
        int numAnimals4[]; // C-style
        int numAnimals5 []; // C-style
        
        // Tricky code
        int[] ids, types; // creates two variables of type int[]
        int ids2[], types2; // creates one variable of type int[], and another of type int
        
        // REFERENCE ARRAYS

        String[] bugs = { "cricket", "beetle", "ladybug" };
        String[] alias = bugs;
        System.out.println(bugs.equals(alias)); // true
        System.out.println(bugs.toString()); // [Ljava.lang.String;@160bc7c0

        String names[]; // array points to null
        String names2[] = new String[2]; // two elements pointing to null

        // CASTING
        String[] strings = { "stringValue" };
        Object[] objects = strings;
        String[] againStrings = (String[]) objects;
        // againStrings[0] = new StringBuilder(); // DOES NOT COMPILE
        objects[0] = new StringBuilder(); // ArrayStoreException, String[] referred to from an Object[]
        
        // USING AN ARRAY
        
        String[] mammals = {"monkey", "chimp", "donkey"};
        System.out.println(mammals.length); // 3
        System.out.println(mammals[0]); // monkey
        System.out.println(mammals[1]); // chimp
        System.out.println(mammals[2]); // donkey

        // length() vs. length
        // DOES NOT COMPILE (no parentheses after length since it's not a method)
        // System.out.println(mammals.length());
        
        var birds = new String[6];
        System.out.println(birds.length); // 6
        
        var numbers2 = new int[10];
        for (int i = 0; i < numbers.length; i++)
            numbers2[i] = i + 5;
        
        // ArrayIndexOutOfBoundsException:
        // numbers2[10] = 3;
        // for (int i = 0; i <= numbers2.length; i++) numbers2[i] = i + 5;
    }
}
