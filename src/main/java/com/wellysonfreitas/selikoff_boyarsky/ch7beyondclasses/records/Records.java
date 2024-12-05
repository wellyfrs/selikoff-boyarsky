package com.wellysonfreitas.selikoff_boyarsky.ch7beyondclasses.records;

/*

Review encapsulation and immutability first.

Record is a special type of data-oriented class in which the compiler inserts boilerplate code for you,
including encapsulation, immutability, and methods (members).

Members Automatically Added to Records:

- Constructor: a constructor with the parameters in the same order as the record declaration.
- Accessor method [getter]: one accessor for each field.
- equals(): a method to compare two elements that returns true if each field is equal in terms of equals().
- hashCode(): a consistent hashCode() method using all of the fields.
- toString(): a toString() implementation that prints each field of the record in a convenient, easy-to-read format.

*/

record Crane3(int numberEggs, String name) { }

class Records {
    public static void main(String[] args) {
        var mommy = new Crane3(4, "Cammy");
        
//        var mommy1 = new Crane3("Cammy", 4); // DOES NOT COMPILE
//        var mommy2 = new Crane3("Cammy"); // DOES NOT COMPILE
        
        System.out.println(mommy.numberEggs()); // 4
        System.out.println(mommy.name()); // Cammy
        
        var father = new Crane3(0, "Craig");
        System.out.println(father); // Crane3[numberOfEggs=0, name=Craig]
        var copy = new Crane3(0, "Craig");
        System.out.println(copy); // Crane3[numberOfEggs=0, name=Craig]
        System.out.println(father.equals(copy)); // true
        System.out.println(father.hashCode() + ", " + copy.hashCode()); // 65368656, 65368656
    }
}

// It's legal to have a record without any fields
record Crane4() {}
