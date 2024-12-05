# Java key commands

- `javac`: Convertes `.java` source files into `.class` bytecode
- `java`: Executes the program
- `jar`: Packages files together
- `javadoc`: Generates documentation

## Checking version

```bash
javac -version
java -version
```

## Compiling and running

To compile Java code with the `javac` command, the file must have the extension `.java`.
The name of the file must the name of the public class.
The result is a file of bytecode with the same name but with a `.class` filename extension.
The `.class` extension should be omitted when running it with `java` command.
You can do both compilation and run at once with `java` command passing the `.java` file.

```bash
javac Zoo.java
java Zoo
```

Or equivalent (Single-File Source-Code):

```bash
java Zoo.java
```

## Compiling and running with packages

```bash
javac packagea/ClassA.java packageb/ClassB.java
```

or with wildcards:

```bash
javac packagea/*.java packageb/*.java
```

Running:

```
java packageb.ClassB
```

## Compiling to another directory

```
javac -d classes packagea/ClassA.java packageb/ClassB.java
```

To run ghe program, you specify the classpath (all equivalent):

```bash
java -cp classes packageb.ClassB
```

```bash
java --classpath classes packageb.ClassB
```

```bash
java --class-path classes packageb.ClassB
```

## Passing parameters

Passing parameters to the `main` method:

```bash
java Zoo Bronx Zoo
java Zoo "San Diego" Zoo
```

## Compiling with JAR files

A _Java archive_ (JAR) file is like a ZIP file of mainly Java class files.

```bash
java -cp ".:/tmp/someOtherLocation:/tmp/myJar.jar" myPackage.MyClass
```

With wildcard:

```bash
java -cp ".:/tmp/directoryWithJards/*" myPackage.MyClass
```

## Creating a JAR file

Short form:

```bash
jar -cvf myNewFile.jar .
jar --create --verbose --file myNewFile.jar .
```

Specifying a directory instead of using the current directory:

```bash
jar -cvf myNewFile.jar -C dir .
```
