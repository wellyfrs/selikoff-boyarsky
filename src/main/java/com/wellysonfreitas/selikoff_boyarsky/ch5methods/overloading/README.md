# Overloaded Method Choice Order

The order that Java uses to choose the right overloaded method.

| Rule                  | Example of what will be chosen for `glide(1,2)` |
|-----------------------|-------------------------------------------------|
| Exact match by type   | `String glide(int i, int j)`                    |
| Larger primitive type | `String glide(long i, long j)`                  |
| Autoboxed type        | `String glide(Integer i, Integer j)`            |
| Varargs               | `String glide(int... nums)`                     |

Memorize: `ELAV`
