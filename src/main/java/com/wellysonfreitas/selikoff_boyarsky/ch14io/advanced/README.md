# Common I/O stream methods

| Method name                      | Description                                       |
|----------------------------------|---------------------------------------------------|
| `public boolean markSupported()` | Returns true if stream class supports mark()      |
| `public mark(int readLimit)`     | Marks current position in stream                  |
| `public void reset()`            | Attempts to reset stream to mark() position       |
| `public long skip(long n)`       | Reads and discards specified number of characters |

# Attributes and view types

| Attributes interface | View interface         | Description                                                                                         |
|----------------------|------------------------|-----------------------------------------------------------------------------------------------------|
| BasicFileAttributes  | BasicFileAttributeView | Basic set of attributes supported by all file systems.                                              |
| DosFileAttributes    | DosFileAttributeView   | Basic set of attributes along with those supported by DOS/Windows-based systems                     |
| PosixFileAttributes  | PosixFileAttributeView | Basic set of attributes along with those supported by POSIX systems, such as Unix, Linux, Mac, etc. |
