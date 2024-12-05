package com.wellysonfreitas.selikoff_boyarsky.ch5methods.accessmodifiers.publicaccess.pond.goose;

import com.wellysonfreitas.selikoff_boyarsky.ch5methods.accessmodifiers.publicaccess.pond.duck.DuckTeacher;

public class LostDuckling {
    public void swim() {
        var teacher = new DuckTeacher();
        teacher.swim(); // allowed
        System.out.print("Thanks " + teacher.name); // allowed
    }
}
