package com.wellysonfreitas.selikoff_boyarsky.ch1buildingblocks.types;

/*

TEXT BLOCKS

- Text blocks require a line break after the opening `"""`.
- Spaces at the end of line are ignored.
- `\` at the end of line tells Java to omit new line on that line.

Imagine a vertical line drawn on the LEFTMOST NON-WHITESPACE character in your text block.
Everything to the left of it is incidental whitespace, and everything to the right is essential whitespace.

*/

@SuppressWarnings("UnnecessaryStringEscape")
public class TextBlocks {

    public static void main(String[] args) {
        // \" says you want a `"` rather than to end the String
        // \n says you want a new line
        String eyeTest = "\"Java Study Guide\"\n by Scott & Jeanne";
        
        // Text blocks don't need to be escaped and are easier to read.
        String textBlock = """
            "Java Study Guide"
                [<--- essential whitespace]by Scott & Jeanne""";
        
        // [Everything inside the code block is just text]
        String textBlock2 = """
                text // this is not a comment
                """;
        String textBlock3 = """
                "# forks = " + numForks +
                " # knives = " + numKnives +
                """;

        // Another example (with no incidental whitespace)
        String pyramid = """
           *
          * *
         * * *
         """;
        System.out.println(pyramid);
        
        // Other examples
        
//        String block = """doe"""; // DOES NOT COMPILE (text blocks require a line break after the opening """)
        
        String block = """
                doe \
                deer""";
        System.out.println(block); // pints "doe deer" since the \ tells Java not to add a new line before deer
        
        String block2 = """
                doe \n
                deer
                """;
        System.out.println(block2);
        /* prints:
        doe_
        
        deer
        
         */
        
        String block3 = """
                "doe\"\"\"
                \"deer\"""
                """;
        System.out.println("*" + block3 + "*");
        /* prints:
        "doe"""
        "deer"""
         
         */
    }
}
