FROM openjdk:17-jdk-alpine

EXPOSE 8080

ARG JAR_FILE=target/email-sync-0.0.1-SNAPSHOT.jar
ARG PROPERTIES_FILE=src/main/resources/application.properties
ADD ${JAR_FILE} app.jar
ADD ${PROPERTIES_FILE} application.properties

ENTRYPOINT ["java","-jar","/app.jar"]