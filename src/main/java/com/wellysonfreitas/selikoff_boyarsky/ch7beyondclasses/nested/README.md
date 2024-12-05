# Nested Classes

A nested class is a class that is defined within another class.

A nested class can come in one of four flavors.

- Inner class: a non-static type defined at the member level of a class.
- Static nested class: a static type defined at the member level of a class.
- Local class: a class defined within a method body.
- Anonymous class: a special case of a local class that does not have a name.

Obs.: the compiler generates a separate `.class` file for each inner class.

## Modifiers in nested classes

| Permitted modifiers | Inner class | static nested class | Local class | Anonymous class |
|---------------------|-------------|---------------------|-------------|-----------------|
| Access modifiers    | All         | All                 | None        | None            |
| `abstract`          | Yes         | Yes                 | Yes         | No              |
| `final`             | Yes         | Yes                 | Yes         | No              |


## Nested class access rules

|                                                           | Inner class | static nested class | Local class                             | Anonymous class                                         |
|-----------------------------------------------------------|-------------|---------------------|-----------------------------------------|---------------------------------------------------------|
| Can extend a class or implement any number of interfaces? | Yes         | Yes                 | Yes                                     | No -- must have exactly one superclass or one interface |
| Can access instance members of enclosing class?           | Yes         | No                  | Yes (if declared in an instance method) | Yes (if declared in an instance method)                 |
| Can access local variables of enclosing method?           | N/A         | N/A                 | Yes (if final or effectively final)     | Yes (if final or effectively final)                     |
