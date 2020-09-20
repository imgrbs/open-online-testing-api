FROM maven:3.6.3-openjdk-11-slim as build
WORKDIR /app

COPY pom.xml .
COPY src/ ./src/

RUN mvn -B -DskipTests clean package -X

FROM openjdk:11.0.8-jre-slim
ARG JAR_FILE=/app/target/*.jar
COPY --from=build ${JAR_FILE} app.jar
EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "/app.jar" ]
