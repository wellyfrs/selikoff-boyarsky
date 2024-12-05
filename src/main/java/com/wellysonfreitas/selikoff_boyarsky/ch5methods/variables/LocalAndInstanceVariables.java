package com.wellysonfreitas.selikoff_boyarsky.ch5methods.variables;

@SuppressWarnings("ConstantValue")
class Lion {
    int hunger = 4; // Instance variable
    
    public int feedZooAnimals() {
        int snack = 10; // Local variable
        if (snack > 4) {
            long dinnerTime = snack++; // Local variable
            hunger--;
        }
        return snack;
    }
}
