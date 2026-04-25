FROM maven:3.8.7-eclipse-temurin-19 AS build
WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

FROM eclipse-temurin:19-jdk
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

RUN mkdir -p KeyStore
COPY KeyStore/keystore.jks KeyStore/keystore.jks

EXPOSE 444

ENTRYPOINT ["java", "-jar", "app.jar"]