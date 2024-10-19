# Usar a imagem base do OpenJDK 21
FROM azul/zulu-openjdk-alpine:21.0.2

# Instalar Maven dentro do container
RUN apk add --no-cache maven

# Definir o diretório de trabalho no container
WORKDIR /app

# Copiar o arquivo pom.xml e as dependências primeiro para aproveitar o cache do Docker
COPY pom.xml .

# Baixar as dependências do Maven (isso será cacheado pelo Docker se o pom.xml não mudar)
RUN mvn dependency:go-offline

# Copiar o código fonte para o container
COPY src ./src

# Rodar o Maven para construir o projeto
RUN mvn clean package

# Copiar o JAR gerado para o diretório de trabalho do container
COPY target/questions-0.0.1-SNAPSHOT.jar /app/questions.jar

# Expor a porta que a aplicação usará
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "/app/questions.jar"]
