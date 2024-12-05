package com.wellysonfreitas.selikoff_boyarsky.ch3makingdecisions.branching;

@SuppressWarnings("ConstantValue")
class ContinueStatement {
    public static void main(String[] args) {
        CLEANING: for (char stables = 'a'; stables<='d'; stables++) {
            for (int leopard = 1; leopard < 4; leopard++) {
                if (stables=='b' || leopard==2) {
                    continue CLEANING;
                }
                System.out.println("Cleaning: " + stables + "," + leopard);
            }
        }
        
        // Unreachable code
        int minute = 1;
        WATCH: while (minute > 2) {
            if (minute++ > 2) {
                continue WATCH;
//                System.out.println(minute); // DOES NOT COMPILE
            }
        }
    }
}
