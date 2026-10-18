FROM eclipse-temurin:25-jdk AS build

WORKDIR /app

COPY gradlew .

COPY gradle gradle/

COPY build.gradle.kts .

COPY settings.gradle.kts .

COPY src src/

RUN ./gradlew bootJar

FROM eclipse-temurin:25-jre

WORKDIR /app

COPY --from=build /app/build/libs/BingoServer-1.0.0-SNAPSHOT.jar server.jar

EXPOSE 8080

CMD ["java", "-jar", "server.jar"]