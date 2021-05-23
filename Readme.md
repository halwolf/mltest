# IP Analyser

This RestApp is made for MercadoLibre Technical Test

## Prerequisites

- Docker
- Java 11
- Maven
- Spring Framework
- MongoDB
- Git

## Installation

Download the project (optional).

```bash
git clone https://github.com/halwolf/mltest.git
```

Build project to get jar

```bash
./mvnw package
```

Build project in Docker

```bash
docker build -t api-docker-image .
```

Compose project with MongoDB

```bash
docker-compose up
```

## Usage

You can use the documentation at [this link](http://localhost:3001/swagger-ui.html#/ip-analizer-controller)
