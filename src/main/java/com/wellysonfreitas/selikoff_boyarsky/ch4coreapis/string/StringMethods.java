package com.wellysonfreitas.selikoff_boyarsky.ch4coreapis.string;

@SuppressWarnings({
        "ConstantValue",
        "StringOperationCanBeSimplified",
        "MismatchedStringCase",
        "TextBlockMigration",
        "RedundantStringFormatCall",
        "MalformedFormatString",
        "EqualsWithItself",
})
class StringMethods {
    public static void main(String[] args) {
        var name = "animals";

        // length
        System.out.println(name.length()); // 7

        // chatAt
        System.out.println(name.charAt(0)); // a
        System.out.println(name.charAt(6)); // s
        // System.out.println(name.charAt(7)); // exception

        // indexOf
        System.out.println(name.indexOf('a')); // 0
        System.out.println(name.indexOf("al")); // 4
        System.out.println(name.indexOf('a', 4)); // 4
        System.out.println(name.indexOf("al", 5)); // -1

        // substring
        // Returns the string starting from the requested index.
        // If an index is requested, it stops right before that index.
        // Otherwise, it goes to the end of the string.

        // Pretend the indexes are right before the character they would point to
        // string: a n i m a l s
        // index: 0 1 2 3 4 5 6 7
        System.out.println(name.substring(3)); // mals
        System.out.println(name.substring(name.indexOf('m'))); // mals
        System.out.println(name.substring(3, 4)); // m
        System.out.println(name.substring(3, 7)); // mals

        System.out.println(name.substring(3, 3)); // empty string
        // System.out.println(name.substring(3, 2)); // exception
        // System.out.println(name.substring(3, 8)); // exception

        // ADJUSTING CASE
        System.out.println(name.toUpperCase()); // ANIMALS
        System.out.println("Abc123".toLowerCase()); // abc123

        // CHECKING FOR EQUALITY
        System.out.println("abc".equals("ABC")); // false
        System.out.println("ABC".equals("ABC")); // true
        System.out.println("abc".equalsIgnoreCase("ABC")); // true

        // SEARCHING FOR SUBSTRINGS
        System.out.println("abc".startsWith("a")); // true
        System.out.println("abc".startsWith("A")); // false

        System.out.println("abc".endsWith("c")); // true
        System.out.println("abc".endsWith("a")); // false

        // str.contains(otherString) <=> str.indexOf(otherString) != -1
        System.out.println("abc".contains("b")); // true
        System.out.println("abc".contains("B")); // false

        // REPLACING VALUES
        System.out.println("abcabc".replace('a', 'A')); // AbcAbc
        System.out.println("abcabc".replace("a", "A")); // AbcAbc

        // REMOVING WHITESPACE
        // strip() removes "many kinds" of whitespace (e.g. space, \t, \n) from both beginning and end of string
        // trim() removes "some kinds" of whitespace from both beginning and end of string
        
        System.out.println("abc".strip()); // abc
        System.out.println("\t  a b c\n".strip()); // a b c

        String text = " abc\t";
        System.out.println(text.trim().length()); // 3
        System.out.println(text.strip().length()); // 3
        System.out.println(text.stripLeading().length()); // 4
        System.out.println(text.stripTrailing().length()); // 4

        // WORKING WITH INDENTATION
        // indent() adds the same number of blank spaces to the beginning of each time if you pass a positive number.
        // If negative, it tries to remove that number of whitespace characters from the beginning of the line.
        // If you pass zero, the indentation will not change.
        // indent() also normalizes whitespace characters:
        // 1. a line break is added to the end of the string if not already there;
        // 2. any line breaks are converted to the \n format.

        // stripIndent() removes all incidental whitespace.
        // It also converts any line breaks to the \n format, but does not add a trailing line break if it is missing.

        var block = """
                a
                b
                c""";

        var concat = " a\n"
                + " b\n"
                + " c";

        System.out.println(block);
        System.out.println(concat);
        System.out.println(block.length()); // 5
        System.out.println(concat.length()); // 8
        System.out.println(block.indent(1).length()); // 9
        System.out.println(concat.indent(-1).length()); // 6
        System.out.println(concat.indent(-4).length()); // 6
        System.out.println(concat.stripIndent().length()); // 5
        System.out.println(block.stripIndent().length()); // 5

        // TRANSLATING ESCAPES
        // This method can be used for escape sequences such as \t, \n, \s, \", \'
        var str = "1\\t2";
        System.out.println(str); // 1\t2
        System.out.println(str.translateEscapes()); // 1	2

        // CHECKING FOR EMPTY OR BLANK STRINGS
        System.out.println(" ".isEmpty()); // false
        System.out.println("".isEmpty()); // true
        System.out.println(" ".isBlank()); // true
        System.out.println("".isBlank()); // true

        // FORMATTING VALUES
        var name2 = "Kate";
        var orderId = 5;
        // All print: Hello Kate, order 5 is ready
        System.out.println("Hello " + name2 + ", order " + orderId + " is ready");
        System.out.println(String.format("Hello %s, order %d is ready", name2, orderId));
        System.out.println("Hello %s, order %d is ready".formatted(name2, orderId));

        var name3 = "James";
        var score = 90.25;
        var total = 100;
        System.out.println("%s:%n Score: %f out of %d".formatted(name3, score, total));
        /* prints:
        James:
         Score: 90.250000 out of 100
         */

//        var str2 = "Food: %d tons".formatted(2.0); // IllegalFormatConversionException

        var pi = 3.141592265359;
        System.out.format("[%f]", pi); // [3.141592]
        System.out.format("[%12.8f]", pi); // [  3.14159227]
        System.out.format("[%012f]", pi); // [00003.141592]
        System.out.format("[%12.2f]", pi); // [        3.14]
        System.out.format("[%.3f]", pi); // [3.142]
        System.out.println();

        // METHOD CHAINING
        var start = "AniMaL  ";
        var trimmed = start.trim(); // "AniMaL";
        var lowercase = trimmed.toLowerCase(); // "animal"
        var result = lowercase.replace('a', 'A'); // "AnimAl"
        System.out.println(result);

        String result2 = "AniMaL  ".trim().toLowerCase().replace('a', 'A');
        System.out.println(result2);

        String a = "abc";
        String b = a.toUpperCase();
        b = b.replace("B", "2").replace('C', '3');
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }
}
