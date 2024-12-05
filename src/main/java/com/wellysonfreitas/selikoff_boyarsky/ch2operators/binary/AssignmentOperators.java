package com.wellysonfreitas.selikoff_boyarsky.ch2operators.binary;

/*

ASSIGNMENT OPERATOR

An assignment operator is a binary operator that
modifies, or assigns, the variable on the left side of the operator
with the result of the value on the right side of the equation.
It is evaluated from right to left.

*/

@SuppressWarnings("AssignmentUsedAsCondition")
class AssignmentOperators {
    public static void main(String[] args) {
        int herd = 1;
        
        // Compound assignment
        int camel = 2, giraffe = 3;
        camel = camel * giraffe; // simple assignment operator
        camel *= giraffe; // compound assignment operator

        // Assignment is an expression that returns the value
        long wolf = 5;
        long coyote = (wolf=3);
        System.out.println(wolf); // 3
        System.out.println(coyote); // 3
        
        boolean healthy = false;
        if (healthy = true) // this expression is not logic, it's an assignment, which returns the value being assigned
            System.out.println("Good");
    }
}
