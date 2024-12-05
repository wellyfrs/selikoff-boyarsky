package com.wellysonfreitas.selikoff_boyarsky.ch3makingdecisions.looping;

@SuppressWarnings({"ConstantValue"})
class DoWhileLoop {
    public static void main(String[] args) {
        int lizard = 0;
        do {
            lizard++;
        } while (false);
        System.out.println(lizard); // 1
        
        // [Other example]
        int y = -2;
        do System.out.print(++y + " ");
        while (y <= 5);
    }
}
