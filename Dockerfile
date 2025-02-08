FROM openjdk:17

WORKDIR /app

COPY ./target/ecs-docker-0.0.1-SNAPSHOT.jar /app

EXPOSE 9090

CMD ["java","-jar","ecs-docker-0.0.1-SNAPSHOT.jar"]