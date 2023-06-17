FROM openjdk:11
ADD target/api-train-program-0.0.1-SNAPSHOT.jar api-train-program.jar
ENTRYPOINT ["java", "-jar", "api-train-program.jar"]