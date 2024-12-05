package com.wellysonfreitas.selikoff_boyarsky.ch10streams.advanced;

import java.util.ArrayList;

public class LinkingUnderlyingData {

    public static void main(String[] args) {
        var cats = new ArrayList<String>();
        cats.add("Annie");
        cats.add("Rippley");
        var stream = cats.stream();
        cats.add("KY");
        System.out.println(stream.count()); // 3
    }
}
