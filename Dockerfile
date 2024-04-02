FROM eclipse-temurin:17-jdk-focal
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
#RUN ./mvnw dependency:go-offline
RUN apt-get update && apt-get install -y dos2unix
RUN dos2unix ./mvnw
#RUN sudo -i
RUN ./mvnw dependency:go-offline

#RUN ./mvnw clean install package
COPY src ./src
CMD ["./mvnw", "spring-boot:run"]
