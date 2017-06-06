[![Codeship](https://img.shields.io/codeship/e282dd80-a21a-0134-6f6a-12490b0b4938.svg)](https://app.codeship.com/projects/189924)
[![Codacy grade](https://img.shields.io/codacy/grade/8159dd599fbd49589921d51f96059ef3.svg)](https://www.codacy.com/app/spilth/savant?utm_source=github.com&amp)

# Savant

Savant is a command-line tool that aims to make working with [Maven](http://maven.apache.org) easier on macOS. It can be used to quickly initialize Java 8 Maven projects, search for dependencies and add JavaDocs to [Dash](https://kapeli.com).

End-user documentation can be found at <http://spilth.org/projects/savant/>

## Building from Source

If you want to build the tool from source, do the following:

```bash
$ git clone git@github.com:spilth/savant.git
$ cd savant
$ mvn package
$ alias savant="java -jar target/savant-1.5.1-SNAPSHOT.jar"
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
```

