# EntrenApp API

This is the back-end repository for EntrenApp, a web application that generates a 6-week training program based on your maximum bench press, deadlift, and squat weights.

## Getting Started

To run the EntrenApp API locally, follow these steps:

### Prerequisites

Make sure you have Java and Maven installed on your machine.

### Installation

1. Clone this repository.
2. Navigate to the `api-entrenapp` directory.
3. Define the following environment variables in your system:

   - `DATABASE_URL`: The URL of your database.
   - `JDBC_DATABASE_USERNAME`: Username for the database.
   - `JDBC_DATABASE_PASSWORD`: Password for the database.
   - `AUTHENTICATION_SERVER_URL`: URL of the authentication server.

4. Run the following commands:

```bash
mvn clean install
java -jar target/api-entrenapp.jar
```
The API will be accessible at http://localhost:8080/ by default.

### Docker
Alternatively, you can use the Dockerized image available on Docker Hub:

```bash
docker run -p 8080:8080 \
  -e DATABASE_URL=<your-database-url> \
  -e JDBC_DATABASE_USERNAME=<your-username> \
  -e JDBC_DATABASE_PASSWORD=<your-password> \
  -e AUTHENTICATION_SERVER_URL=<your-auth-server-url> \
  uriart/api-entrenapp:1.0.0
```

This will start the application in a Docker container with the specified environment variables.

### API Endpoints
You can find the api documentation on https://uriart.sytes.net/api/swagger-ui.html

### Technologies Used

  - Spring Boot
  - Maven
  - Other dependencies are listed in the pom.xml file.

