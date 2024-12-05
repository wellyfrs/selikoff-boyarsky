package com.wellysonfreitas.selikoff_boyarsky.ch1buildingblocks.variables;

/*

IDENTIFYING IDENTIFIERS

An identifier is the name of a variable, method, class, interface, or package.

Rules:

- identifiers must begin with a letter, a currency symbol ($, ¥, €, etc.), or a `_` symbol
- identifiers can include numbers but not start with them
- a single underscore `_` is not allowed as an identifier
- you cannot use the same name as a Java reserved word

Also, you can't use:
- literal values such as `true`, `false`, and `null`
- contextual keywords like `module`

(`var` is allowed because it's not reserved keyword)

Conventions:
- Camel case with the first letter lowercase for method and variable names.
- Camel case with the first letter uppercase for class and interface names.
- Uppercase snake case for constants and enum values.

*/

class IdentifyingIdentifiers {
    public static void main(String[] args) {
        // Legal examples
        long okidentifier;
        float $OK2Identifier;
        boolean _alsoOK1d3ntifi3r;
        char __SStillOkbutKnotsonice$;
        int __; // but single underscore _ is illegal

        // Illegal examples (DOES NOT COMPILE)
//        int 3DPointClass; // identifiers cannot begin with a number
//        byte hollywood@vine; // @ is not a letter, digit, $ or _
//        String *$coffee; // * is not a letter, digit, $ or _
//        double public; // public is a reserved word
//        short _; // a single underscore is not allowed
        
        // [More examples]
        var a = 3_1;
//        var b = 1_329_.0; // DOES NOT COMPILE
//        var c = 3_13.0_; // DOES NOT COMPILE
//        var d = 5_291._2; // DOES NOT COMPILE
        var e = 2_234.0_0;
        var f = 9___6;
//        var g = _1_3_5_0; // DOES NOT COMPILE
    }
}

/*

DECLARING MULTIPLE VARIABLES

It's allowed to declare many variables in the same declaration as long as they are all the same type.
For readability, limit yourself to one declaration per statement and line.

*/

class DeclaringMultipleVariables {
    public static void main(String[] args) {
        String s1, s2;
        String s3 = "yes", s4 = "no";

        // 3 variables declared, 1 initialized
        int i1, i2, i3 = 0;

        // Legal examples
        int i4; int i5;
        boolean b1, b2;
        String s5 = "1", s6;

        // Illegal examples (DOES NOT COMPILE)
//        int num, String value;
//        double d1, double d2;
//        int i3; i4;
        
        // [More examples]
//        int gills = 0, double weight = 2; // DOES NOT COMPILE
        
        // [`var` is not allowed in a compound declaration]
//        var i = 1, j = 3;
    }
}
