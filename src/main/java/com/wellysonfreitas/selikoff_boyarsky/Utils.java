package com.wellysonfreitas.selikoff_boyarsky;

import java.util.Random;

public class Utils {

    public static int randomInt(int min, int max) {
        return (new Random()).ints(min, max).findFirst().orElseThrow();
    }
}
