FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copiamos el jar generado localmente
COPY build/libs/app.jar app.jar

# Puerto por defecto de Spring Boot
EXPOSE 8080

# Opcional pero recomendado para contenedores
ENTRYPOINT ["java", "-jar", "app.jar"]