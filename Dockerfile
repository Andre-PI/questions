# Estágio 1: Build com Maven
FROM maven:3.8.6-openjdk-17 AS builder

# Definir o diretório de trabalho
WORKDIR /app

# Copiar o código fonte e o pom.xml para o container
COPY pom.xml .
COPY src ./src

# Rodar o Maven para construir o projeto
RUN mvn clean package

# Estágio 2: Execução com OpenJDK 21
FROM azul/zulu-openjdk-alpine:21.0.2

# Definir o diretório de trabalho no container
WORKDIR /app

# Copiar o arquivo .jar do estágio de build para o estágio final
COPY --from=builder /app/target/questions-0.0.1-SNAPSHOT.jar /app/questions.jar

# Expor a porta que a aplicação usará
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "/app/questions.jar"]
