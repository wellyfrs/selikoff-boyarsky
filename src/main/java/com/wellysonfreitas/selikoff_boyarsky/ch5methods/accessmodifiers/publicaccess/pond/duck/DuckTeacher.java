package com.wellysonfreitas.selikoff_boyarsky.ch5methods.accessmodifiers.publicaccess.pond.duck;

public class DuckTeacher {
    public String name = "helpful";
    
    public void swim() {
        System.out.print(name); // public access is ok
    }
}
