FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=CarRestApi-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]