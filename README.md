# NaviCodingAssessment
Gradle version used in this project
gradle -v
Gradle version: 5.1

Java version used in this project 
java --version
openjdk version "1.8.0_312"

Commands to build new jar and run with input file
1. gradle clean build
2. java -jar {jar location} {input file location}
   1. e.g java -jar build/libs/geektrust.jar ~/input.txt

Note: If FileNotFound exception came or array out of bound exception came then it means file is not loaded or argument is not passed
Note: 1 argument is required to pass which should be input file