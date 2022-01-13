FROM adoptopenjdk/openjdk11:alpine-jre
ADD ./target/ORM-0.0.1-SNAPSHOT.jar /app/ORM-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/app/ORM-0.0.1-SNAPSHOT.jar"]