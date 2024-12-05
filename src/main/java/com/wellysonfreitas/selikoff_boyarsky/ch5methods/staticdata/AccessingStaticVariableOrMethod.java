package com.wellysonfreitas.selikoff_boyarsky.ch5methods.staticdata;

@SuppressWarnings({"InstantiationOfUtilityClass", "AccessStaticViaInstance", "WriteOnlyObject"})
public class AccessingStaticVariableOrMethod {

    public static void main(String[] args) {
        System.out.println(Snake.hiss);
        
        // Tricky code:
        Snake s = new Snake();
        System.out.println(s.hiss); // s is a Snake
        s = null;
        System.out.println(s.hiss); // s is still a Snake (does not throw NPE and prints 2)
        
        Snake.hiss = 4;
        Snake snake1 = new Snake();
        Snake snake2 = new Snake();
        snake1.hiss = 6;
        snake2.hiss = 5;
        System.out.println(Snake.hiss); // 5
    }
}

class Snake {
    public static long hiss = 2; // static
}
