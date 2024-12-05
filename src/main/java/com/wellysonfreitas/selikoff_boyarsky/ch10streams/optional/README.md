# Common `Optional` instance methods

| Method                    | When Optional is empty                         | When Optional contains value |
|---------------------------|------------------------------------------------|------------------------------|
| `get()`                   | Throws exception                               | Returns value                |
| `ifPresent(Consumer c)`   | Does nothing                                   | Calls `Consumer` with value  |
| `isPresent()`             | Returns `false`                                | Returns `true`               |
| `orElse(T other)`         | Returns other parameter                        | Returns value                |
| `orElseGet(Supplier s)`   | Returns result of calling `Supplier`           | Returns value                |
| `orElseThrow()`           | Throws `NoSuchElementException`                | Returns value                |
| `orElseThrow(Supplier s)` | Throws exception created by calling `Supplier` | Returns value                |
