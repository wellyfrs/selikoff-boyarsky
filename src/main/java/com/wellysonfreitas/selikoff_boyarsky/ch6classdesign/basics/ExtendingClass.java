package com.wellysonfreitas.selikoff_boyarsky.ch6classdesign.basics;

class Animal {
    private int age;
    protected String name;
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int newAge) {
        age = newAge;
    }
}

@SuppressWarnings("SameParameterValue")
class Lion extends Animal {
    protected void setProperties(int age, String n) {
        setAge(age);
        name = n;
    }

    public void roar() {
        System.out.print(name + ", age " + getAge() + ", says: Roar!");
        // System.out.print("Lions age: " + age); // DOES NOT COMPILE
    }

    public static void main(String[] args) {
        var lion = new Lion();
        lion.setProperties(3, "kion");
        lion.roar();
    }
}
