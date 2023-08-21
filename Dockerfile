FROM eclipse-temurin:17-jdk-jammy as base

WORKDIR /app
COPY ./ ./
RUN chmod +x ./gradlew
RUN ./gradlew dependencies


FROM base as build

RUN ./gradlew  \
    --info \
    --no-daemon \
    build


FROM eclipse-temurin:17-jre-jammy as production

EXPOSE 8080
COPY --from=build /app/build/libs/postcreator-0.0.1.jar /postcreator.jar
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-Xmx500M" "-jar", "/postcreator.jar"]