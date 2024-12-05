package com.wellysonfreitas.selikoff_boyarsky.ch7beyondclasses.nested;

/*

A local class is a nested class defined within a method (or constructors and initializers).
Like local variables, a local class declaration does not exist until
the method is invoked, and it goes out of scope when the method returns.

Properties:

- No access modifier.
- Can be final or abstract.
- Have access to all fields and methods of the enclosing class (when defined in an instance method).
- Can access final and effectively final local variables.

*/

@SuppressWarnings("FieldMayBeFinal")
class PrintNumbers {
    private int length = 5;
    public void calculate() {
        final int width = 20;
        class Calculator {
            public void multiply() {
                System.out.println(length * width);
            }
        }
        var calculator = new Calculator();
        calculator.multiply();
    }

    public static void main(String[] args) {
        var printer = new PrintNumbers();
        printer.calculate(); // 100
    }
    
    // Local variable references are allowed if they are final or effectively final.
    
    public void processData() {
        final int length = 5;
        int width = 10;
        int height = 2;
        
        class VolumeCalculator {
//            public int multiply() {
//                return length * width * height; // DOES NOT COMPILE
//            }
        }
        width = 2; // width not effectively final anymore
    }
}

// [Other examples]

class LocalRecord {
    public static void main(String[] args) {
        record Earthworm(int length) {
            Earthworm {
                length = 4;
            }
        }
        var worm = new Earthworm(6);
        System.out.println(worm.length()); // 4
    }
}
