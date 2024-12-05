package com.wellysonfreitas.selikoff_boyarsky.ch7beyondclasses.sealed.zoo;

// A sealed class needs to be declared (and compiled)
// in the same package as its direct subclasses [except when using modules].

// Even though the Emperor class is declared,
// it does not extend the Penguin class.

// public sealed class Penguin permits Emperor {} // DOES NOT COMPILE
