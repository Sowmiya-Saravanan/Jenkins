FROM openjdk:17-jdk-slim
WORKDIR /apps 
COPY target/jenkindemo-0.0.1-SNAPSHOT.jar jenkindemo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "jenkindemo.jar"]