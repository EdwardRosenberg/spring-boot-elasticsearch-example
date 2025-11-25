# Copilot Instructions for spring-boot-elasticsearch-example

## Project Overview

This is a Spring Boot application demonstrating integration with Elasticsearch using Spring Data Elasticsearch. It provides a RESTful API for managing user data stored in Elasticsearch.

## Technology Stack

- **Java 21** - Required JDK version
- **Spring Boot 4.0.0** - Application framework
- **Spring Data Elasticsearch** - Elasticsearch integration
- **Maven** - Build and dependency management
- **Lombok** - Boilerplate code reduction (optional dependency)
- **Docker** - Containerization support

## Project Structure

```
src/
├── main/
│   ├── java/example/
│   │   ├── Application.java          # Spring Boot entry point
│   │   ├── Config.java               # Elasticsearch configuration
│   │   ├── controller/               # REST controllers
│   │   ├── model/                    # Domain entities
│   │   └── repository/               # Elasticsearch repositories
│   └── resources/
│       └── application.properties    # Application configuration
└── test/
    └── java/example/                 # Test classes
```

## Build and Test Commands

- **Build the project**: `mvn clean package`
- **Run tests**: `mvn test`
- **Run the application**: `mvn spring-boot:run`
- **Build Docker image**: `docker build -t es-example .`
- **Run Docker container**: `docker run -p 8080:8080 es-example`

## Coding Conventions

### General
- Use Java 21 features where appropriate
- Follow standard Spring Boot project structure
- Use Spring Data repositories for data access

### Naming Conventions
- Package names: lowercase (e.g., `example.controller`)
- Class names: PascalCase (e.g., `UserController`)
- Method names: camelCase (e.g., `findByFirstName`)
- Constants: UPPER_SNAKE_CASE

### REST API Patterns
- Controllers use `@RestController` annotation
- Use `@RequestMapping` for base path and HTTP method annotations (`@GetMapping`, `@PostMapping`, etc.) for endpoints
- Prefer constructor injection for dependencies (improves testability and makes dependencies explicit)

### Elasticsearch Entities
- Annotate entities with `@Document` specifying the index name
- Use `@Id` for the document identifier
- Use `@Field` with appropriate `FieldType` for field mappings

### Repository Pattern
- Extend `ElasticsearchRepository<Entity, IdType>` for repositories
- Use Spring Data query derivation for simple queries

## Configuration

The application connects to Elasticsearch via the configuration in `application.properties`:
- Default Elasticsearch URI: `http://localhost:9200`

## Testing Guidelines

- Tests are located in `src/test/java/example/`
- Use JUnit 5 for testing
- Basic tests should not require a running Elasticsearch instance
- Integration tests may require Elasticsearch to be available
