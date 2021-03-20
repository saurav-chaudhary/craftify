#soulmate-0.0.1-SNAPSHOT.jar
#pull jdk image
FROM openjdk:11
#add/copy jar file from target to docker file system
ADD ./target/registerService-0.0.1-SNAPSHOT.jar registerService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","registerService-0.0.1-SNAPSHOT.jar"]
EXPOSE 8091
#WORKDIR usr/src
#run the jar file
#RUN wget -qO - https://www.mongodb.org/static/pgp/server-4.4.asc |  apt-key add -
#RUN apt-get install gnupg
#RUN wget -qO - https://www.mongodb.org/static/pgp/server-4.4.asc |  apt-key add -
#RUN echo "deb [ arch=amd64,arm64 ] https://repo.mongodb.org/apt/ubuntu focal/mongodb-org/4.4 multiverse" |  tee /etc/apt/sources.list.d/mongodb-org-4.4.list
#RUN  apt-get update
#RUN apt-get install -y mongodb-org
#RUN  systemctl start mongod
#RUN apt-get update
#RUN apt install maven
#RUN mvn deploy
#
#
#RUN apt-get purge mongodb-org*
#RUN  apt-get install mongodb
#RUN  apt-get install mongodb



#ENTRYPOINT ["java","-jar","app.jar"]