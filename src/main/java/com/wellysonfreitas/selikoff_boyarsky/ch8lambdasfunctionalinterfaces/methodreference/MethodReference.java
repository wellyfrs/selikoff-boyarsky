package com.wellysonfreitas.selikoff_boyarsky.ch8lambdasfunctionalinterfaces.methodreference;

/*

METHOD REFERENCE

Method references are a way to make the code easier to read,
such as simply mentioning the name of the method.

*/

// Functional interface
interface LearnToSpeak {
    void speak(String sound);
}

class DuckHelper {
    public static void teacher(String name, LearnToSpeak trainer) {
        // Exercise patience (omitted)
        trainer.speak(name);
    }
}

@SuppressWarnings("Convert2MethodRef")
class Duckling {
    public static void makeSound(String sound) {
        // Without method reference
//        LearnToSpeak learner = s -> System.out.println(s);
        
        // With method reference
        LearnToSpeak learner = System.out::println;
        
        DuckHelper.teacher(sound, learner);
    }
}


// CALLING STATIC METHODS

interface Converter {
    long round(double num);
}

@SuppressWarnings("Convert2MethodRef")
class CallingStaticMethods {

    public static void main(String[] args) {
        Converter methodRef = Math::round;
        Converter lambda = x -> Math.round(x);

        System.out.println(methodRef.round(100.1)); // 100
    }
}

// CALLING METHODS ON A PARTICULAR OBJECT

interface StringStart {
    boolean beginningCheck(String prefix);
}

interface StringChecker {
    boolean check();
}

@SuppressWarnings({"Convert2MethodRef", "ConstantValue"})
class CallingInstanceMethodsOnObject {

    public static void main(String[] args) {
        var str = "Zoo";
        StringStart methodRef = str::startsWith;
        StringStart lambda = s -> str.startsWith(s);

        System.out.println(methodRef.beginningCheck("A")); // false

        StringChecker methodRef2 = str::isEmpty;
        StringChecker lambda2 = () -> str.isEmpty();

        System.out.println(methodRef2.check()); // true

        // All method references can be turned into lambdas,
        // but the opposite is not always true
        lambda2 = () -> str.startsWith("Zoo");
//        StringChecker methodReference = str::startsWith; // DOES NOT COMPILE
//        StringChecker methodReference = str::startsWith("Zoo"); // DOES NOT COMPILE
    }
}

// CALLING METHODS ON PARAMETER

interface StringParameterChecker {
    boolean check(String text);
}

interface StringTwoParameterCheck {
    boolean check(String text, String prefix);
}

@SuppressWarnings("Convert2MethodRef")
class CallingInstanceMethodsOnParameter {

    public static void main(String[] args) {
        StringParameterChecker methodRef = String::isEmpty;
        StringParameterChecker lambda = s -> s.isEmpty();

        System.out.println(methodRef.check("Zoo")); // false

        StringTwoParameterCheck methodRef2 = String::startsWith;
        StringTwoParameterCheck lambda2 = (s, p) -> s.startsWith(p);

        System.out.println(methodRef2.check("Zoo", "A")); // false
    }
}

// CALLING CONSTRUCTORS

interface EmptyStringCreator {
    String create();
}

interface StringCopier {
    String copy(String value);
}

@SuppressWarnings({"Convert2MethodRef", "StringOperationCanBeSimplified"})
class CallingConstructors {

    public static void main(String[] args) {
        EmptyStringCreator methodRef = String::new;
        EmptyStringCreator lambda = () -> new String();

        var myString = methodRef.create();
        System.out.println(myString.equals("Snake")); // false

        StringCopier methodRef2 = String::new;
        StringCopier lambda2 = x -> new String(x);

        var myString2 = methodRef2.copy("Zebra");
        System.out.println(myString2.equals("Zebra")); // true
    }
}
