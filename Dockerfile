FROM openjdk:11
EXPOSE 8080
ADD target/apirest-0.0.1-SNAPSHOT.jar docker-app.jar
ENTRYPOINT ["java", "-jar", "/docker-app.jar"]