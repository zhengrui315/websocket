# Step 1: Build Stage
# Use the Maven image to build the project, it should include basic maven command
FROM maven:3.8.1-openjdk-17-slim as builder

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven pom.xml and source code into the container
COPY pom.xml /app
COPY src /app/src

# Build the application (this will generate the JAR file)
RUN mvn clean package -DskipTests


# Step 2: Runtime Stage
# Use a lighter OpenJDK image to run the application
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the build stage to the runtime stage
COPY --from=builder /app/target/*.jar /app/app.jar

# Expose the port your Spring Boot app will run on (default 8080)
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
