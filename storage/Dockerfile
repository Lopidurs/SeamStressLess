FROM maven:3.9.7-amazoncorretto-21 AS builder

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM maven:3.9.7-amazoncorretto-21

WORKDIR /app

COPY --from=builder /app/target/storage-0.0.1-SNAPSHOT.jar /app/storage.jar

ENV ANGULAR_ALLOWED_ORIGINS=http://localhost:4200 \
    DATABASE_DDL_AUTO=create \
    DATABASE_DRIVER=org.postgresql.Driver \
    DATABASE_FORMAT_SQL=true \
    DATABASE_PASSWORD=postgres \
    DATABASE_SHOW_SQL=true \
    DATABASE_URL=jdbc:postgresql://localhost:5432/seamstressless \
    DATABASE_USERNAME=postgres \
    JWT_ALGORITHM=HmacSHA256 \
    JWT_EXPIRE_AT=86400000 \
    JWT_SECRET=TFTIC_LABO_SECRET_KEY_1234567890

EXPOSE 8080

CMD ["java", "-jar", "/app/storage-service.jar"]
