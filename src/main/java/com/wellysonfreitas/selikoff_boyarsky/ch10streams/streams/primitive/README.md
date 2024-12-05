# Common Primitive Stream Methods

| Method                                        | Primitive stream                                | Description                                                                          |
|-----------------------------------------------|-------------------------------------------------|--------------------------------------------------------------------------------------|
| `OptionalDouble average()`                    | `IntStream`<br/>`LongStream`<br/>`DoubleStream` | Arithmetic mean of elements                                                          |
| `Stream<T> boxed()`                           | `IntStream`<br/>`LongStream`<br/>`DoubleStream` | Stream<T> where T is wrapper class associated with primitive value                   |
| `OptionalInt max()`                           | `IntStream`                                     | Maximum element of stream                                                            |
| `OptionalLong max()`                          | `LongStream`                                    | Maximum element of stream                                                            |
| `OptionalDouble max()`                        | `DoubleStream`                                  | Maximum element of stream                                                            |
| `OptionalInt min()`                           | `IntStream`                                     | Minimum element of stream                                                            |
| `OptionalLong min()`                          | `LongStream`                                    | Minimum element of stream                                                            |
| `OptionalDouble min()`                        | `DoubleStream`                                  | Minimum element of stream                                                            |
| `IntStream range(int a, int b)`               | `IntStream`                                     | Returns primitive stream from a (inclusive) to b (exclusive)                         |
| `LongStream range(long a, long b)`            | `LongStream`                                    | Returns primitive stream from a (inclusive) to b (exclusive)                         |
| `IntStream rangeClosed(int a, int b)`         | `IntStream`                                     | Returns primitive stream from a (inclusive) to b (inclusive)                         |
| `LongStream rangeClosed(long a, long b)`      | `LongStream`                                    | Returns primitive stream from a (inclusive) to b (inclusive)                         |
| `int sum()`                                   | `IntStream`                                     | Returns sum of elements in stream                                                    |
| `long sum()`                                  | `LongStream`                                    | Returns sum of elements in stream                                                    |
| `double sum()`                                | `DoubleStream`                                  | Returns sum of elements in stream                                                    |
| `IntSummaryStatistics summaryStatistics()`    | `IntStream`                                     | Returns object containing numerous stream statistics such as average, min, max, etc. |
| `LongSummaryStatistics summaryStatistics()`   | `LongStream`                                    | Returns object containing numerous stream statistics such as average, min, max, etc. |
| `DoubleSummaryStatistics summaryStatistics()` | `DoubleStream`                                  | Returns object containing numerous stream statistics such as average, min, max, etc. |

# Mapping Streams

| Source stream class | To create Stream | To create DoubleStream | To create IntStream | To create LongStream |
|---------------------|------------------|------------------------|---------------------|----------------------|
| `Stream<T>`         | `map()`          | `mapToDouble()`        | `mapToInt()`        | `mapToLong()`        |
| `DoubleStream`      | `mapToObj()`     | `map()`                | `mapToInt()`        | `mapToLong()`        |
| `IntStream`         | `mapToObj()`     | `mapToDouble()`        | `map()`             | `mapToLong()`        |
| `LongStream`        | `mapToObj()`     | `mapToDouble()`        | `mapToInt()`        | `map()`              |

# Function parameters when mapping between types of stream

| Source stream class | To create Stream     | To create DoubleStream  | To create IntStream    | To create LongStream    |
|---------------------|----------------------|-------------------------|------------------------|-------------------------|
| `Stream<T>`         | `Function<T,R>`      | `ToDoubleFunction<R>`   | `ToIntFunction<T>`     | `ToLongFunction<T>`     |
| `DoubleStream`      | `Double Function<R>` | `DoubleUnary Operator`  | `DoubleToInt Function` | `DoubleToLong Function` |
| `IntStream`         | `IntFunction<R>`     | `IntToDouble Function`  | `IntUnary Operator`    | `IntToLong Function`    |
| `LongStream`        | `Long Function<R>`   | `LongToDouble Function` | `LongToInt Function`   | `LongUnary Operator`    |

# Optional types for primitives

|                                    | `OptionalDouble` | `OptionalInt`    | `OptionalLong`   |
|------------------------------------|------------------|------------------|------------------|
| Getting as primitive               | `getAsDouble()`  | `getAsInt()`     | `getAsLong()`    |
| `orElseGet()` parameter type       | `DoubleSupplier` | `IntSupplier`    | `LongSupplier`   |
| Return type of `max()` and `min()` | `OptionalDouble` | `OptionalInt`    | `OptionalLong`   |
| Return type of `sum()`             | `double`         | `int`            | `long`           |
| Return type of `average()`         | `OptionalDouble` | `OptionalDouble` | `OptionalDouble` |
