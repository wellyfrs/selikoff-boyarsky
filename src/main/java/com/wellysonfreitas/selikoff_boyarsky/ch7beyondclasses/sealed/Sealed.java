package com.wellysonfreitas.selikoff_boyarsky.ch7beyondclasses.sealed;

// sealed indicates that a class or interface may only
// be extended/implemented by named classes or interfaces

// permits is used with the sealed keyword
// to list the classes and interfaces allowed

sealed class Bear permits Kodiak, Panda {}

final class Kodiak extends Bear {}

// non-sealed is applied to a class or interface that extends a sealed class,
// indicating that it can be extended by unspecified classes

non-sealed class Panda extends Bear {}

// Another example

//class sealed Frog permits GLassFrog {} // DOES NOT COMPILE
//final class GlassFrog extends Frog {}

abstract sealed class Wolf permits Timber {}
final class Timber extends Wolf {}
//final class MyWolf extends Wolf {} // DOES NOT COMPILE

// Why have sealed classes?
// Compiler knows all the options in switch statements, no need for default branch.
// Still in preview in Java 17, released in Java 21

sealed class Fish permits Trout, Bass {}
final class Trout extends Fish { String getTroutName() { return "Trout"; } }
final class Bass extends Fish { String getBassName() { return "Bass"; } }

class SealedInSwitch {

    public static void main(String[] args) {
        Fish fish = new Fish();
//        System.out.println(switch(fish) {
//            case Trout t -> t.getTroutName();
//            case Bass b -> b.getBassName();
//        });
    }
}
