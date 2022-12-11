FROM openjdk:11
ADD target/apirest-0.0.1-SNAPSHOT.jar api-programa-powerlifting.jar
ENTRYPOINT ["java", "-jar", "api-programa-powerlifting.jar"]