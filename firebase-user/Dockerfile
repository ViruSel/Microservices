FROM openjdk:17
ARG JAR_FILE=target/*.jar
WORKDIR /home/app/
COPY serviceAccountKey.json serviceAccountKey.json
COPY target/firebase-user-1.jar firebase-user.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/home/app/firebase-user.jar"]