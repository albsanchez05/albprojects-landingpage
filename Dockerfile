# --- STAGE 1: Build ---
FROM maven:3.8.5-openjdk-17 AS build

WORKDIR /app

# Copy dependency definition
COPY pom.xml .

# Download dependencies (cached layer for faster subsequent builds)
RUN mvn dependency:go-offline

# Copy application source code
COPY src ./src

# Build executable JAR file
RUN mvn package -DskipTests


# --- STAGE 2: Run ---
FROM eclipse-temurin:17-jre

WORKDIR /app

# Expose Spring Boot's default HTTP port
EXPOSE 8080

# Copy the compiled JAR using wildcard to match your artifact version automatically
COPY --from=build /app/target/*.jar app.jar

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]