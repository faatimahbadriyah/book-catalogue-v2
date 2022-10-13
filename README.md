# Syntax
## run via cli
> mvn spring-boot:run

## ways to override properties
1. via src/main/resource/application.properties
2. via cli 
> mvn spring-boot:run -Dspring-boot.run.arguments="server.port=8083"
3. via project->Run as->Run Configurations
- Spring Boot->Override Properties->server.port=8082
- Arguments->Program arguments->--server.port=8083
- Arguments->VM arguments->-Dserver.port=8084

## ways to set up properties
1. add from environment variables OS (need restart)
2. add from Run Configurations -> Environtment -> add

## ways to create custom profile
1. create new file properties in src/main/resources  -> application-development.properties
2. add some override configuration->server.port=8090 for test
3. ways to set up profile:
- open Run Configurations -> Spring Boot -> Profile -> select development -> Apply -> Run
- with cli -> mvn spring-boot:run -Dspring-boot.run.profiles=development

## ways to run jar project
Run on your cli
1. mvn clean package
2. cd target
3. dir (to see details)
4. a. java -jar book-catalogue-v2-0.0.1-SNAPSHOT.jar --spring.profiles.active=development (program argument)  
   b. java -jar -Dspring.profiles.active=development book-catalogue-v2-0.0.1-SNAPSHOT.jar