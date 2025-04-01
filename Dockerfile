FROM openjdk:21
ADD target/api-*.jar api-entrenapp.jar
ENTRYPOINT ["java", "-jar", "api-entrenapp.jar"]