FROM openjdk:21-jdk-slim

WORKDIR /app
COPY target/pricing-infrastructure-*.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
