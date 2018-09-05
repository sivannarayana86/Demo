# Start with a base image containing Java runtime
FROM openjdk:8

ARG JAR_FILE 

# Add the application's jar to the container
ADD ${JAR_FILE} websocket-demo.jar

# Run the jar file 
ENTRYPOINT ["java","-jar","websocket-demo.jar"]

