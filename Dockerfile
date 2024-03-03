FROM eclipse-temurin:21.0.2_13-jdk-jammy

ENV MYSQL_HOST host.docker.internal
ENV MYSQL_USERNAME root
# ENV MYSQL_PASSWORD 19Ac74?67?
ENV MYSQL_PASSWORD Escalademroc69&

ARG JAR_FILE=target/*.jar
COPY ./target/blog-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]