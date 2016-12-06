# Savant

A command-line tool to easily search Maven Central and get the `<dependency>` entries for your `pom.xml`.

## Getting Started

```bash
$ git clone git@github.com:spilth/savant.git
$ cd savant
$ mvn package
$ alias savant="java -jar target/savant-1.0-SNAPSHOT.jar"
$ savant hamcrest-core
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
```