FROM eclipse-temurin:21.0.2_13-jdk-jammy
ARG JAR_FILE=target/*.jar
COPY ./target/blog-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]