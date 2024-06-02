# Use an official Maven image to build the project
FROM maven:3.8.6-openjdk-21 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and the source code to the container
COPY pom.xml .
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged application from the build stage
COPY --from=build /app/target/printingservice-0.0.1-SNAPSHOT.jar ./app.jar

# Expose the port that the application will run on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
