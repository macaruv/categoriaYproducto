# Usa una imagen base de Java
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo JAR de la aplicación en el contenedor
COPY target/APICategoriaYProducto-0.0.1-SNAPSHOT.jar /app/tu-aplicacion.jar

# Expone el puerto en el que tu aplicación se ejecuta
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "tu-aplicacion.jar"]

