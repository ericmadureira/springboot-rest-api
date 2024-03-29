# Spring Boot REST API

## Stack
- Java 17
- SpringBoot WEB
- Maven
- IntelliJ

## Commands
- `./mvnw spring-boot:run` - Runs project though Maven's SpringBoot plugin.
- `./mvnw clean` - Cleans `target` folder.
- `./mvnw test` - Compiles and run tests.
- `./mvnw package` - Compilation, testing and creation of .jar/.war files.

## Troubleshooting
### Windows
- `Error: JAVA_HOME not found in your environment.`
  - Set an user environment variable `JAVA_HOME` with value as path where Java was installed. For me, it was `C:\Program Files\Java\jdk-17`.
- `'mvnw' is not recognized as an internal or external command`
  - You can either 1. add Maven installation path to the `PATH` env variable, or 2. run the command as `./mvnw`.
- `Cannot resolve [dependency]`
  - Be it DataSource, JdbcTemplate, Log, or any other dependency, just 1. import dependency manually, or 2. Hover error on IntelliJ and choose `Import class...`.
- `“FATAL: password authentication failed for user…”`
  - Make sure you're using same password as in `docker-compose.yml`.