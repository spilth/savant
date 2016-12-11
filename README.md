# Savant

A command-line tool to easily search Maven Central and get a `<dependency>` entry for your `pom.xml` or `compile` entry for your `build.gradle`.

## Getting Started

```bash
$ git clone git@github.com:spilth/savant.git
$ cd savant
$ mvn package
$ alias savant="java -jar target/savant-1.0-SNAPSHOT.jar"
$ savant search hamcrest-core
<dependency>
    <groupId>org.hamcrest</groupId>
    <artifactId>hamcrest-core</artifactId>
    <version>1.3</version>
</dependency>
<dependency>
    <groupId>org.ops4j.pax.tipi</groupId>
    <artifactId>org.ops4j.pax.tipi.hamcrest.core</artifactId>
    <version>1.3.0.1</version>
</dependency>
$ savant search cucumber-junit --format gradle
compile group: 'com.github.mkolisnyk', name: 'aerial-maven-cucumber-junit-archetype', version: '0.0.6.1'
compile group: 'com.github.mkolisnyk', name: 'aerial-cucumber-junit-archetype', version: '0.0.6.1'
compile group: 'info.cukes', name: 'cucumber-junit', version: '1.2.5'
```
