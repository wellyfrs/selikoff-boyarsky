# Primitive Types

| Keyword   | Type                        | Min value       | Max value           | Default value | Example |
|-----------|-----------------------------|-----------------|---------------------|---------------|---------|
| `boolean` | true or false               | n/a             | n/a                 | false         | true    |
| `byte`    | 8-bit integral value        | -128            | 127                 | 0             | 123     |
| `short`   | 16-bit integral value       | -32,768         | 32,767              | 0             | 123     |
| `int`     | 32-bit integral value       | -2,147,483,648  | 2,147,483,647       | 0             | 123     |
| `long`    | 64-bit integral value       | -2<sup>63</sup> | -2<sup>63</sup> - 1 | 0L            | 123L    |
| `float`   | 32-bit floating-point value | n/a             | n/a                 | 0.0f          | 123.45f |
| `double`  | 64-bit floating-point value | n/a             | n/a                 | 0.0           | 123.456 |
| `char`    | 16-bit Unicode value        | 0               | 65,535              | \u0000        | 'a'     |

What is the size of boolean? It is not specified and is dependent on the JVM where the code is being executed.

Short and char are closely related. Short is signed, and char is unsigned. Often, short and char values can be cast to one another.

String is not a primitive, although Java includes built-in support for String literals and operators.

# Wrapper Classes

| Primitive type | Wrapper class | Wrapper class inherits Number? | Example of creating          |
|----------------|---------------|--------------------------------|------------------------------|
| `boolean`      | `Boolean`     | No                             | `Boolean.valueOf(true)`      |
| `byte`         | `Byte`        | Yes                            | `Byte.valueOf((byte) 1)`     |
| `short`        | `Short`       | Yes                            | `Short.valueOf((short) 1)`   |
| `int`          | `Integer`     | Yes                            | `Integer.valueOf(1)`         |
| `long`         | `Long`        | Yes                            | `Long.valueOf(1)`            |
| `float`        | `Float`       | Yes                            | `Float.valueOf((float) 1.0)` |
| `double`       | `Double`      | Yes                            | `Double.valueOf(1.0)`        |
| `char`         | `Character`   | No                             | `Character.valueOf('c')`     |

There is also a `valueOf()` variant that converts a String into the wrapper class. For example:

```java
int primitive = Integer.parseInt("123");
Integer wrapper = Integer.valueOf("123");
```

# Text Block Formatting

| Formatting             | Meaning in regular String                                            | Meaning in text block        |
|------------------------|----------------------------------------------------------------------|------------------------------|
| `\"`                   | `"`                                                                  | `"`                          |
| `\"""`                 | n/a - Invalid                                                        | `"""`                        |
| `\"\"\"`               | `"""`                                                                | `"""`                        |
| Space (at end of line) | Space                                                                | Ignored                      |
| `_\s`                  | Two spaces (`\s` is a space and preserves leading space on the line) | Two spaces                   |
| `\ ` (at end of line)  | n/a - Invalid                                                        | Ommits new line on that line |
