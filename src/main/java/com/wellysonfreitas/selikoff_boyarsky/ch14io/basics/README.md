# File-system symbols

| Symbol | Description                                         |
|--------|-----------------------------------------------------|
| `.`    | A reference to the current directory.               |
| `..`   | A reference to the parent of the current directory. |

# Options for creating File and Path

| Creates      | Declared in   | Method or Constructor                                                                                                      |
|--------------|---------------|----------------------------------------------------------------------------------------------------------------------------|
| `File`       | `File`        | `public File(String pathname)`<br/>`public File(file parent, String child)`<br/>`public File(String parent, String child)` |
| `File`       | `Path`        | `public default File toFile()`                                                                                             |
| `Path`       | `File`        | `public Path toPath()`                                                                                                     |
| `Path`       | `Path`        | `public static Path of(String first, String... more)`<br/>`public static Path of(URI uri)`                                 |
| `Path`       | `Paths`       | `public static Path get(String first, String... more)`<br/>`public static Path get(URI uri)`                               |
| `Path`       | `FileSystem`  | `public Path getPath(String first, String... more)`                                                                        |
| `FileSystem` | `FileSystems` | `public static FileSystem getDefault()`                                                                                    |

# Common File and Path operations

| Description                                         | I/O file instance method | NIO.2 path instance method |
|-----------------------------------------------------|--------------------------|----------------------------|
| Gets name of file/directory                         | `getName()`              | `getFileName()`            |
| Retrieves parent directory or null if there is none | `getParent()`            | `getParent()`              |
| Checks if file/directory is absolute path           | `isAbsolute()`           | `isAbsolute()`             |

# Common File and Files operations

| Description                                                    | I/O file instance method | NIO.2 files static method                                          |
|----------------------------------------------------------------|--------------------------|--------------------------------------------------------------------|
| Deletes file/directory                                         | `delete()`               | `deleteIfExists(Path p) throws IOException`                        |
| Checks if file/directory exists                                | `exists()`               | `exists(Path p, LinkOption... o)`                                  |
| Retrieves absolute path of file/directory                      | `getAbsolutePath()`      | `toAbsolutePath()`                                                 |
| Checks if resource is directory                                | `isDirectory()`          | `isDirectory(Path p, LinkOption... o)`                             |
| Checks if resource is file                                     | `isFile()`               | `isRegularFile(Path p, LinkOption... o)`                           |
| Returns the time the file was last modified                    | `lastModified()`         | `getLastModifiedTime(Path p, LinkOption... o) throws IOException`  |
| Retrieves number of bytes in file                              | `length()`               | `size(Path p) throws IOException`                                  |
| Lists contents of directory                                    | `listFiles()`            | `list(Path p) throws IOException`                                  |
| Creates directory                                              | `mkdir()`                | `createDirectory(Path p, FileAttribute... a) throws IOException`   |
| Creates directory including any nonexistent parent directories | `mkdirs()`               | `createDirectories(Path p, FileAttribute... a) throws IOException` |
| Renames file/directory denoted                                 | `renameTo(File dest)`    | `move(Path src, Path dest, CopyOption... o) throws IOException`    |

# Providing NIO.2 Optional Parameters

| Enum type            | Interface inherited           | Enum value                                                                            | Details                                                                                                                                                                                                                                                                                        |
|----------------------|-------------------------------|---------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `LinkOption`         | `CopyOption`<br/>`OpenOption` | `NOFOLLOW_LINKS`                                                                      | Do not follow symbolic links.                                                                                                                                                                                                                                                                  |
| `StandardCopyOption` | `CopyOption`                  | `ATOMIC_MOVE`<br/>`COPY_ATTRIBUTES`<br/>`REPLACE_EXISTING`                            | Move file as atomic file system operation.<br/>Copy existing attributes to new file.<br/>Overwrite file if it already exists.                                                                                                                                                                  |
| `StandardOpenOption` | `OpenOption`                  | `APPEND`<br/>`CREATE`<br/>`CREATE_NEW`<br/>`READ`<br/>`TRUNCATE_EXISTING`<br/>`WRITE` | If file is already open for write, append to the end.<br/>Create new file if it does not exist.<br/>Create new file only if it does not exist; fail otherwise.<br/>Open for read access.<br/>If file is already open for write, erase file and append to beginning.<br/>Open for write access. |
| `FileVisitOption`    | N/A                           | `FOLLOW_LINKS`                                                                        | Follow symbolic links.                                                                                                                                                                                                                                                                         |

# Path APIs

| Description                                       | Method or constructor                                             |
|---------------------------------------------------|-------------------------------------------------------------------|
| File path as string                               | `public String toString()`                                        |
| Single segment                                    | `public Path getName(int index)`                                  |
| Number of segments                                | `public int getNameCount()`                                       |
| Segments in range                                 | `public Path subpath(int beginIndex, int endIndex)`               |
| Final segment                                     | `public Path getFileName()`                                       |
| Immediate parent                                  | `public Path getParent()`                                         |
| Top-level segment                                 | `public Path getRoot()`                                           |
| Concatenate paths                                 | `public Path resolve(String p)`<br/>`public Path resolve(Path p)` |
| Construct path to one provided                    | `public Path relativize(Path p)`                                  |
| Remove redundant parts of path                    | `public Path normalize()`                                         |
| Follow symbolic links to find path on file system | `public Path toRealPath()`                                        |
