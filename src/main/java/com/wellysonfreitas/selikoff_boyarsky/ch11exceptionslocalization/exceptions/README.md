# Categories of exception

```text
[java.lang.Throwable] <- [java.lang.Exception] <- (java.lang.RuntimeException)
[java.lang.Throwable] <- (java.lang.Error)
```

# Types of exceptions and errors

| Type                | How to recognize                                               | Okay for program to catch? | Is program required to handle or declare? |
|---------------------|----------------------------------------------------------------|----------------------------|-------------------------------------------|
| Unchecked exception | Subclass of `RuntimeException`                                 | Yes                        | No                                        |
| Checked exception   | Subclass of `Exception` but not subclass of `RuntimeException` | Yes                        | Yes                                       |
| Error               | Subclass of `Error`                                            | No                         | No                                        |

# RuntimeException Classes

| Unchecked exception              | Description                                                                                                                                       |
|----------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------|
| `ArithmeticException`            | Thrown when code attempts to divide by zero.                                                                                                      |
| `ArrayIndexOutOfBoundsException` | Thrown when code uses illegal index to access array.                                                                                              |
| `ClassCastException`             | Thrown when attempt is made to cast object to class of which it is not an instance.                                                               |
| `NullPointerException`           | Thrown when there is a null reference where an object is required.                                                                                |
| `IllegalArgumentException`       | Thrown by programmer to indicate that method has been passed illegal or inappropriate argument.                                                   |
| `NumberFormatException`          | Subclass of `IllegalArgumentException`. Thrown when attempt is made to convert String to numeric type but String doesn't have appropriate format. |

# Checked Exception Classes

| Checked exception          | Description                                                                                                            |
|----------------------------|------------------------------------------------------------------------------------------------------------------------|
| `FileNotFoundException`    | Subclass of `IOException`. Thrown programmatically when code tries to reference file that does not exist.              |
| `IOException`              | Thrown programmatically when problem reading or writing file.                                                          |
| `NotSerializableException` | Subclass of `IOException`. Thrown programmatically when attempting to serialize or deserialize non-serializable class. |
| `ParseException`           | Indicates problem parsing input.                                                                                       |
| `SQLException`             | Thrown when error related to accessing database.                                                                       |

# Errors

| Error                         | Description                                                                                                                     |
|-------------------------------|---------------------------------------------------------------------------------------------------------------------------------|
| `ExceptionInInitializerError` | Thrown when static initializer throws exception and doesn't handle it.                                                          |
| `StackOverflowError`          | Thrown when method calls itself too many times (called _infinite recursion_ because method typically calls itself without end). |
| `NoClassDefFoundError`        | Thrown when class that code uses is available at compile time but not runtime.                                                  |
