FROM openjdk:11-jdk-slim AS app-build
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN ./mvnw clean test compile assembly:single

FROM openjdk:11-jdk-slim AS app-run
COPY --from=app-build /target/recruitment-demo-0.0.1-SNAPSHOT-jar-with-dependencies.jar recruitment-demo.jar
CMD ["java","-Xmx512m","-jar","recruitment-demo.jar"]