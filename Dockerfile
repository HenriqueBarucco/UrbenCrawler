FROM gradle:jdk21-alpine AS build
ADD . /build
RUN cd /build && ./gradlew clean bootJar -x test

FROM eclipse-temurin:21-jdk-alpine
COPY --from=build /build/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]