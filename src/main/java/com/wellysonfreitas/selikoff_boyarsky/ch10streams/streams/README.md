# Three parts of a stream pipeline

- **Source:** where the stream comes from.
- **Intermediate operations:** transforms the stream into another one. There can be as few or as many intermediate operations as you'd like. Since streams use lazy evaluation, the intermediate operations do not run until the terminal operation runs.
- **Terminal operation:** produces a result. Since streams can be used only once, the stream is no longer valid after a terminal operation completes.

# Intermediate vs. Terminal Operations

| Scenario                              | Intermediate operation | Terminal operation |
|---------------------------------------|------------------------|--------------------|
| Required part of useful pipeline?     | No                     | Yes                |
| Can exist multiple times in pipeline? | Yes                    | No                 |
| Return type is stream type?           | Yes                    | No                 |
| Executed upon method call?            | No                     | Yes                |
| Stream valid after call?              | Yes                    | No                 |

# Creating a Stream Source

| Method                                           | Finite or infinite? | Notes                                                                                                                                                     |
|--------------------------------------------------|---------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------|
| `Stream.empty()`                                 | Finite              | Creates Stream with zero elements.                                                                                                                        |
| `Stream.of(varargs)`                             | Finite              | Creates Stream with elements listed.                                                                                                                      |
| `coll.stream()`                                  | Finite              | Creates Stream from Collection.                                                                                                                           |
| `coll.parallelStream()`                          | Finite              | Creates Stream from Collection where the stream can run in parallel.                                                                                      |
| `Stream.generate(supplier)`                      | Infinite            | Creates Stream by calling Supplier for each element upon request.                                                                                         |
| `Stream.iterate(seed, unaryOperator)`            | Infinite            | Creates Stream by using seed for first element and then calling UnaryOperator for each subsequent element upon request.                                   |
| `Stream.iterate(seed, predicate, unaryOperator)` | Finite or infinite  | Creates Stream by using seed for first element and then calling UnaryOperator for each subsequent element upon request. Stops if Predicate returns false. |

# Terminal Stream Operations

| Method                                          | What happens for infinite streams | Return value  | Reduction |
|-------------------------------------------------|-----------------------------------|---------------|-----------|
| `count()`                                       | Does not terminate                | `long`        | Yes       |
| `min()`<br/>`max()`                             | Does not terminate                | `Optional<T>` | Yes       |
| `findAny()`<br/>`findFirst()`                   | Terminates                        | `Optional<T>` | No        |
| `allMatch()`<br/>`anyMatch()`<br/>`noneMatch()` | Sometimes terminates              | `boolean`     | No        |
| `forEach()`                                     | Does not terminate                | `void`        | No        |
| `reduce()`                                      | Does not terminate                | Varies        | Yes       |
| `collect()`                                     | Does not terminate                | Varies        | Yes       |
