# Implicit Modifier Interfaces

- Interfaces are implicitly abstract.
- Interface **variables** are implicitly public, static, and final.
- Interface **methods** without a body are implicitly abstract and without the private modifier are implicitly public.

# Interface Member Types

|                         | Membership type | Required modifiers     | Implicit modifiers                | Has value or body? |
|-------------------------|-----------------|------------------------|-----------------------------------|--------------------|
| Constant variable       | Class           | -                      | `public`<br/>`static`<br/>`final` | Yes                |
| `abstract` method       | Instance        | -                      | `public`<br/>`abstract`           | No                 |
| `default` method        | Instance        | `default`              | `public`                          | Yes                |
| `static` method         | Class           | `static`               | `public`                          | Yes                |
| `private` method        | Instance        | `private`              | -                                 | Yes                |
| `private static` method | Class           | `private`<br/>`static` | -                                 | Yes                |

# Default Interface Method Definition Rules

1. A default method may be declared only within an interface.
2. A default method must be marked with the default keyword and include a method body.
3. A default method is implicitly public.
4. A default method cannot be marked abstract, final, or static.
5. A default method may be overridden by a class that implements the interface.
6. If a class inherits two or more default methods with the same method signature, then the class must override the method.

# Static Interface Method Definition Rules

1. A static method must be marked with the static keyword and include a method body.
2. A static method without an access modifier is implicitly public.
3. A static method cannot be marked abstract or final.
4. A static method is not inherited and cannot be accessed in a class implementing the interface without a reference to the interface name.

# Private Interface Methods Definition Rules

1. A private interface method must be marked with the private modifier and include a method body.
2. A private static interface method may be called by any method within the interface definition.
3. A private interface method may only be called by default and other private non-static methods within the interface definition.

# Interface Member Access

|                       | Accessible from default and private methods within the interface? | Accessible from static methods within the interface? | Accessible from methods in classes inheriting the interface? | Accessible without an instance of the interface? |
|-----------------------|-------------------------------------------------------------------|------------------------------------------------------|--------------------------------------------------------------|--------------------------------------------------|
| Constant variable     | Yes                                                               | Yes                                                  | Yes                                                          | Yes                                              |
| abstract method       | Yes                                                               | No                                                   | Yes                                                          | No                                               |
| default method        | Yes                                                               | No                                                   | Yes                                                          | No                                               |
| static method         | Yes                                                               | Yes                                                  | Yes (interface name required)                                | Yes (interface name required)                    |
| private method        | Yes                                                               | No                                                   | No                                                           | No                                               |
| private static method | Yes                                                               | Yes                                                  | No                                                           | No                                               |

Quick tips:

- Treat abstract, default, and non-static private methods as belonging to an instance of the instance.
- Treat static methods and variables as belonging to the interface class object.
- All private interface method types are only accessible within the interface declaration.
