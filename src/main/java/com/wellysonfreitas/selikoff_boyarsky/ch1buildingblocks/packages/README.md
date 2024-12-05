# Order for Declaring a Class

| Element                    | Example               | Required? | Where does it go?                                          |
|----------------------------|-----------------------|-----------|------------------------------------------------------------|
| Package declaration        | `package abc;`        | No        | First line in the file (excluding comments or blank lines) |
| import statements          | `import java.util.*;` | No        | Immediately after the package (if present)                 |
| Top-level type declaration | `public class C`      | Yes       | Immediately after the import (if any)                      |
| Field declarations         | `int value;`          | No        | Any top-level element within a class                       |
| Method declarations        | `void method()`       | No        | Any top-level element within a class                       |
