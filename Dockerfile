# Stage 1: Build the application
FROM maven:3.8.5-openjdk-17 as build
COPY . .
RUN mvn clean package -DskipTests
# Stage 2: Run the application
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/MyWallet-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.jar"]
