#EL ARCHIVO DEL <AVEN O PROYECTO SE LLAMADA build
FROM maven:3.8.2-jdk-11 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM openjdk:11-jdk-slim
                 #TARGET DEL ARCHIVO PRIMERO GENERARLO CON EL MAVEN
COPY --from=build /target/MyWallet-0.0.1-SNAPSHOT.jar demo.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]
