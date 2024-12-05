# Rules on initializing objects

- A class is initialized at most once by the JVM before it is referenced or used.

- All static final variables must be assigned a value exactly once, either when they are declared or in a static initializer.

- All final fields must be assigned a value exactly once, either when they are declared, in an instance initializer, or in a constructor.

- Non-final static and instance variables defined without a value are assigned a default value based on their type.

- Order of initialization is as follows: variable declarations, then initializers, and finally constructors.
