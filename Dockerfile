FROM openjdk:8-jdk-alpine
EXPOSE 83/tcp
EXPOSE 83/udp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]