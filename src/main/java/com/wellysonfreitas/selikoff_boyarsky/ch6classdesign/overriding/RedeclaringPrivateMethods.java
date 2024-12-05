package com.wellysonfreitas.selikoff_boyarsky.ch6classdesign.overriding;

class Beetle {
    private String getSize() {
        return "Undefined";
    }
}

class RhinocerosBeetle extends Beetle {
    private String getSize() {
        return "";
    }
//    private int getSize() {
//        return 5;
//    }
}
