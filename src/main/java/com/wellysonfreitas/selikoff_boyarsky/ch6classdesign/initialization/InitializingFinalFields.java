package com.wellysonfreitas.selikoff_boyarsky.ch6classdesign.initialization;

/*

FINAL FIELD INITIALIZATION

By the time the constructor completes, all final instance variables must be assigned a value exactly one.

Instance variables marked final need to be assigned a value in:
- the declaration line
- in an instance initializer
- in a constructor

They should be assigned a value only once.
Failure to assign a value is considered a compiler error in the constructor.

*/

@SuppressWarnings("FieldCanBeLocal")
class MouseHouse {
    private final int volume;
    private final String name = "The Mouse House"; // Declaration assignment

    {
        volume = 10; // Instance initializer assignment
    }
}

@SuppressWarnings("FieldCanBeLocal")
class MouseHouse2 {
    private final int volume;
    private final String name;
    
    public MouseHouse2() {
        this.name = "Empty House"; // Constructor assignment
    }

    {
        volume = 10; // Instance initializer assignment
    }
}

@SuppressWarnings("FieldCanBeLocal")
class MouseHouse3 {
    private final int volume;
    private final String type;

    {
        this.volume = 10;
    }
    
    public MouseHouse3(String type) {
        this.type = type;
    }
    
     public MouseHouse3() {
         // this.volume = 2; // DOES NOT COMPILE
         this(null);
     }
}
