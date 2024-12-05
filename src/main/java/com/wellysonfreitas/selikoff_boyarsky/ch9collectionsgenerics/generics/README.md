# Naming Conventions for Generics

- E for an element
- K for a map key
- V for a map value
- N for a number
- T for a generic data type
- S, U, V, and so forth for multiple generic types

# Types of Bounds

| Type of bound              | Syntax           | Example                                                            |
|----------------------------|------------------|--------------------------------------------------------------------|
| Unbounded wildcard         | `?`              | `List<?> a = new ArrayList<String>();`                             |
| Wildcard  with upper bound | `? extends type` | `List<? extends Exception> a = new ArrayList<RuntimeException>();` |
| Wildcard with lower bound  | `? super type`   | `List<? super Exception> a = new ArrayList<Object>();`             |

The `extends` keyword means any subclass or the class can be used as the type parameter.

The `super` keyword means any parent class or the class can be used as the type parameter.

# Why we need a lower bound

| `static void addSound(_____ list) {list.add("quack";}` | Method compiles                           | Can pass a `List<String>`                 | Can pass a `List<Object>` |
|--------------------------------------------------------|-------------------------------------------|-------------------------------------------|---------------------------|
| `List<?>`                                              | No (unbounded generics are immutable)     | Yes                                       | Yes                       |
| `List<? extends Object>`                               | No (upper-bounded generics are immutable) | Yes                                       | Yes                       |
| `List<Object>`                                         | Yes                                       | No (with generics, must pass exact match) | Yes                       |
| `List<? super String> `                                | Yes                                       | Yes                                       | Yes                       |
