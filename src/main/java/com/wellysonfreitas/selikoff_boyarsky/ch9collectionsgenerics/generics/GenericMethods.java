package com.wellysonfreitas.selikoff_boyarsky.ch9collectionsgenerics.generics;

class Handler {
    public static <T> void prepare(T t) {
        System.out.println("Preparing " + t);
    }
    public static <T> Crate<T> ship(T t) {
        System.out.println("Shipping " + t);
        return new Crate<T>();
    }
}

// Unless a method is obtaining the generic formal type parameter from the class/interface,
// it is specified immediately before the return type of the method.

class More {
    public static <T> void sink(T t) {}
    public static <T> T identity(T t) { return t; }
//    public static T noGood(T t) { return t; } // DOES NOT COMPILE
}

/*

Optional syntax for invoking a generic method

Box.<String>ship("package")
Box.<String[]>ship(args);

*/

// When you have a method declaring a generic parameter type,
// it is independent of the class generics.

@SuppressWarnings("TypeParameterHidesVisibleType")
class TrickyCrate<T> {
    public <T> T tricky(T t) {
        return t;
    }
    
    public static String crateName() {
        TrickyCrate<Robot> crate = new TrickyCrate<>();
//        return crate.<String>tricky("bot"); // alternative syntax
        return crate.tricky("bot");
    }
}
