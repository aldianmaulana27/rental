FROM openjdk:8-jdk-alpine

ADD target/rental-0.0.1-SNAPSHOT.jar /app/rental-docker.jar

EXPOSE 8081

CMD ["java", "-jar", "/app/rental-docker.jar"]
