# Use an OpenJDK base image
FROM openjdk:17
LABEL authors="farhad.jalali"

# Set the working directory inside the container
WORKDIR /app

# Copy the application JAR file into the container
COPY /out/artifacts/klm-order-case-0.1.0_.main.jar /app/order-case.jar

# Expose the port your application is listening on
EXPOSE 8080

# Set the command to run the application
CMD ["java", "-cp", "./order-case.jar", "com.afkl.travel.exercise.Application"]
