# 📡 Spring Kafka Messaging

A Java-based project demonstrating **Kafka messaging integration with Spring Boot**. This repository provides a simple yet powerful setup for producing and consuming messages using Apache Kafka, making it a great starting point for building event-driven applications.

---

## 📌 Features
- Kafka producer and consumer implementation
- Spring Boot integration with Kafka
- Configurable topics and message serialization
- Demonstrates asynchronous message handling
- Maven-based project structure

---

## 🛠️ Tech Stack
- **Language:** Java  
- **Framework:** Spring Boot  
- **Messaging Platform:** Apache Kafka  
- **Build Tool:** Maven  

---

## 📂 Project Structure
```
Spring-kafka-messaging/
│── .mvn/wrapper        # Maven wrapper files
│── src/                # Source code (producers, consumers, configs)
│── .gitattributes      # Git attributes configuration
│── .gitignore          # Git ignore rules
│── mvnw                # Maven wrapper script (Linux/Mac)
│── mvnw.cmd            # Maven wrapper script (Windows)
│── pom.xml             # Maven project configuration
```

---

## 🚀 Getting Started

### Prerequisites
- Java 17+  
- Maven 3.8+  
- Apache Kafka running locally or remotely  

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/erickomondi760/Spring-kafka-messaging.git
   cd Spring-kafka-messaging
   ```
2. Build the project:
   ```bash
   mvn clean install
   ```
3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

---

## ⚙️ Configuration
Update `application.properties` with your Kafka setup:
```properties
spring.kafka.bootstrap-servers=localhost:9092
spring.kafka.consumer.group-id=my-group
spring.kafka.topic.name=my-topic
```

---

## 📡 Usage

### Producing Messages
Send messages to Kafka using the producer service:
```java
kafkaTemplate.send("my-topic", "Hello Kafka!");
```

### Consuming Messages
Messages are automatically consumed by the configured listener:
```java
@KafkaListener(topics = "my-topic", groupId = "my-group")
public void listen(String message) {
    System.out.println("Received: " + message);
}
```

---

## ☁️ Deployment with Docker

### Step 1: Run Kafka with Docker Compose
Create a `docker-compose.yml` file:
```yaml
version: '3.8'
services:
  zookeeper:
    image: wurstmeister/zookeeper
    ports:
      - "2181:2181"

  kafka:
    image: wurstmeister/kafka
    ports:
      - "9092:9092"
    environment:
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://localhost:9092
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
```

Start Kafka:
```bash
docker-compose up -d
```

### Step 2: Build and Run the App in Docker
Create a `Dockerfile`:
```dockerfile
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/spring-kafka-messaging.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
```

Build and run:
```bash
docker build -t spring-kafka-messaging .
docker run -p 8080:8080 spring-kafka-messaging
```

---

## 🔄 CI/CD Setup (GitHub Actions)

Automate builds and tests with GitHub Actions:

```yaml
name: Java CI with Maven

on:
  push:
    branches: [ "main" ]
  pull_request:
    branches: [ "main" ]

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
    - name: Checkout code
      uses: actions/checkout@v3

    - name: Set up JDK 17
      uses: actions/setup-java@v3
      with:
        java-version: '17'
        distribution: 'temurin'

    - name: Build with Maven
      run: mvn clean install

    - name: Run tests
      run: mvn test
```

---

## 🤝 Contributing
Contributions are welcome!  
1. Fork the repo  
2. Create a new branch (`feature-xyz`)  
3. Commit changes  
4. Open a Pull Request  

---

## 📜 License
This project is licensed under the MIT License.
