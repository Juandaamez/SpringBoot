# Utilizar una base de imagen oficial de Java
FROM openjdk:11-jdk-slim as builder

# Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el archivo jar de tu proyecto al directorio de trabajo en el contenedor
COPY target/demo.jar app.jar

# Ejecutar la aplicación
CMD ["java", "-Dspring.profiles.active=${SPRING_PROFILE}", "-jar", "app.jar"]
