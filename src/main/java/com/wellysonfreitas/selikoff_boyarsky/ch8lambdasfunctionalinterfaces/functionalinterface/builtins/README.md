# Common Functional Interfaces

| Functional interface  | Return type           | Method name    | # of parameters |
|-----------------------|-----------------------|----------------|-----------------|
| `Supplier<T>`         | `T`                   | `get()`        | 0               |
| `Consumer<T>`         | `void`                | `accept(T)`    | 1 (`T`)         |
| `BiConsumer<T, U>`    | `void`                | `accept(T, U)` | 2 (`T`, `U`)    |
| `Predicate<T>`        | `boolean` (primitive) | `test(T)`      | 1 (`T`)         |
| `BiPredicate<T, U>`   | `boolean` (primitive) | `test(T, U)`   | 2 (`T`, `U`)    |
| `Function<T, R>`      | `R`                   | `apply(T)`     | 1 (`T`)         |
| `BiFunction<T, U, R>` | `R`                   | `apply(T, U)`  | 2 (`T`, `U`)    |
| `UnaryOperator<T>`    | `T`                   | `apply(T)`     | 1 (`T`)         |
| `BinaryOperator<T>`   | `T`                   | `apply(T, T)`  | 2 (`T`, `T`)    |

# Convenience Methods

| Interface instance | Method return type | Method name | Method parameters |
|--------------------|--------------------|-------------|-------------------|
| Consumer           | Consumer           | `andThen()` | Consumer          |
| Function           | Function           | `andThen()` | Function          |
| Function           | Function           | `compose()` | Function          |
| Predicate          | Predicate          | `and()`     | Predicate         |
| Predicate          | Predicate          | `negate()`  | -                 |
| Predicate          | Predicate          | `or()`      | Predicate         |

# Functional interfaces for `double`, `int`, and `long`

| Functional interfaces                                                   | Return type                   | Single abstract method                             | # of parameters                                                    |
|-------------------------------------------------------------------------|-------------------------------|----------------------------------------------------|--------------------------------------------------------------------|
| `DoubleSupplier`<br/>`IntSupplier`<br/>`LongSupplier`                   | `double`<br/>`int`<br/>`long` | `getAsDouble`<br/>`getAsInt`<br/>`getAsLong`       | 0                                                                  |
| `DoubleConsumer`<br/>`IntConsumer`<br/>`LongConsumer`                   | `void`                        | `accept`                                           | 1 (`double`)<br/>1 (`int`)<br/>1 (`long`)                          |
| `DoublePredicate`<br/>`IntPredicate`<br/>`LongPredicate`                | `boolean`                     | `test`                                             | 1 (`double`)<br/>1 (`int`)<br/>1 (`long`)                          |
| `DoubleFunction<R>`<br/>`IntFunction<R>`<br/>`LongFunction<R>`          | `R`                           | `apply`                                            | 1 (`double`)<br/>1 (`int`)<br/>1 (`long`)                          |
| `DoubleUnaryOperator`<br/>`IntUnaryOperator`<br/>`LongUnaryOperator`    | `double`<br/>`int`<br/>`long` | `applyAsDouble`<br/>`applyAsInt`<br/>`applyAsLong` | 1 (`double`)<br/>1 (`int`)<br/>1 (`long`)                          |
| `DoubleBinaryOperator`<br/>`IntBinaryOperator`<br/>`LongBinaryOperator` | `double`<br/>`int`<br/>`long` | `applyAsDouble`<br/>`applyAsInt`<br/>`applyAsLong` | 2 (`double`, `double`)<br/>2 (`int`, `int`)<br/>2 (`long`, `long`) |

# Primitive-specific Functional Interfaces

| Functional interfaces                                                                                                                                 | Return type                                                     | Single abstract method                                                                                    | # of parameters                                                                         |
|-------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------|
| `ToDoubleFunction<T>`<br/>`ToIntFunction<T>`<br/>`ToLongFunction<T>`                                                                                  | `double`<br/>`int`<br/>`long`                                   | `applyAsDouble`<br/>`applyAsInt`<br/>`applyAsLong`                                                        | 1 (`T`)                                                                                 |
| `ToDoubleBiFunction<T, U>`<br/>`ToIntBiFunction<T, U>`<br/>`ToLongBiFunction<T, U>`                                                                   | `double`<br/>`int`<br/>`long`                                   | `applyAsDouble`<br/>`applyAsInt`<br/>`applyAsLong`                                                        | 2 (`T`, `U`)                                                                            |
| `DoubleToIntFunction`<br/>`DoubleToLongFunction`<br/>`IntToDoubleFunction`<br/>`IntToLongFunction`<br/>`LongToDoubleFunction`<br/>`LongToIntFunction` | `int`<br/>`long`<br/>`double`<br/>`long`<br/>`double`<br/>`int` | `applyAsInt`<br/>`applyAsLong`<br/>`applyAsDouble`<br/>`applyAsLong`<br/>`applyAsDouble`<br/>`applyAsInt` | 1 (`double`)<br/>1 (`double`)<br/>1 (`int`)<br/>1 (`int`)<br/>1 (`long`)<br/>1 (`long`) |
| `ObjDoubleConsumer<T>`<br/>`ObjIntConsumer<T>`<br/>`ObjLongConsumer<T>`                                                                               | `void`                                                          | `accept`                                                                                                  | 2 (`T`, `double`)<br/>2 (`T`, `int`)<br/>2 (`T`, `long`)                                |
