# Imagem
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/auth-service-1.0.0.jar app.jar

EXPOSE 8080

# comandos
ENTRYPOINT ["java", "-jar", "app.jar"]
