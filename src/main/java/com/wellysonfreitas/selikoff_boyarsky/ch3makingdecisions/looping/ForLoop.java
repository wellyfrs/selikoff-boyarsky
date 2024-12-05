package com.wellysonfreitas.selikoff_boyarsky.ch3makingdecisions.looping;

@SuppressWarnings({"DataFlowIssue", "IdempotentLoopBody"})
class ForLoop {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(i + " ");
        }
        
        for (var counter = 4; counter >= 0; counter--) {
            System.out.println(counter + " ");
        }
        
        // Variables declared in the initialization block of a for loop
        // have limited scope and are accessible only within the for loop
        for (int i=0; i < 10; i++)
            System.out.println("Value is: "+i);
//        System.out.println(i); // DOES NOT COMPILE
        
        int i;
        for (i = 0; i < 10; i++)
            System.out.println("Value is: "+i);
        System.out.println(i);
        
        // TRICKY LOOPS
        
        // 1. Creating an infinite loop
//        for(;;)
//            System.out.println("Hello World");
        
        // 2. Adding multiple terms to the for statement
        int x = 0;
        for (long y = 0, z = 4; x < 5 && y < 10; x++, y++) {
            System.out.print(y + " "); }
        System.out.print(x + " ");
        
        // 3. Redeclaring a variable in the initialization block
        x = 0;
        // DOES NOT COMPILE
//        for (int x = 4; x < 5; x++)
//            System.out.print(x + " ");
        
        // 4. Using incompatible data types in the initialization block
        x = 0;
        // DOES NOT COMPILE
//        for (long y = 0, int z = 4; x < 5; x++) {
//            System.out.print(y + " ");
//        }
        
        // 5. Using loop variables outside the loop
        for (long a = 0, b = 4; b < 5 && a < 10; a++, b++)
            System.out.print(a + " ");
//        System.out.print(b); // DOES NOT COMPILE
        
        // Modifying loop variables is a bad practice:
        for (int u = 0; u < 10; u++)
            u = 0;
        
        for (int v = 1; v < 10; v++)
            v++;
        
        // [Other examples]
        // You can declare multiple elements in a for loop,
        // but the data must be listed only once
//        for (int a = 1, int b = 2; a <= 1;) // DOES NOT COMPILE
    }
}
