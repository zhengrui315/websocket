# Use an OpenJDK image
FROM openjdk:17-jdk-slim
# FROM maven:3.6.3-jdk-8

# Set working directory
WORKDIR /app

# Copy the built JAR
COPY target/*.jar app.jar

# Expose application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]