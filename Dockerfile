# Usar a imagem base do OpenJDK 21
FROM azul/zulu-openjdk-alpine:21.0.2

# Definir o diretório de trabalho no container
WORKDIR /app

# Definir argumento para o nome do arquivo JAR
ARG JAR_FILE=target/questions-0.0.1-SNAPSHOT.jar

# Copiar o arquivo JAR usando o argumento
COPY ${JAR_FILE} /app/questions.jar

# Expor a porta que a aplicação usará
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "/app/questions.jar"]
