# SysCtrlApp API

Backend for SysCtrlApp web app

## Requirements:
####
- Java 17 JDK
- Docker
- Gradle
- Spring Framework
- Any IDEA to start a program
####

## Useful links:
- [Spring tuturial](https://spring.io/projects/spring-boot)
- [Springdocs](https://springdoc.org/)
- [Docker](https://docs.docker.com/)
- [Gradle](https://gradle.org/)

## How to run de application:

##### Firsts steps
````
1- Start by downloading some idea for Example: (intelliJ or VsCode)
2- After downloading an idea, clone the repository to a local file
3- then just run the program in your local repository with the command below
````

##### The second step is by docker-compose:

Start by uploading a container to docker:
````bash
docker-compose up -d
```` 
This will start  the database of the api.

#### Now to run application properly saying.

running the command:
```bash
./gradlew bootrun
```

#### After the command is executed, the application will be running on the port 8080.

#### In the browser open the link bellow to acces the swagger interface:
```bash
http://localhost:8080/swagger-ui/index.html
```

### Additional Links

#### For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.4/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.4/gradle-plugin/reference/html/#build-image)

These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)
* [Idea suggestion - intelliJ](https://www.jetbrains.com/pt-br/idea/)
* [idea suggestion - VsCode](https://code.visualstudio.com/)
