# The java.io abstract stream base classes

| Class name   | Description                                      |
|--------------|--------------------------------------------------|
| InputStream  | Abstract class for all input byte streams.       |
| OutputStream | Abstract class for all output byte streams.      |
| Reader       | Abstract class for all input character streams.  |
| Writer       | Abstract class for all output character streams. |

# Java concrete I/O stream classes

| Class name             | Low/High level | Description                                                                                               |
|------------------------|----------------|-----------------------------------------------------------------------------------------------------------|
| `FileInputStream`      | Low            | Reads file data as bytes                                                                                  |
| `FileOutputStream`     | Low            | Writes file data as bytes                                                                                 |
| `FileReader`           | Low            | Reads file data as characters                                                                             |
| `FileWriter`           | Low            | Writes file data as characters                                                                            |
| `BufferedInputStream`  | High           | Reads byte data from existing `InputStream` in buffered manner, which improves efficiency and performance |
| `BufferedOutputStream` | High           | Writes byte data to existing `OutputStream` in buffered manner, which improves efficiency and performance |
| `BufferedReader`       | High           | Reads character data from existing `Reader` in buffered manner, which improves efficiency and performance |
| `BufferedWriter`       | High           | Writes character data to existing `Writer` in buffered manner, which improves efficiency and performance  |
| `ObjectInputStream`    | High           | Deserializes primitive Java data types and graphs of Java objects from existing `InputStream`             |
| `ObjectOutputStream`   | High           | Serializes primitive Java data types and graphs of Java objects to existing `OutputStream`                |
| `PrintStream`          | High           | Writes formatted representations of Java objects to binary stream                                         |
| `PrintWriter`          | High           | Writes formatted representations of Java objects to character stream                                      |

# Common I/O read and write methods

| Class                       | Method name                                                                                                     | Description                                                                                                      |
|-----------------------------|-----------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------|
| All input streams           | `public int read()`                                                                                             | Reads single byte or returns -1 if no bytes available.                                                           |
| `InputStream`<br/>`Reader`  | `public int read(byte[] b)`<br/>`public int read(char[] c)`                                                     | Reads values into buffer. Returns number of bytes or characters read.                                            |
| `InputStream`<br/>`Reader`  | `public int read(byte[] b, int offset, int length)`<br/>`public int read(char[] c, int offset, int length)`     | Reads up to length values into buffer starting from position offset. Returns number of bytes or characters read. |
| All output streams          | `public void write(int b)`                                                                                      | Writes single byte.                                                                                              |
| `OutputStream`<br/>`Writer` | `public void write(byte[] b)`<br/>`public void write(char[] c)`                                                 | Writes array of values into stream.                                                                              |
| `OutputStream`<br/>`Writer` | `public void write(byte[] b, int offset, int length)`<br/>`public void write(char[] c, int offset, int length)` | Writes length values from array into stream, starting with offset index.                                         |
| BufferedInputStream         | `public byte[] readAllBytes()`                                                                                  | Reads data in bytes.                                                                                             |
| BufferedReader              | `public String readLine()`                                                                                      | Reads line of data.                                                                                              |
| BufferedWriter              | `public void write(String line)`                                                                                | Writes line of data.                                                                                             |
| BufferedWriter              | `public void newLine()`                                                                                         | Writes new line.                                                                                                 |
| All output streams          | `public void flush()`                                                                                           | Flushes buffered data through stream.                                                                            |
| All streams                 | `public void close()`                                                                                           | Closes stream and releases resources.                                                                            |

# Common Files NIO.2 read and write methods

| Method Name                                                | Description                                                        |
|------------------------------------------------------------|--------------------------------------------------------------------|
| `public static byte[] readAllBytes()`                      | Reads all data as bytes                                            |
| `public static String readString()`                        | Reads all data into `String`                                       |
| `public static List<String> readAllLines()`                | Read all data into `List`                                          |
| `public static Stream<String> lines()`                     | Lazily reads data                                                  |
| `public static void write(Path path, byte[] bytes)`        | Writes array of bytes                                              |
| `public static void writeString(Path path, String string)` | Writes `String`                                                    |
| `public static void write(Path path, List<String> list)`   | Writes list of lines (technically, any Iterable of `CharSequence`) |
