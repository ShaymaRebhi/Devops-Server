FROM openjdk:11
EXPOSE 8089
ADD target/tpAchatProject-1.0-SNAPSHOT.jar springprojet.jar
ENTRYPOINT ["java","-jar","/springprojet.jar"]