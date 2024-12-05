package com.wellysonfreitas.selikoff_boyarsky.ch4coreapis.math;

class MathAPI {
    public static void main(String[] args) {
        // FINDING THE MINIMUM AND MAXIMUM
        // public static double min(double a, double b)
        // public static float min(float a, float b)
        // public static int min(int a, int b)
        // public static long min(long a, long b)
        
        int first = Math.max(3, 7); // 7
        int second = Math.min(7, 9); // -9
        
        // ROUNDING NUMBERS
        // public static long round(double num)
        // public static int round(float num)
        
        long low = Math.round(123.45); // 123
        long high = Math.round(123.50); // 124
        int fromFloat = Math.round(123.45f); // 123
        long fromDouble = Math.round(123.45); // 123
        
        // DETERMINING THE CEILING AND FLOOR
        // public static double ceil(double num)
        // public static double floor(double num)
        
        double c = Math.ceil(3.14); // 4.0
        double f = Math.floor(3.14); // 3.0
        
        // CALCULATING EXPONENTS
        // public static double pow(double number, double exponent)
        
        double squared = Math.pow(5, 2); // 5^2 = 25.0
        
        // GENERATING RANDOM NUMBERS
        // public static double random()
        
        double num = Math.random();
    }
}
