package com.wellysonfreitas.selikoff_boyarsky.ch2operators.binary;

/*

CONDITIONAL OPERATORS

The conditional operators, often called short-circuit operators,
are nearly identical to the logical operators, `&` and `|`,
except that the right side of the expression may never be evaluated
if the final result can be determined by the left side of the expression.

*/
@SuppressWarnings({"PointlessBooleanExpression", "StatementWithEmptyBody", "ConstantValue", "DataFlowIssue"})
class ConditionalOperators {
    public static void main(String[] args) {
        int hour = 10;
        boolean zooOpen = true || (hour < 4);
        System.out.println(zooOpen); // true
        
        // Avoiding a NullPointerException
        Duck duck = null;
        if(duck!=null & duck.getAge()<5) { // Could throw a NullPointerException
            // Do something
        }

        if(duck!=null && duck.getAge()<5) { // Evaluation of duck.getAge()<5 is never reached
            // Do something
        }
        
        // Trick code:
        int rabbit = 6;
        boolean bunny = (rabbit>=6) || (++rabbit <= 7); // because rabbit >= 6 is true, increment is never evaluated
        System.out.println(rabbit); // 6
    }

    static class Duck {
        private final int age;
        public Duck(int age) {
            this.age = age;
        }
        public int getAge() {
            return age;
        }
    }
}
