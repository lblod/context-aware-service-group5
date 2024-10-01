FROM eclipse-temurin:21-alpine

USER 65534

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ARG JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar app.jar" ]