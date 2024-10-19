FROM azul/zulu-openjdk-alpine:21.0.2


ARG JAR_FILE=target/*.jar

COPY target/questions-0.0.1-SNAPSHOT.jar questions.jar

EXPOSE 8080


ENTRYPOINT ["java", "-jar", "/questions.jar"]