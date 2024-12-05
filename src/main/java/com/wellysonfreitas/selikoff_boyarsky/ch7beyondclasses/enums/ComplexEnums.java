package com.wellysonfreitas.selikoff_boyarsky.ch7beyondclasses.enums;

enum Season2 {
    WINTER("Low"),
    SPRING("Medium"),
    SUMMER("High"),
    FALL("Medium"); // semicolon is required in complex enums
    
    private final String expectedVisitors; // final to make it immutable

    // Enum constructors are implicitly private (modifier is optional)
    private Season2(String expectedVisitors) {
        this.expectedVisitors = expectedVisitors;
    }
    
    public void printExpectedVisitors() {
        System.out.println(expectedVisitors);
    }
}

// Java constructs all of the enum values the first time we ask for any value,
// after that, Java just returns the already constructed enum values

enum OnlyOne {
    ONCE(true);
    
    private OnlyOne(boolean b) {
        System.out.print("constructing,");
    }
}

class PrintTheOne {
    public static void main(String[] args) {
        System.out.print("begin,");
        OnlyOne firstCall = OnlyOne.ONCE; // Prints constructing
        OnlyOne secondCall = OnlyOne.ONCE; // Doesn't print anything
        System.out.print("end");
    }
}

// prints: begin,constructing,end

// Calling enum method

class ComplexEnums {

    public static void main(String[] args) {
        Season2.SUMMER.printExpectedVisitors(); 
    }
}

// Defining different methods for each enum

enum Season3 {
    WINTER {
        public String getHours() { return "10am-3pm"; }
    },
    SPRING {
        public String getHours() { return "9am-5pm"; }
    },
    SUMMER {
        public String getHours() { return "9am-7pm"; }
    },
    FALL {
        public String getHours() { return "9am-5pm"; }
    };
    public abstract String getHours();
}

// Default implementation

enum Season4 {
    WINTER {
        public String getHours() { return "10am-3pm"; }
    },
    SUMMER {
        public String getHours() { return "9am-7pm"; }
    },
    SPRING, FALL;
    
    public String getHours() { return "9am-5pm"; }
}

// Enum implementing interface

interface Weather { int getAverageTemperature(); }

enum Season5 implements Weather {
    WINTER, SPRING, SUMMER, FALL;
    public int getAverageTemperature() { return 30; }
}
