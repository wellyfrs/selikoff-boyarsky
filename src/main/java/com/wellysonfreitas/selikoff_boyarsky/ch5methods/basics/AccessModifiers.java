package com.wellysonfreitas.selikoff_boyarsky.ch5methods.basics;

/*
 * 1. private: method can be called only from within the same class.
 * 2. Package Access: method can be called only from a class in the same package. No keyword.
 * 3. protected: method can be called from a class in the same package or a subclass.
 * 4. public: method can be called from anywhere.
 */

class ParkTrip {
    public void skip1() {}
    
    // default is used in switch statements and interfaces,
    // but it is never used as an access modifier
    // default void skip2() {} // DOES NOT COMPILE
    
    // access modifier after return type
    // void public skip3() {} // DOES NOT COMPILE
    
    void skip4() {}
}
