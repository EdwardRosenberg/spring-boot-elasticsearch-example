# spring-boot-elasticsearch-example
Connect to ElasticSearch using Spring Data and High Level Rest Client

This project is dockerized:

Build:

```docker build -t es-example .```

Run

```docker run -p 8080:8080 еs-example```

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
./mvnw spring-boot:test-run
```

This command uses `TestApplication` which automatically starts an Elasticsearch container.

### Running Tests

Tests use Testcontainers to spin up an Elasticsearch container:

```bash
./mvnw test
```

### Requirements

- Docker must be running on your machine
- Java 25 or later

## API Documentation with Swagger

This application includes Swagger/OpenAPI specification for REST API documentation.

### Accessing Swagger UI

Once the application is running (via `./mvnw spring-boot:test-run` or Docker), you can access:

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
