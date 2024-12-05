package com.wellysonfreitas.selikoff_boyarsky.ch4coreapis.string;

/*

STRING BUILDER

Unlike the String class, StringBuilder is not immutable.

*/

@SuppressWarnings({
        "StringConcatenationInLoop",
        "DataFlowIssue",
        "unused",
        "MismatchedQueryAndUpdateOfStringBuilder",
        "StringBufferReplaceableByString",
})
class StringBuilderClass {
    public static void main(String[] args) {
        // Not efficient, many String objects immediately available to GC
        String alpha = "";
        for (char current = 'a'; current <= 'z'; current++)
            alpha += current;
        System.out.println(alpha);

        // With StringBuilder
        StringBuilder alpha2 = new StringBuilder();
        for (char current = 'a'; current <= 'z'; current++)
            alpha2.append(current);
        System.out.println(alpha2);

        // Chaining
        StringBuilder sb = new StringBuilder("start");
        sb.append("+middle"); // sb = "start+middle"
        StringBuilder same = sb.append("+end"); // "start+middle+end"

        // Tricky code
        StringBuilder a = new StringBuilder("abc");
        StringBuilder b = a.append("de");
        b = b.append("f").append("g");
        System.out.println("a=" + a); // a=abcdefg
        System.out.println("b=" + b); // b=abcdefg (same object)

        // Three ways to construct
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder("animal");
        StringBuilder sb3 = new StringBuilder(10); // reserved capacity

        // IMPORTANT METHODS

        // COMMON METHODS
        // indexOf(), length(), charAt(), substring()
        // Work exactly the same as in the String class
        var sb4 = new StringBuilder("animals");
        String sub = sb4.substring(sb.indexOf("a"), sb4.indexOf("al")); // returns String
        int len = sb4.length();
        char ch = sb4.charAt(6);
        System.out.println(sub + " " + len + " " + ch); // anim 7 s

        // APPEND
        // public StringBuilder append(String str) (+10 method signatures)
        var sb5 = new StringBuilder().append(1).append('c');
        sb5.append("-").append(true);
        System.out.println(sb5); // 1c-true

        // INSERT
        // public StringBuilder insert(int offset, String str)
        // Indexes change as we add and remove chars, be careful
        var sb6 = new StringBuilder("animals");
//        sb6.insert(100, "-"); // sb6 = animals- // StringIndexOutOfBoundsException
        sb6.insert(7, "-"); // sb6 = animals-
        sb6.insert(0, "-"); // sb6 = -animals-
        sb6.insert(4, "-"); // sb6 = -ani-mals-
        System.out.println(sb6);

        // DELETE
        // public StringBuilder delete(int startIndex, in endIndex)
        // public StringBuilder deleteCharAt(int index)
        var sb7 = new StringBuilder("abcdef");
        sb7.delete(1, 3); // sb7 = adef
        sb7.deleteCharAt(5); // exception StringIndexOutOfBoundsException

        // The delete() method is more flexible than some others when it comes to array indexes.
        // If you specify a second parameter that is past the end of the StringBuilder,
        // Java will just assume you meant the end. That means this code is legal:
        var sb8 = new StringBuilder("abcdef");
        sb8.delete(1, 100); // sb8 = a
        
        // REPLACE
        // public StringBuilder replace(int startIndex, int endIndex, String newString)
        var builder = new StringBuilder("pigeon dirty");
        builder.replace(3, 6, "sty");
        System.out.println(builder); // pigsty dirty
        
        var builder2 = new StringBuilder("pigeon dirty");
        builder.replace(3, 100, "");
        System.out.println(builder); // pig
        
        // REVERSE
        // public StringBuilder reverse()
        var sb9 = new StringBuilder("ABC");
        sb9.reverse();
        System.out.println(sb9); // CBA
    }
}
