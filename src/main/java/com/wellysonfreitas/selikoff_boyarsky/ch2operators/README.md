# Order of Operator Precedence

| Operator                        | Symbols and examples                                                       | Evaluation    |
|---------------------------------|----------------------------------------------------------------------------|---------------|
| Post-unary operators            | `expression++`, `expression--`                                             | Left-to-right |
| Pre-unary operators             | `++expression`, `--expression`                                             | Left-to-right |
| Other unary operators           | `-`, `!`, `~`, `(type)`                                                    | Right-to-left |
| Cast                            | `(Type)reference`                                                          | Right-to-left |
| Multiplication/division/modulus | `*`, `/`, `%`                                                              | Left-to-right |
| Addition/subtraction            | `+`, `-`                                                                   | Left-to-right |
| Shift operators                 | `<<`, `>>`, `>>>`                                                          | Left-to-right |
| Relational operators            | `<`, `>`, `<=`, `>=`, `instanceof`                                         | Left-to-right |
| Equal to/not equal to           | `==`, `!=`                                                                 | Left-to-right |
| Logical AND                     | `&`                                                                        | Left-to-right |
| Logical exclusive OR            | `^`                                                                        | Left-to-right |
| Logical inclusive OR            | `\|`                                                                       | Left-to-right |
| Conditional AND                 | `&&`                                                                       | Left-to-right |
| Conditional OR                  | `\|\|`                                                                     | Left-to-right |
| Ternary operators               | `boolean expression ? expression1 : expression2`                           | Right-to-left |
| Assignment operators            | `=`, `+=`, `-=`, `*=`, `/=`, `%=`, `&=`, `^=`, `\|=`, `<<=`, `>>=`, `>>>=` | Right-to-left |
| Arrow operator                  | `->`                                                                       | Right-to-left |

# Memorize

1. `post-unary` -> `pre-unary`
2. `unary` -> `reference cast`
3. `mult/div/mod` -> `add/sub`
4. `shift`
5. `relational` -> `equality`
6. `logical AND` -> `logical XOR` -> `logical OR`
7. `AND` -> `OR`
8. `ternary`
9. `assignment`
10. `arrow`
