package com.wellysonfreitas.selikoff_boyarsky.ch9collectionsgenerics.generics;

interface Shippable<T> {
    void ship(T t);
}

// Three ways to implement

// Specify the generic type in the class
class ShippableRobotCrate implements Shippable<Robot> {
    public void ship(Robot t) {}
}

// Create a generic class
class ShippableAbstractCrate<U> implements Shippable<U> {
    public void ship(U t) {}
}

// Not using generic at all
@SuppressWarnings("rawtypes")
class ShippableCrate implements Shippable {
    public void ship(Object t) {}
}
