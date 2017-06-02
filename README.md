[![Codeship](https://img.shields.io/codeship/e282dd80-a21a-0134-6f6a-12490b0b4938.svg)](https://app.codeship.com/projects/189924)
[![Codacy grade](https://img.shields.io/codacy/grade/8159dd599fbd49589921d51f96059ef3.svg)](https://www.codacy.com/app/spilth/savant?utm_source=github.com&amp)

# Savant

End-user documentation can be found at <http://spilth.org/projects/savant/>

## Building from Source

If you want to build the tool from source, do the following:

```bash
$ git clone git@github.com:spilth/savant.git
$ cd savant
$ mvn package
$ alias savant="java -jar target/savant-1.0-SNAPSHOT.jar"
$ savant search hamcrest-core
```
