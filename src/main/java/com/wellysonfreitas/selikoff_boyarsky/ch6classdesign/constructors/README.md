# Golden rule

The first statement of every constructor is a call to a parent constructor using `super()`
or another constructor in the class using `this()`.

# Rules on constructors with `super()`

- The first line of every constructor is a call to a parent constructor using `super()` or an overloaded constructor using `this()`.

- If the constructor does not contain a `this()` or `super()` reference, then the compiler automatically inserts `super()` with no arguments as the first line of the constructor.

- If a constructor calls `super()`, then it must be the first line of the constructor.

# Rules on constructors with `this()`

- A class can contain many overloaded constructors, provided the signature for each is distinct.

- The compiler inserts a default no-argument constructor if no constructors are declared.

- If a constructor calls `this()`, then it must be the first line of the constructor.

- Java does not allows cyclic constructor calls.
