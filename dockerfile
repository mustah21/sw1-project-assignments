FROM maven:3.8.1-jdk-21

LABEL authors="mustah21"

WORKDIR /app

COPY pom.xml .
COPY . /app

RUN mvn package

CMD ["java", "-jar", "target/week4-inclass-1.0-SNAPSHOT.jar"]
