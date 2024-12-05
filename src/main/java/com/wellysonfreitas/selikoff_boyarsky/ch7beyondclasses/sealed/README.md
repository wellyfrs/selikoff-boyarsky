# Sealed Class Rules

- Sealed classes are declared with the sealed and permits modifiers.
- Sealed classes must be declared in the same package or named module as their direct subclasses.
- Direct subclasses of sealed classes must be marked final, sealed, or non-sealed.
- The permits clause is optional if the sealed class and its direct subclasses are declared within the same file or the subclasses are nested within the sealed class.
- Interfaces can be sealed to limit the classes that implement them or the interfaces that extend them.

# Usage of the `permits` Clause in Sealed Classes

| Location of direct subclasses             | `permits` clause            |
|-------------------------------------------|-----------------------------|
| In a different file from the sealed class | Required                    |
| In the same file as the sealed class      | Permitted, but not required |
| Nested inside of the sealed class         | Permitted, but not required |
