# layrry_test
A plugin based application with multi-modules :
- launcher
- rest-api-module
- provider-api-module
- plugin-module

## Modules info
### launcher
The main module to run the project. 
#### Contents
    - Include the application launcher and the layyry configuration file layers.yml

### rest-api-module
The REST API module based on spring boot, spring web and spring data

### provider-api-module
Theis Service Provider Interfaces (SPI) provides services definition module for plugins.

### plugin-module
plugin sql service provider module: the plug-in that handle sql data source. We use H2 for demo.


## Technologies
* Java 11
* Spring Boot 2.4.1
* [Layrry](https://github.com/moditect/layrry) : 1.0.0.Alpha1

## How to build and test project

Build project (without tests)
```bash
mvn clean install -DskipTests=true
```

plugin is installed in layrry-demo/launcher/target/layrry-demo/plugin

Run launcher jar from it build directory
```bash
    cd launcher/target
    java -jar launcher-0.0.1-SNAPSHOT.jar
```
