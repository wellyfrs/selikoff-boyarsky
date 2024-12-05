package com.wellysonfreitas.selikoff_boyarsky.ch5methods.variables;

/*

EFFECTIVELY FINAL

An effectively final local variable is one that is not modified after it is assigned.
Be careful: variables can be assigned after declaration.

*/

@SuppressWarnings({"ConstantValue", "StringOperationCanBeSimplified", "ResultOfMethodCallIgnored"})
class EffectivelyFinal {
    public String zooFriends() {
        String name = "Harry the Hippo"; // effectively final
        var size = 10;
        boolean wet; // effectively final
        if (size > 100) size++;
        name.substring(0);
        wet = true;
        return name;
    }
}
