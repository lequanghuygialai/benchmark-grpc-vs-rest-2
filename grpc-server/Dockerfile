FROM openjdk:11.0.15-jre-slim
LABEL maintainer=huyle
WORKDIR /app
COPY libs libs/
COPY classes classes/
ENTRYPOINT ["java", "-cp", "/app/resources:/app/classes:/app/libs/*", "com.example.GrpcServerMainApplication"]
EXPOSE 50051