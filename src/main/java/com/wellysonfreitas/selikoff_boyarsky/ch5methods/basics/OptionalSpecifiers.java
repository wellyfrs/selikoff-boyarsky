package com.wellysonfreitas.selikoff_boyarsky.ch5methods.basics;

/*

OPTIONAL SPECIFIERS

- static: indicates the method is a member of the shared class object
- abstract: used in an abstract class or interface when the method body is excluded
- final: specifies that the method may not be overridden in a subclass
- default: used in an interface to provide a default implementation of a method for classes that implement the interface
- synchronized: used with multithreaded code
 
- native: used when interacting with code written in another language, such as C++
- strictfp: used for making floating-point calculations portable

*/

@SuppressWarnings("FinalStaticMethod")
class Exercise {

    public void bike1() {}
    public final void bike2() {}
    public static final void bike3() {}
    public final static void bike4() {}
    // public modifier void bike5() {} // DOES NOT COMPILE
    // public void final bike6() {} // DOES NOT COMPILE
    final public void bike7() {}
}
