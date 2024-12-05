package com.wellysonfreitas.selikoff_boyarsky.ch3makingdecisions.deciding;

import com.wellysonfreitas.selikoff_boyarsky.Utils;

import java.util.List;

/*

PATTERN MATCHING (>= Java 16)

Pattern matching is a technique of controlling program flow
that only executes a section of code that meets certain criteria.
It is used in conjunction with if statements for greater program control.

Two parts:
- Predicate (instanceof) applied to a target expression
- A local variable called pattern variable

Flow scoping means a pattern variable is only accessible if the compiler can discern its type.

Check: https://blogs.oracle.com/javamagazine/post/java-pattern-matching-instanceof-flow-scoping

*/

@SuppressWarnings({
        "ConstantValue",
        "PatternVariableCanBeUsed",
        "StatementWithEmptyBody",
        "WrapperTypeMayBePrimitive",
        "rawtypes"
})
class PatternMatching {
    public static void main(String[] args) {
        Number number = Utils.randomInt(0, 100);
        
        if (number instanceof Integer) {
            Integer data = (Integer)number;
            System.out.println(data.compareTo(5));
        }
        
        if (number instanceof Integer data) { // data is a pattern variable
            System.out.println(data.compareTo(5));
        }
        
        // REASSIGNING PATTERN VARIABLES IS A BAD PRACTICE
        
        if (number instanceof Integer data) {
            data = 10; // don't do this
        }
        
        if (number instanceof final Integer data) {
//            data = 10; // DOES NOT COMPILE
        }
        
        // PATTERN VARIABLES AND EXPRESSIONS
        
        if (number instanceof Integer data && data.compareTo(5) > 0) {
            System.out.println(data);
        }
        
        // SUBTYPES
        
        // The type of the pattern variable must be a subtype of the variable on the left side of the expression.
        // It also cannot be the same type.
        // This rule does not exist for traditional instanceof operator expressions.
        
        Integer value = 123;
        if (value instanceof Integer) {}
//        if (value instanceof Integer data) {} // DOES NOT COMPILE
        
        // LIMITATIONS OF SUBTYPE ENFORCEMENT
        
        // Number and List are unrelated, but this does compile fine:
        Number value2 = 123;
        if (value2 instanceof List) {}
        if (value2 instanceof List data) {}
        
        // FLOW SCOPING
        
        // DOES NOT COMPILE
//        if (number instanceof Integer data || data.compareTo(5)>0)
//            System.out.println(data);
        
        if (number instanceof Integer data)
            System.out.println(data.intValue());
//        System.out.println(data.intValue()); // DOES NOT COMPILE
        
        // IMPORTANT to know
        if (!(number instanceof Integer data))
            return;
        System.out.println(data.intValue()); // data stays in scope even after the if statement ends
        
        // Or equivalently:
        if ((number instanceof Integer data2))
            System.out.println(data2.intValue());
        else
            return;
    }
}
