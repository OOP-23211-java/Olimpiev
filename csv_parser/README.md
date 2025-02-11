# **Frequency Text Parser**
## **Overview**
This project is a command-line Java application that analyzes word frequencies in a given text file and outputs the results to another file in csv format. It uses **Gradle** for dependency management and build automation. The application is structured with **JUnit** for testing, **JaCoCo** for code coverage reports, and **Log4j** for logging.

## **Dependencies**
The project uses the following key libraries:
- **Guava** – Utility library from Google.
- **Apache Commons CSV** – For handling CSV file operations.
- **JCommander** – Command-line argument parser.
- **Lombok** – Reduces boilerplate code, especially for logging.
- **Log4j 2** – Logging framework.
- **JUnit 4** – Unit testing framework.

## **How to Build and Run**
### **1. Build the Project**
To build the project and generate a runnable JAR file, use:
```sh
./gradlew clean build
```
After successfully building you can find file:
```sh
app/build/libs/app.jar
```

### **2. Running the Application**
After building, you can execute the JAR file with:

```sh
java -jar app/build/libs/app.jar --input input.txt --output output.txt
```
**Command-Line Arguments**

| Option   |  Alias | Description  |
| ------------ | ------------ | ------------ |
|--input   |  -i  | Specifies the input text file.  |
|--output | -o  | Specifies the output csv file.  |
|--help    | -h  | Displays help information.   |

### **Testing the Application**
To run unit tests:

```sh
./gradlew test
```
Test reports are generated in:
```sh
app/build/reports/tests/test/index.html
```

### **Generating Code Coverage Report**
JaCoCo is configured to analyze test coverage. To generate the report, use:

```sh
./gradlew jacocoTestReport
```
The coverage report can be found in:

```sh
app/build/reports/jacoco/test/html/index.html
```

### **Generating Documentation (Javadoc)**
To generate API documentation:

```sh
./gradlew javadoc
```
The documentation will be located in:

```sh
app/build/docs/javadoc/index.html
```
To package the documentation into a JAR:

```sh
./gradlew javadocJar
```
### **Logging Configuration**
The project uses Log4j 2 for logging. Logs are printed to the console by default.
To configure the log output, update the 
```sh
app/src/main/resources/log4j2.xml
```
file.

Summary

|Task   |Command   |
| ------------ | ------------ |
|Build the project | ./gradlew clean build  |
|Run with gradle  | ./gradlew run --args='-i input.txt -o output.scv'  |
|Run the app  | java -jar app/build/libs/app.jar -i input.txt -o output.txt |
|Run tests  | ./gradlew test   |
|View test reports  | Open app/build/reports/tests/test/index.html  |
|Generate coverage  | ./gradlew jacocoTestReport  |
|Generate Javadoc  | ./gradlew javadoc  |
|Package Javadoc   | ./gradlew javadocJar  |

This README provides a quick start guide to building, testing, and running the project. 🚀
**Donates: waiting...**
