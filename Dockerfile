# Use uma imagem leve do OpenJDK 17
FROM eclipse-temurin:17-jdk-alpine

# Diretório de trabalho dentro do container
WORKDIR /app

# Copia o JAR gerado pelo Maven
COPY target/ctech-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta da aplicação
EXPOSE 9099

# Comando para rodar o Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
