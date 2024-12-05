package com.wellysonfreitas.selikoff_boyarsky.ch5methods.staticdata;

@SuppressWarnings({"FieldCanBeLocal", "FieldMayBeFinal", "CStyleArrayDeclaration"})
class MantaRay {
    private String name = "Sammy";
    
    public static void first() {}
    public static void second() {}
    public void third() { System.out.print(name); }
    
    public static void main(String args[]) {
        first();
        second();
        // third(); // DOES NOT COMPILE
    }
    
    // This also does not work:
    // public static void third() { System.out.print(name); } // DOES NOT COMPILE
    
    // Two ways to fix:
    // 1. Add static to the name variable as well.
    // 2. Call third() as an instance method.
}

class Giraffe {
    public void eat(Giraffe g) {}
    public void drink() {};
    public static void allGiraffeGoHome(Giraffe g) {}
    public static void allGiraffeComeOut() {}
    // Method allGiraffeGoHome() can call allGiraffeComeOut(), but not drink()
}

class Gorilla {
    public static int count;
    
    public static void addGorilla() { count++; }
    public void babyGorilla() { count++; }
    public void announceBabies() {
        addGorilla();
        babyGorilla();
    }
    public static void announceBabiesToEveryone() {
        addGorilla();
        // babyGorilla(); // DOES NOT COMPILE
    }
    public int total;
    // public static double average = total / count; // DOES NOT COMPILE
}

// A common use for static variables is counting the number of instances:
@SuppressWarnings("InstantiationOfUtilityClass")
class Counter {
    private static int count;
    
    public Counter() { count++; }
    
    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();
        System.out.println(count); // 3
    }
}
