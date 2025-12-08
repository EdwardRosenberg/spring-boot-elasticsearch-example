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
- Java 21 or later
