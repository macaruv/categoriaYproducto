FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo JAR de la aplicación en el contenedor
COPY target/APICategoriaYProducto-0.0.1-SNAPSHOT.jar app.jar

# Establecer variables de entorno directamente en el Dockerfile
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/categoriayproducto
ENV SPRING_DATASOURCE_USERNAME=myuser
ENV SPRING_DATASOURCE_PASSWORD=mypassword
ENV SPRING_DATASOURCE_DRIVER_CLASS_NAME=org.postgresql.Driver

# Expone el puerto en el que tu aplicación se ejecuta
EXPOSE 8080

# Define el comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
