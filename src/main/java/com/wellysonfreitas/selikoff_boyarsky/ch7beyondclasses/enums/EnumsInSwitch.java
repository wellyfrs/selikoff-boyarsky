package com.wellysonfreitas.selikoff_boyarsky.ch7beyondclasses.enums;

@SuppressWarnings({"DataFlowIssue", "SwitchStatementWithTooFewBranches"})
public class EnumsInSwitch {

    public static void main(String[] args) {
        Season summer = Season.SUMMER;
        
        switch (summer) {
            case WINTER:
                System.out.print("Get out the sled!");
                break;
            case SUMMER:
                System.out.print("Time for the pool!");
                break;
            default:
                System.out.println("Is it summer yet?");
        }
        
        var message = switch (summer) {
            case WINTER -> "Winter";
//            case Season.WINTER -> "Get out the sled!"; // DOES NOT COMPILE
//            case 0 -> "Time for the pool!"; // DOES NOT COMPILE
            default -> 1;
        };
        System.out.println(message);
    }
}
