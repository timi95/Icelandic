# ICELANDIC ( PROBABLY GONNA USE THIS PROJECT STRUCTURE FOR SOMETHING ELSE LATER THO)


## Default Tomcat Development server

Run `mvn spring-boot:run` to build and run the program. 
When the console displays: (JVM running for 4.719), then it's ready to recieve http requests.

Go to your browser.
Navigate to `http://localhost:8080/swagger-ui.html` to call endpoints. 
Navigate to `http://localhost:8080/h2-console` to view the in-memory DB. 
JDBC URL can be found in application.properties

The app will automatically reload if you change any of the source files, this is thanks to the dev-tools import for spring.

## Testing
Run `mvn clean package` or `mvn clean install` to run spring-boots' test file. 
