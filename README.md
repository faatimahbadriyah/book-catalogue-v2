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
1. create file -> application-development.properties
2. add some override configuration->server.port=8090
3. open Run Configurations -> Spring Boot -> Profile -> select development -> Apply -> Run