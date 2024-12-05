package com.wellysonfreitas.selikoff_boyarsky.ch11exceptionslocalization.exceptions;

/*

Common exceptions:

- ArithmeticException
- ArrayIndexOutOfBoundsException
- ClassCastException
- NumberFormatException
- NullPointerException
- IllegalArgumentException

*/

@SuppressWarnings({
        "NumericOverflow",
        "divzero",
        "MismatchedReadAndWriteOfArray",
        "UnnecessaryLocalVariable",
        "ResultOfMethodCallIgnored"
})
class CommonExceptions {

    public static void main(String[] args) {
        // ArithmeticException
        int answer = 11 / 0;
        
        // ArrayIndexOutOfBoundsException
        int[] countsOfMoose = new int[3];
        System.out.println(countsOfMoose[-1]);
        
        // ClassCastException
        String type = "moose";
//        Integer number = (Integer) type; // DOES NOT COMPILE
        
        Object obj = type;
        Integer number = (Integer) obj; // ClassCastException
        
        // NumberFormatException
        Integer.parseInt("abc");
    }
}

// NullPointerException

@SuppressWarnings({"UnnecessaryUnboxing", "DataFlowIssue"})
class Frog {
    public void hop(String name, Integer jump) {
        System.out.print(name.toLowerCase() + " " + jump.intValue()); // NullPointerException
    }

    public static void main(String[] args) {
        new Frog().hop(null, 1);
        new Frog().hop("Kermit", null);
    }
}

// IllegalArgumentException

@SuppressWarnings("FieldCanBeLocal")
class Crane {
    private int numberEggs;
    public void setNumberEggs(int numberEggs) {
        if (numberEggs < 0)
            throw new IllegalArgumentException("# eggs must be not negative");
        this.numberEggs = numberEggs;
    }
}
