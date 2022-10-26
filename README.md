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
   
## ways to install lombok
1. download lombok at https://projectlombok.org/download
2. install jar with specify path SpringToolSuite IDE
3. check installed lombok on Help -> About Spring Tool Suite

## ways to add lombok into project
1. right click project -> Spring -> Add Starters
2. type on Available
3. check add on
4. hit Next 
5. check pom.xml
6. hit Finish

## ways to create user db
1. open dbeaver
2. choose connection 
3. right click on Roles
4. Create New Role
5. fill Username and Password
6. adjust properties
7. save
8. edit connection
9. update Authentication with current credential
10. Test Connection
11. OK

## ways to connect db from cli
1. make sure path postgre has been added to system variables
2. open cli
3. type 
> psql -U {username} -d {database}
4. fill password
5. type \? for doc syntax