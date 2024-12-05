package com.wellysonfreitas.selikoff_boyarsky.ch9collectionsgenerics.generics;

import java.util.ArrayList;
import java.util.List;

class A {}
class B extends A {}
class C extends B {}

class CombiningGenericDeclarations {

    public static void main(String[] args) {
        List<?> list1 = new ArrayList<A>();
        List<? extends A> list2 = new ArrayList<A>();
        List<? super A> list3 = new ArrayList<A>();
        
//        List<? extends B> list4 = new ArrayList<A>(); // DOES NOT COMPILE
        List<? super B> list5 = new ArrayList<A>();
//        List<?> list6 = new ArrayList<? extends A>(); // DOES NOT COMPILE
    }
}

class PassingGenericArguments {
    <T> T first(List<? extends T> list) {
        return list.get(0);
    }
    
//    <T> <? extends T> second(List<? extends T> list) { // DOES NOT COMPILE (return type isn't a type)
//        return list.get(0);
//    }
    
    // Tricky
//    <B extends A> B third(List<B> list) {
//        return new B(); // DOES NOT COMPILE (B is a type parameter here, not the B class anymore)
//    }
    
    void fourth(List<? super B> list) {}
    
//    <X> void fifth(List<X super B> list) {} // DOES NOT COMPILE (mixing method-specific parameter with a wildcard)
}
