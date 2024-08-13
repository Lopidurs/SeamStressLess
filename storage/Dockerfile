FROM maven:3.9.7-amazoncorretto-21 AS build

WORKDIR /app

ARG PROFILE=prod

COPY pom.xml .

RUN mvn clean install -DskipTests

FROM amazoncorretto:21 AS deploy

ARG DEPENDENCY=/app/controller/target

ARG JAR_NAME="controller-0.0.1-SNAPSHOT"

ARG PORT=8080

COPY --from=build ${DEPENDENCY}/${JAR_NAME}.jar app.jar

EXPOSE ${PORT}

ENTRYPOINT ["java", "-jar", "app.jar"]