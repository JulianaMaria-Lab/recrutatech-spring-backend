# Recrutatech Backend

This is the backend component of the Recrutatech project. It is built using the Spring framework.

## Prerequisites

- Java 8 or later
- [Maven](https://maven.apache.org/) for dependency management

## Getting Started

1. Clone the repository:

```bash
git clone https://github.com/JulianaMaria-Lab/recrutatech-spring-backend.git

```

2. Navigate to the project directory:
```bash
cd recrutatech-spring-backend
```

3. Build the project using Maven:
```bash
mvn clean install
```

4. Set up the Database:

- Ensure MariaDB is installed and running on localhost at port 3306;
- Create a database named recrutatech;
- Update the database configuration in `src/main/resources/application.properties`:

```bash
spring.datasource.url=jdbc:mariadb://localhost:3306/recrutatech
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MariaDB103Dialect
spring.jpa.hibernate.ddl-auto=update
```
5. Run the application:
```bash
mvn spring-boot:run
```

The backend will be accessible at http://localhost:8090 (`src/main/resources/application.properties` configuration).

API Endpoints
You can find the API endpoints in the controller classes. Check the `src/main/java/com/digitalwave/recrutatech/controller` directory for the relevant controllers.
