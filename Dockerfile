FROM eclipse-temurin:17-jdk-focal

WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
#COPY target/architectural-0.0.1-SNAPSHOT.jar  architectural-0.0.1-SNAPSHOT.jar
#
#EXPOSE 8080
#
#ENTRYPOINT ["java", "-jar", "architectural-0.0.1-SNAPSHOT.jar"]

#RUN ./mvnw dependency:go-offline
RUN apt-get update && apt-get install -y dos2unix
RUN dos2unix ./mvnw
#RUN sudo -i
RUN ./mvnw dependency:go-offline

#RUN ./mvnw clean install package
COPY src ./src
CMD ["./mvnw", "spring-boot:run"]
