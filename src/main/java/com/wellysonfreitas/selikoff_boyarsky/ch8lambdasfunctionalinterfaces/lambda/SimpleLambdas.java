package com.wellysonfreitas.selikoff_boyarsky.ch8lambdasfunctionalinterfaces.lambda;

/*

LAMBDA

Functional programming is a way of writing code more declaratively.
You specify what you want to do rather than dealing with the state of objects.
You focus more on expressions than loops.

A lambda expression is a block of code that gets passed around.

Lambda uses deferred execution, which means that code is specified now but will run later.

*/

// LAMBDA EXAMPLE
// Print out all animals in a list according to some criteria.

import java.util.ArrayList;

record Animal(String species, boolean canHop, boolean canSwim) { }

interface CheckTrait {
    boolean test(Animal a);
}

class CheckIfHopper implements CheckTrait {
    public boolean test(Animal a) {
        return a.canHop();
    }
}

@SuppressWarnings("Convert2MethodRef")
class TraditionalSearch {

    public static void main(String[] args) {
        // list of animals
        var animals = new ArrayList<Animal>();
        animals.add(new Animal("fish", false, true));
        animals.add(new Animal("kangaroo", true, false));
        animals.add(new Animal("rabbit", true, false));
        animals.add(new Animal("turtle", false, true));

        // without lambda
        // pass class that does check
//        print(animals, new CheckIfHopper()); // animals that can hop

        // with lambda
        print(animals, a -> a.canHop()); // animals that can hop

        print(animals, a -> a.canSwim()); // animals that can swim
        print(animals, a -> !a.canHop()); // animals that cannot swim

        // LAMBDA SYNTAX
        
        // `a` -> single parameter specified with the name a
        // `->` -> the arrow operator to separate the parameter and body
        // `a.canHop()` -> a body that calls a single method and returns the result of that method
        print(animals, a -> a.canHop());

        // is equivalent to
        // `(Animal a)` -> a single parameter specified with the name a and stating that the type is Animal
        // `->` -> the arrow operator to separate the parameter and body
        // `{ return a.canHop(); }` -> a body that has one or more lines of code, including a semicolon and a return statement.
        print(animals, (Animal a) -> { return a.canHop(); }); // lambda syntax is tricky because many parts are optional

        // syntax can be mixed and matched
        print(animals, a -> { return a.canHop(); });
        print(animals, (Animal a) -> a.canHop());
        
//        var invalid = (Animal a) -> a.canHop(); // DOES NOT COMPILE (not enough context to infer)
    }

    private static void print(ArrayList<Animal> animals, CheckTrait checker) {
        for (Animal animal : animals) {
            // General check
            if (checker.test(animal)) {
                System.out.print(animal + " ");
            }
            System.out.println();
        }
    }
}

/*

VALID EXAMPLES

() -> true
x -> x.startsWith("test")
(String x) -> x.startsWith("test")
(x, y) -> { return x.startsWith("test"); }
(String x, String y) -> x.startsWith("test")

INVALID EXAMPLES

x, y -> x.startsWith("fish") // Missing parenthesis on left
x -> { x.startsWith("camel"); } // Missing return on right
x -> { return x.startsWith("giraffe") } // Missing semicolon inside braces
String x -> x.endsWith("eagle") // Missing parentheses on left

*/
