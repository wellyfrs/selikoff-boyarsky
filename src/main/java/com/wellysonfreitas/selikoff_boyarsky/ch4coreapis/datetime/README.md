# Methods in DateTime API classes

|                                      | Can call on LocalDate? | Can call on LocalTime? | Can call on LocalDateTime or ZonedDateTime? |
|--------------------------------------|------------------------|------------------------|---------------------------------------------|
| `plusYears()`<br/>`minusYears()`     | Yes                    | No                     | Yes                                         |
| `plusMonths()`<br/>`minusMonths()`   | Yes                    | No                     | Yes                                         |
| `plusWeeks()`<br/>`minusWeeks()`     | Yes                    | No                     | Yes                                         |
| `plusDays()`<br/>`minusDays()`       | Yes                    | No                     | Yes                                         |
| `plusHours()`<br/>`minusHours()`     | No                     | Yes                    | Yes                                         |
| `plusMinutes()`<br/>`minusMinutes()` | No                     | Yes                    | Yes                                         |
| `plusDays()`<br/>`minusSeconds()`    | No                     | Yes                    | Yes                                         |
| `plusNanos()`<br/>`minusNanos()`     | No                     | Yes                    | Yes                                         |

# Duration vs. Period

|               | Can use with Period? | Can use with Duration? |
|---------------|----------------------|------------------------|
| LocalDate     | Yes                  | No                     |
| LocalDateTime | Yes                  | Yes                    |
| LocalTime     | No                   | Yes                    |
| ZonedDateTime | Yes                  | Yes                    |
