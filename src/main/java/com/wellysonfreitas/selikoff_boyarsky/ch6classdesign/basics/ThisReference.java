package com.wellysonfreitas.selikoff_boyarsky.ch6classdesign.basics;

@SuppressWarnings("FieldMayBeFinal")
class Flamingo {
    private String color = null;
    
    public void setColor(String color) {
        // color = color;
        this.color = color;
    }

    public static void main(String... unused) {
        var f = new Flamingo();
        f.setColor("PINK");
        System.out.print(f.color);
    }
}

class Duck {
    private String color;
    private int height;
    private int length;
    
    public void setData(int length, int theHeight) {
        length = this.length; // Backwards -- not good!
        height = theHeight; // Fine, because a different name
        this.color = "white"; // Fine, but `this` reference is not necessary
    }

    public static void main(String[] args) {
        Duck b = new Duck();
        b.setData(1, 2);
        System.out.println(b.length + " " + b.height + " " + b.color);
    }
}
