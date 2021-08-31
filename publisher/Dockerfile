FROM maven:3.6.0-jdk-11-slim AS build
COPY . /app
RUN mvn -f /app/pom.xml clean install

FROM openjdk:11-jre-slim
COPY --from=build /app/target/publisher-0.0.1-SNAPSHOT.jar /usr/local/lib/publisher-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENV JAVA_OPTS="-Xmx256m -Xms256m"
ENTRYPOINT ["java","-jar","/usr/local/lib/publisher-0.0.1-SNAPSHOT.jar"]