# Use an OpenJDK base image
FROM openjdk:11-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the application JAR file into the container
COPY /out/artifacts/order_case_jar/klm-order-case-0.1.0_.main.jar /app/order-case.jar

# Expose the port your application is listening on (change the port number if necessary)
EXPOSE 8080

# Set the command to run your application when the container starts
CMD ["java", "-jar", "order-case.jar"]
