FROM openjdk:11-slim-bullseye as builder
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY src ./src
RUN apt-get update && apt-get install dos2unix && dos2unix mvnw
RUN ./mvnw clean package -DskipTests

FROM openjdk:11-jre-slim-bullseye
RUN addgroup --system spring && useradd --system -g spring spring
USER spring:spring
COPY --from=builder /app/target/*.jar application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]
