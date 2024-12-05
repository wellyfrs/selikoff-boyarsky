package com.wellysonfreitas.selikoff_boyarsky.ch7beyondclasses.sealed;

// Every class that directly extends a sealed class
// must specify exactly one of the following three modifiers:
// (1) final, (2) sealed, or (3) non-sealed.

// A final SUBCLASS
// The final modifier prevents the subclass Gazelle from being extended further.

sealed class Antelope permits Gazelle {}

final class Gazelle extends Antelope {}

//class George extends Gazelle {} // DOES NOT COMPILE

// A sealed SUBCLASS

sealed class Mammal permits Equine {}

sealed class Equine extends Mammal permits Zebra {}

final class Zebra extends Equine {}

// A non-sealed SUBCLASS
// The non-sealed modifier is used to open a sealed parent class
// to potentially unknown subclasses.

sealed class Wolf2 permits Timber2 {} // MyWolf is not permitted here

non-sealed class Timber2 extends Wolf2 {}

class MyWolf extends Timber2 {}

// Extending more
class MyFurryWolf extends MyWolf {}
