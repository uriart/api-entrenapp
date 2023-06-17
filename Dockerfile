FROM openjdk:11
EXPOSE 8080

COPY ./build/libs/api-train-program-0.0.1-SNAPSHOT.jar /usr/app/api-train-program.jar
WORKDIR /usr/app

ENTRYPOINT ["java", "-jar", "api-train-program.jar"]