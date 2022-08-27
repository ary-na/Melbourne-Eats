# Melbourne-Eats

RMIT University - Academic Integrity Warning:
> "For serious breaches of academic integrity, students can be charged with academic misconduct. Possible penalties include **cancellation of results** and **expulsion resulting in the cancellation of a student's program**."

For more information visit [Academic Integrity at RMIT](https://www.rmit.edu.au/students/my-course/assessment-results/academic-integrity)

The system keeps a list of restaurants from which users can order their food. It allows users to order from different restaurants and receive discounts on the combined order. The restaurant's list is provided in the Restaurants.txt file, and discount information is provided in the Discounts.txt file.

- Minimum requirements: _Java 15 or higher_

## To run the program:

**Method 1** - Run the executable Melbourne-Eats.jar file using the command prompt.

**1.1.** To run the executable jar file, using the command prompt, navigate to:

```
Melbourne-Eats/out/artifacts/Melbourne_Eats_jar
```

**1.2.** And run the following command:

```
java -jar Melbourne-Eats.jar 
```
\
**Method 2** - Compile and run the program using the command prompt.

**2.1.** To compile and run the program, navigate to:

```
Melbourne-Eats/src
```

**2.2.** Run the following command to compile java files:

```
javac melbourne/eats/*.java
```

**2.3.** And then run the following command to run the program:

```
java melbourne.eats.MelbourneEats
```

**Alternatively, import the project to [IntelliJ IDEA](https://www.jetbrains.com/idea/download/?fromIDE=#section=mac) and run the program from the IDE.**

## To run the Unit tests:

Using the command prompt navigate to:

```
Melbourne-Eats/src
```

And compile the test.java files on Linux or macOS using the following command:

```
javac -cp .:melbourne/eats/test/junit-4.13.1.jar:melbourne/eats/test/hamcrest-core-1.3.jar melbourne/eats/test/*.java
```

And on Windows:

```
javac -cp .;melbourne/eats/test/junit-4.13.1.jar;melbourne/eats/test/hamcrest-core-1.3.jar melbourne/eats/test/*.java
```

And run the test classes using the corresponding command for each test file on Linux or macOS using the following commands:

```
java -cp .:melbourne/eats/test/junit-4.13.1.jar:melbourne/eats/test/hamcrest-core-1.3.jar org.junit.runner.JUnitCore melbourne.eats.test.OrderTest
java -cp .:melbourne/eats/test/junit-4.13.1.jar:melbourne/eats/test/hamcrest-core-1.3.jar org.junit.runner.JUnitCore melbourne.eats.test.ProviderTest
```

And on Windows:

```
java -cp .;melbourne/eats/test/junit-4.13.1.jar;melbourne/eats/test/hamcrest-core-1.3.jar org.junit.runner.JUnitCore melbourne.eats.test.OrderTest
java -cp .;melbourne/eats/test/junit-4.13.1.jar;melbourne/eats/test/hamcrest-core-1.3.jar org.junit.runner.JUnitCore melbourne.eats.test.ProviderTest
```

## References

Baao, 2022. Java RegEx split method. [online] Stack Overflow. Available at: <https://stackoverflow.com/questions/40688462/java-regex-split-method> [Accessed 13 March 2022].

Bajpai, V., 2022. Split() String method in Java with examples - GeeksforGeeks. [online] GeeksforGeeks. Available at: <https://www.geeksforgeeks.org/split-string-java-examples/> [Accessed 11 March 2022].

Baydan, İ., 2022. How To Add New Line In Markdown? – WiseTut. [online] Wisetut.com. Available at: <https://wisetut.com/how-to-add-new-line-in-markdown/> [Accessed 31 March 2022].

Chauhan, K., 2022. Split using a bracket. [online] Stack Overflow. Available at: <https://stackoverflow.com/questions/8141698/split-using-a-bracket> [Accessed 13 March 2022].

EDUCBA. 2022. Associative Array in Java | Know How to Create Associative Array in Java?. [online] Available at: <https://www.educba.com/associative-array-in-java/> [Accessed 6 March 2022].

Frieze, A., 2022. How to Access an Iteration Counter in a For Each Loop. [online] www.baeldung.com. Available at: <https://www.baeldung.com/java-foreach-counter> [Accessed 7 March 2022].

Gamlath, B., 2022. Read a file and split lines in Java.. [online] Stack Overflow. Available at: <https://stackoverflow.com/questions/20841980/read-a-file-and-split-lines-in-java> [Accessed 13 March 2022].

isvforall, 2022. How to put/get values into/from Nested HashMap. [online] Stack Overflow. Available at: <https://stackoverflow.com/questions/14582596/how-to-put-get-values-into-from-nested-hashmap> [Accessed 30 March 2022].

Jin, Q. and Saucier, Z., 2022. Write to text file without overwriting in Java. [online] Stack Overflow. Available at: <https://stackoverflow.com/questions/9961292/write-to-text-file-without-overwriting-in-java> [Accessed 13 March 2022].

Jon, 2022. How to quit a java app from within the program. [online] Stack Overflow. Available at: <https://stackoverflow.com/questions/2670956/how-to-quit-a-java-app-from-within-the-program> [Accessed 8 March 2022].

Kail, B., 2022. Iterate through nested hashmap. [online] Stack Overflow. Available at: <https://stackoverflow.com/questions/26188532/iterate-through-nested-hashmap> [Accessed 30 March 2022].

Kuhn, L., 2022. Java: how to convert HashMap<String, Object> to array. [online] Stack Overflow. Available at: <https://stackoverflow.com/questions/1090556/java-how-to-convert-hashmapstring-object-to-array> [Accessed 13 March 2022].

Kumar, P., 2022. Different ways of Reading a text file in Java - GeeksforGeeks. [online] GeeksforGeeks. Available at: <https://www.geeksforgeeks.org/different-ways-reading-text-file-java/> [Accessed 13 March 2022].

MakeInJava Tutorials. 2022. Remove null / empty element or objects from array - lambda stream java8. [online] Available at: <https://makeinjava.com/remove-null-empty-string-array-lambda-stream-java8-example/> [Accessed 13 March 2022].

Markdownguide.org. 2022. Markdown Cheat Sheet | Markdown Guide. [online] Available at: <https://www.markdownguide.org/cheat-sheet> [Accessed 31 March 2022].

Mkyong, 2022. Java – Display double in 2 decimal places. [online] Mkyong.com. Available at: <https://mkyong.com/java/java-display-double-in-2-decimal-points/> [Accessed 10 March 2022].

Noodles, P., 2022. The String.split() method in Java: splitting a string into parts. [online] Codegym.cc. Available at: <https://codegym.cc/groups/posts/stringsplit-method-in-java> [Accessed 13 March 2022].

Pasarin, L., 2022. Using multiple delimiters with scanner - Java. [online] Stack Overflow. Available at: <https://stackoverflow.com/questions/16780289/using-multiple-delimiters-with-scanner-java> [Accessed 13 March 2022].

Pedamkar, P., 2022. Iterator in Java | Retrieving Elements Using the Iterator Method. [online] EDUCBA. Available at: <https://www.educba.com/iterator-in-java/> [Accessed 13 March 2022].

Philipp, M., 2022. Getting started · junit-team/junit4 Wiki. [online] GitHub. Available at: <https://github.com/junit-team/junit4/wiki/Getting-started> [Accessed 31 March 2022].

Pietzcker, T., 2022. Escaping Parentheses in Regex. [online] Stack Overflow. Available at: <https://stackoverflow.com/questions/23659747/escaping-parentheses-in-regex> [Accessed 13 March 2022].

Rotadev.com. 2022. Java: how to convert HashMap<String, Object> to array – Dev – RotaDEV.com. [online] Available at: <https://rotadev.com/java-how-to-convert-hashmapstring-object-to-array-dev/> [Accessed 12 March 2022].

Saalam, S., 2022. HashMap Iterator. [online] Youtube.com. Available at: <https://www.youtube.com/watch?v=ISQv2lbJZoY> [Accessed 13 March 2022].

sanbhat, 2022. Ignore case for 'contains' for a string in Java. [online] Stack Overflow. Available at: <https://stackoverflow.com/questions/16604765/ignore-case-for-contains-for-a-string-in-java> [Accessed 13 March 2022].

Shar1er80, 2022. Read data from a text file and create an object. [online] Stack Overflow. Available at: <https://stackoverflow.com/questions/30564462/read-data-from-a-text-file-and-create-an-object> [Accessed 13 March 2022].

VHS, 2022. Junit Error: initializationError(org.junit.runner.JUnitCommandLineParseResult). [online] Stack Overflow. Available at: <https://stackoverflow.com/questions/42430188/junit-error-initializationerrororg-junit-runner-junitcommandlineparseresult> [Accessed 31 March 2022].

Zhao, K. and L, B., 2022. Variable is accessed within inner class. Needs to be declared final. [online] Stack Overflow. Available at: <https://stackoverflow.com/questions/14425826/variable-is-accessed-within-inner-class-needs-to-be-declared-final> [Accessed 30 March 2022].






