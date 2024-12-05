# Comparing `Comparable` and `Comparator`

| Difference                                      | Comparable    | Comparator  |
|-------------------------------------------------|---------------|-------------|
| Package name                                    | `java.lang`   | `java.util` |
| Interface must be implement by class comparing? | Yes           | No          |
| Method name in interface                        | `compareTo()` | `compare()` |
| Number of parameters                            | 1             | 2           |
| Common to declare using a lambda                | No            | Yes         |

# Helper Static Methods for Building a Comparator

| Method                      | Description                                                                                   |
|-----------------------------|-----------------------------------------------------------------------------------------------|
| `comparing(function)`       | Compare by results of function that returns any `Object` (or primitive autoboxed into Object) |
| `comparingDouble(function)` | Compare by results of function that returns `double`.                                         |
| `comparingInt(function)`    | Compare by results of function that returns `int`.                                            |
| `comparingLong(function)`   | Compare by results of function that returns `long`.                                           |
| `naturalOrder()`            | Sort using order specified by the `Comparable` implementation on object itself.               |
| `reverseOrder()`            | Sort using reverse of order specified by Comparable implementation on object itself.          |

# Helper Default Methods for Building a Comparator

| Method                          | Description                                                                                                                          |
|---------------------------------|--------------------------------------------------------------------------------------------------------------------------------------|
| `reversed()`                    | Reverse order of chained `Comparator`.                                                                                               |
| `thenComparing(function)`       | If previous `Comparator` returns `0`, use this comparator that returns Object or can be autoboxed into one.                          |
| `thenComparingDouble(function)` | If previous `Comparator` returns `0`, use this comparator that returns `double`. Otherwise, return value from previous `Comparator`. |
| `thenComparingInt(function)`    | If previous `Comparator` returns `0`, use this comparator that returns `int`. Otherwise, return value from previous `Comparator`.    |
| `thenComparingLong(function)`   | If previous `Comparator` returns `0`, use this comparator that returns `long`. Otherwise, return value from previous `Comparator`.   |
