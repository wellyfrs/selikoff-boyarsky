package com.wellysonfreitas.selikoff_boyarsky.ch7beyondclasses.sealed;

// Sealed interface
sealed interface Swims permits Duck, Swan, Floats {}

// Classes permitted to implement sealed interface
final class Duck implements Swims {}
final class Swan implements Swims {}

// Interface permitted to extend sealed interface
non-sealed interface Floats extends Swims {}
