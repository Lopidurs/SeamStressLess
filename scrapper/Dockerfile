FROM maven:3.9.7-amazoncorretto-21 AS builder-storage
WORKDIR /app/storage

# Copier les fichiers nécessaires pour le build
COPY ./storage/pom.xml ./
COPY ./storage/src ./src

# Compiler et installer le projet storage dans le dépôt local Maven
RUN mvn clean install -DskipTests

# Étape 2 : Compiler le projet scrapper
FROM maven:3.9.7-amazoncorretto-21  AS builder-scrapper
WORKDIR /app/scrapper

# Copier le pom.xml du projet scrapper
COPY ./scrapper/pom.xml ./

# Copier le code source du projet scrapper
COPY ./scrapper/src ./src

# Copier le dépôt local de l'étape précédente pour inclure storage
COPY --from=builder-storage /root/.m2 /root/.m2

# Compiler le projet scrapper
RUN mvn clean package -DskipTests

# Étape 3 : Construire l'image finale
FROM maven:3.9.7-amazoncorretto-21
WORKDIR /app

# Copier le fichier JAR du projet scrapper depuis l'étape précédente
COPY --from=builder-scrapper /app/scrapper/target/scrapper.jar /app/scrapper.jar

# Exposer le port sur lequel l'application tourne
EXPOSE 8080

# Démarrer l'application
CMD ["java", "-jar", "/app/scrapper.jar"]