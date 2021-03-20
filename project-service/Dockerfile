FROM openjdk:11
ADD ./target/project-service-0.0.1-SNAPSHOT.jar /usr/src/project-service-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
ENTRYPOINT ["java","-jar","project-service-0.0.1-SNAPSHOT.jar"]