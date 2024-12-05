package com.wellysonfreitas.selikoff_boyarsky.ch3makingdecisions.branching;

@SuppressWarnings({"SwitchStatementWithTooFewBranches", "DataFlowIssue"})
class ReturnStatement {
    public static void main(String[] args) {
        int[][] list = {{1, 13}, {5, 2}, {2, 2}};
        int searchValue = 2;
        int[] results = FindInMatrixUsingReturn.searchForValue(list, searchValue);
        
        if (results == null) {
            System.out.println("Value " + searchValue + " not found");
        } else {
            System.out.println("Value " + searchValue + " found at: " + "(" + results[0] + "," + results[1] + ")");
        }
        
        // Unreachable code
        int hour = 2;
        switch (hour) {
//            case 1: return; hour++; // DOES NOT COMPILE
            case 2:
        }
    }
    
    static class FindInMatrixUsingReturn {
        private static int[] searchForValue(int[][] list, int v) {
            for (int i = 0; i < list.length; i++) {
                for (int j = 0; j < list[i].length; j++) {
                    if (list[i][j] == v) {
                        return new int[] {i, j};
                    }
                }
            }
            return null;
        }
    }
}
