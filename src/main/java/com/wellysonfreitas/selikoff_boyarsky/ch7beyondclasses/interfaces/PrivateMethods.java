package com.wellysonfreitas.selikoff_boyarsky.ch7beyondclasses.interfaces;

/*

PRIVATE INTERFACE METHOD DEFINITION RULES

1. A private interface method must be marked with the private modifier and include a method body.
2. A private static interface method may be called by any method within the interface definition.
3. A private interface method may only be called by default and other private non-static methods within the interface definition.

*/

// REUSING CODE WITH private INTERFACE METHODS

interface Schedule {
    default void wakeUp() { checkTime(7); }

    private void haveBreakfast() { checkTime(9); }

    static void workOut() { checkTime(18); }

    private static void checkTime(int hour) {
        if (hour > 17) {
            System.out.println("You're late!");
        } else {
            System.out.println("You have "+(17-hour)+" hours left "
                    + "to make the appointment");
        }
    }
}

// CALLING ABSTRACT METHODS

interface ZooRenovation {
    public String projectName();
    abstract String status();
    default void printStatus() {
        System.out.print("The " + projectName() + " project " + status());
    }
}
