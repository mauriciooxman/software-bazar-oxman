# Usamos una imagen base con Java 17 (coincide con tu pom.xml)
FROM openjdk:17-jdk-slim

# Definimos el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos el jar generado en el paso anterior al contenedor
COPY target/bazar_todo_code-0.0.1-SNAPSHOT.jar app.jar

# Exponemos el puerto 8080
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]