FROM eclipse-temurin:17-jdk-alpine

#step 2 set the working directory inside the container
WORKDIR /app

#step 3 copy the .jar file from build folder to the container
COPY target/*.jar app.jar

#step 4, run the application
ENTRYPOINT ["java", "-jar", "app.jar"]