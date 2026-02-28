# spring-boot-elasticsearch-example

A Spring Boot Elasticsearch example application built with Spring Boot 4.0.1 and Java 25.

This template is derived from [template-backend-java-spring-boot](https://github.com/EdwardRosenberg/template-backend-java-spring-boot) and demonstrates Spring Data Elasticsearch integration.

## Prerequisites

- Java 25 or higher
- Maven 3.6+
- Docker (for Elasticsearch and Testcontainers)

## Building the Application

```bash
mvn clean install
```

## Running the Application

This project is dockerized:

Build:

```bash
docker build -t es-example .
```

Run:

```bash
docker run -p 8080:8080 es-example
```

## Running with Docker Compose

Start Elasticsearch 9 locally using Docker Compose:

```bash
docker-compose up -d
```

This will start an Elasticsearch 9 container on port 9200. The application is configured to connect to `http://localhost:9200` by default.

To stop Elasticsearch:

```bash
docker-compose down
```

To stop and remove all data:

```bash
docker-compose down -v
```

## Local Development with Testcontainers

This project includes Testcontainers integration for local development and testing. Testcontainers automatically provisions an Elasticsearch instance using Docker.

### Running the Application Locally

To run the application locally with a containerized Elasticsearch instance:

```bash
mvn spring-boot:test-run
```

This command uses `TestApplication` which automatically starts an Elasticsearch container.

### Running Tests

Tests use Testcontainers to spin up an Elasticsearch container:

```bash
mvn test
```

## API Documentation with Swagger

This application includes Swagger/OpenAPI specification for REST API documentation.

### Accessing Swagger UI

Once the application is running, you can access:

- **Swagger UI**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- **OpenAPI JSON**: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)
- **OpenAPI YAML**: [http://localhost:8080/v3/api-docs.yaml](http://localhost:8080/v3/api-docs.yaml)

The Swagger UI provides an interactive interface to explore and test all available REST API endpoints.

### Disabling Swagger for Production

To disable Swagger UI in production environments, add the following to your `application.properties`:

```properties
springdoc.swagger-ui.enabled=false
springdoc.api-docs.enabled=false
```

Or set it via environment variable:

```bash
export SPRINGDOC_SWAGGER_UI_ENABLED=false
export SPRINGDOC_API_DOCS_ENABLED=false
```

## Technology Stack

- **Spring Boot**: 4.0.1
- **Java**: 25
- **Build Tool**: Maven
- **Database**: Elasticsearch 9
- **Testing**: JUnit 5, Spring Boot Test, Testcontainers
- **API Documentation**: Springdoc OpenAPI 2.7.0 (Swagger UI)
- **Code Coverage**: JaCoCo

## CI/CD

This template uses GitHub Actions for continuous integration. The CI workflow automatically runs on pushes and pull requests to the `main` and `develop` branches.

The workflow:
- Builds the project using Maven (`mvn -B clean verify`)
- Runs all tests (`mvn -B test`)
- Uses Java 25 with the Temurin distribution
- Leverages a reusable workflow from [template-base](https://github.com/EdwardRosenberg/template-base)

See [`.github/workflows/ci.yml`](.github/workflows/ci.yml) for the complete configuration.

## Configuration Files

This repository includes several configuration files:

- `.editorconfig`: Defines coding styles for various file types
- `.gitignore`: Comprehensive gitignore for Java, Maven, and common IDEs
- `.github/dependabot.yml`: Automated dependency updates for GitHub Actions, Maven, and Docker
- `.github/workflows/ci.yml`: Continuous Integration workflow

## Contributing

Please see the pull request template for contribution guidelines.

## License

<!-- Add your license information here -->
