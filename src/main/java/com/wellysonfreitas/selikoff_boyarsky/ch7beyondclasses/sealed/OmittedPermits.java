package com.wellysonfreitas.selikoff_boyarsky.ch7beyondclasses.sealed;

// When classes are top-level in the same file,
// the `permits` is optional and can be omitted

sealed class Snake permits Cobra {} // `permits` is optional
final class Cobra extends Snake {}

// is equivalent to

sealed class Snake2 {}
final class Cobra2 extends Snake2 {}

// This rule also applies to sealed classes with nested subclasses
@SuppressWarnings("InnerClassMayBeStatic")
sealed class Snake3 {
    final class Cobra3 extends Snake3 {}
}

// Referencing nested subclasses

//sealed class Snake4 permits Cobra4 { // DOES NOT COMPILE
//    final class Cobra4 extends Snake4 {}
//}

// Correct

@SuppressWarnings("InnerClassMayBeStatic")
sealed class Snake5 permits Snake5.Cobra5 {
    final class Cobra5 extends Snake5 {}
}
