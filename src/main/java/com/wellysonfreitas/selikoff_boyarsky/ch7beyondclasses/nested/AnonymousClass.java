package com.wellysonfreitas.selikoff_boyarsky.ch7beyondclasses.nested;

/*

Anonymous class is a specialized form of a local class without a name.

*/

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

// Example with asbtract class
@SuppressWarnings("InnerClassMayBeStatic")
class ZooGiftShop {
    abstract class SaleTodayOnly {
        abstract int dollarsOff();
    }
    
    public int admission(int basePrice) {
        SaleTodayOnly sale = new SaleTodayOnly() {
            int dollarsOff() { return 3; }
        }; // Don't forget the semicolon!
        return basePrice - sale.dollarsOff();
    }
}

// Example with interface
class ZooGiftShop2 {
    interface SaleTodayOnly {
        int dollarsOff();
    }
    
    public int admission(int basePrice) {
        SaleTodayOnly sale = new SaleTodayOnly() {
            public int dollarsOff() { return 3; }
        };
        return basePrice - sale.dollarsOff();
    }
}

// Anonymous class outside a method body
class Gorilla {
    interface Climb {}
    Climb climbing = new Climb() {};
}

// ANONYMOUS CLASSES AND LAMBDA EXPRESSIONS

class Button {
    public void setOnAction(EventHandler<ActionEvent> eventHandler) {}
}

class AnonymousClass {
    public static void main(String[] args) {
        var redButton = new Button();
        
        // Without lambda expression
        redButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                System.out.println("Red button pressed!");
            }
        });

        // With lambda expression
        redButton.setOnAction(e -> System.out.println("Red button pressed!"));
    }
}
