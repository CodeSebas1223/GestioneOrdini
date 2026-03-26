FROM eclipse-temurin:17-jre 
COPY target/my-webapp.jar app.jar
ENTRYPOINT [ "java", "-jar", "/app.jar" ]