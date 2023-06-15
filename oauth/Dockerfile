FROM openjdk:17
ARG JAR_FILE=target/*.jar
WORKDIR /home/app/
COPY target/* .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/home/app/oauth-1.jar"]