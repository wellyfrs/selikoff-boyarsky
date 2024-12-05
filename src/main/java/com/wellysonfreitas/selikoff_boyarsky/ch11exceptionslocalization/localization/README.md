# DecimalFormat symbols

| Symbol | Meaning                                      | Examples |
|--------|----------------------------------------------|----------|
| #      | Omit position if no digit exists for it.     | $2.2     |
| 0      | Put 0 in position if no digit exists for it. | $002.20  |

# Common date/time symbols

| Symbol | Meaning          | Examples                   |
|--------|------------------|----------------------------|
| `y`    | Year             | 22, 2022                   |
| `M`    | Month            | 1, 01, Jan, January        |
| `d`    | Day              | 5, 05                      |
| `h`    | Hour             | 9, 09                      |
| `m`    | Minute           | 45                         |
| `S`    | Second           | 52                         |
| `a`    | a.m./p.m.        | AM, PM                     |
| `z`    | Time zone name   | Eastern Standard Time, EST |
| `Z`    | Time zone offset | -0400                      |

# Supported date/time symbols


| Symbol | LocalDate | LocalTime | LocalDateTime | ZonedDateTime |
|--------|-----------|-----------|---------------|---------------|
| y      | ✔         |           | ✔             | ✔             |
| M      | ✔         |           | ✔             | ✔             |
| d      | ✔         |           | ✔             | ✔             |
| h      |           | ✔         | ✔             | ✔             |
| m      |           | ✔         | ✔             | ✔             |
| s      |           | ✔         | ✔             | ✔             |
| a      |           | ✔         | ✔             | ✔             |
| z      |           |           |               | ✔             |
| Z      |           |           |               | ✔             |

# Factory methods to get a NumberFormat

| Description                             | Using default Locale and a specified Locale                                                                                          |
|-----------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------|
| General-purpose formatter               | `NumberFormat.getInstance()`<br/>`NumberFormat.getInstance(Locale locale)`                                                           |
| Same as `getInstance`                   | `NumberFormat.getNumberInstance()`<br/>`NumberFormat.getNumberInstance(Locale locale)`                                               |
| For formatting monetary amounts         | `NumberFormat.getCurrencyInstance()`<br/>`NumberFormat.getCurrencyInstance(Locale locale)`                                           |
| For formatting percentages              | `NumberFormat.getPercentInstance()`<br/>`NumberFormat.getPercentInstance(Locale locale)`                                             |
| Rounds decimal values before displaying | `NumberFormat.getIntegerInstance()`<br/>`NumberFormat.getIntegerInstance(Locale locale)`                                             |
| Returns compact number formatter        | `NumberFormat.getCompactNumberInstance()`<br/>`NumberFormat.getCompactNumberInstance(Locale locale, NumberFormat.Style formatStyle)` |

# Factory methods to get a DateTimeFormatter

| Description                    | Using default Locale                                                                                                                                         |
|--------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------|
| For formatting dates           | `DateTimeFormatter.ofLocalizedDate(FormatStyle dateStyle)`                                                                                                   |
| For formatting times           | `DateTimeFormatter.ofLocalizedTime(FormatStyle timeStyle)`                                                                                                   |
| For formatting dates and times | `DateTimeFormatter.ofLocalizedDateTime(FormatStyle dateStyle, FormatStyle timeStyle)`<br/>`DateTimeFormatter.ofLocalizedDateTime(FormatStyle dateTimeStyle)` |

# `Locale.Category` values

| Value     | Description                                                |
|-----------|------------------------------------------------------------|
| `DISPLAY` | Category used for displaying data about locale             |
| `FORMAT`  | Category used for formatting dates, numbers, or currencies |

# Picking a resource bundle for French/France with default locale English/US

| Step | Looks for file                                       | Reason                                    |
|------|------------------------------------------------------|-------------------------------------------|
| 1    | `Zoo_fr_FR.properties`                               | Requested locale                          |
| 2    | `Zoo_fr.properties`                                  | Language we requested with no country     |
| 3    | `Zoo_en_US.properties`                               | Default locale                            |
| 4    | `Zoo_en.properties`                                  | Default locale's language with no country |
| 5    | `Zoo.properties`                                     | No locale at all -- default bundle        |
| 6    | If still not found, throw `MissingResourceException` | No locale or default bundle available     |

Or:

1. Look for the resource bundle for the requested locale, followed by the one for the default locale.
2. For each locale, check the language/country, followed by just the language.
3. Use the default resource bundle if no matching locale can be found.

# Selecting resource bundle properties

| Matching resource bundle | Properties files keys can come from                                 |
|--------------------------|---------------------------------------------------------------------|
| `Zoo_fr_FR`              | `Zoo_fr_FR.properties`<br/>`Zoo_fr.properties`<br/>`Zoo.properties` |
