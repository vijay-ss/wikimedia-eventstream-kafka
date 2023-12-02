# Wikimedia Eventstream

This project ingests a real-time data stream from Wikimedia into kafka server. The data is then written to a MySQL
database.

## Technology/Tools
- Wikimedia event stream
- Apache Kafka
- Java
  - Maven build tools
  - Spring Framework
  - Spring Boot
  - Spring JPA
- Docker
- MySQL

## Methodology
1. Data Ingestion via Wikimedia url
2. Publish data Kafka topic
3. Configure Kafka consumer to write event data to local MySQL db

## Running Locally

Ensure Kafka broker is running via docker compose.
`docker-compose up`

Run Java SpringBootProducerApp using Maven to write event data to Kafka topic.

Run Java SpringBootConsumerApp using Maven to pull data from Kafka and write to MySQL database.
