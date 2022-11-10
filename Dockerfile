FROM openjdk:8-jre-alpine
EXPOSE 8089
ADD target/tpAchatProject-1.0-SNAPSHOT.jar tpAchatProject.jar
ENTRYPOINT ["java","-jar","/tpAchatProject.jar"]