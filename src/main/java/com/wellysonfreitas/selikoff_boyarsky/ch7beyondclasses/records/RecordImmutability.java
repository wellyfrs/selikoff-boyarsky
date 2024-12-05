package com.wellysonfreitas.selikoff_boyarsky.ch7beyondclasses.records;

public class RecordImmutability {

    public static void main(String[] args) {
        // To "modify" a record, you have to make a new object
        // and copy all of the data you want to preserve
        var cousin = new Crane3(3, "Jenny");
        var friend = new Crane3(cousin.numberEggs(), "Janeice");
    }

    // `final` is implicit, therefore, optional
    final record Crane5(int numberEggs, String name) {}
    
//    record BlueCrane() extends Crane5 {} // DOES NOT COMPILE (cannot extend records because they are final)
    
    // Like enums, records can implement regular or sealed interfaces
    interface Bird {}
    record Crane(int numberEggs, String name) implements Bird {}
}
