FROM openjdk:8
ADD target/mock-war-0.0.1.jar /app/mock-war-0.0.1.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/mock-war-0.0.1.jar"]