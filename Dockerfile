FROM openjdk:11
EXPOSE 8089
ADD target/tpAchatProject-1.0-SNAPSHOT.jar springproject.jar
ENTRYPOINT ["java","-jar","/springproject.jar"]