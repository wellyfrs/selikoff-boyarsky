# Rules for accessing a variable from a lambda body inside a method

| Variable type     | Rule                                  |
|-------------------|---------------------------------------|
| Instance variable | Allowed                               |
| Static variable   | Allowed                               |
| Local variable    | Allowed if final or effectively final |
| Method parameter  | Allowed if final or effectively final |
| Lambda parameter  | Allowed                               |
