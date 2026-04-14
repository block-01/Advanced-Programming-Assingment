# Server (Dashboard)

This directory contains the server dashboard where all data is collected and displayed.

## Dependencies

### Building (used in development)

Maven 3.0.0

### Running (used in development)

Java 21

## Building

### Dashboard

```shell
mvn -B clean package --file server/pom.xml
```

### Javadoc Generation

```shell
mvn javadoc:javadoc --file server/pom.xml
```

## Executing/running the application

### Maven

#### Development

```shell
spring-boot:run -Dspring-boot.run.profiles=dev --file server/pom.xml
```

#### Production

To run the application in production the SQL database needs to be online. To enable it please refer to [The database](#database) for instructions on how to start up the database.

```shell
spring-boot:run -Dspring-boot.run.profiles=prod --file server/pom.xml
```

### Java

```shell
java -jar server/target/Server-list-application-0.1-dev.jar
```

## Database

To build and run the database either run the `build-dashboard.sh` script in the root of the repository to build and run the frontend and database or run the command `docker compose up --build -d` in the root of the repository.
