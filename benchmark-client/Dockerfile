FROM openjdk:18.0.2.1-slim
VOLUME /tmp
COPY ./build/libs/benchmark-client-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080