FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} customer-service-1.1-RELEASE.jar
ENTRYPOINT ["java","-jar","/customer-service-1.1-RELEASE.jar"]
EXPOSE 9001