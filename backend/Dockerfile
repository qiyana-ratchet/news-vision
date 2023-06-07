FROM openjdk:17-alpine as build
WORKDIR /workspace/app

COPY gradle gradle
COPY build.gradle.kts settings.gradle.kts gradlew ./
COPY src src

RUN dos2unix gradlew #DOS(윈도우) 텍스트 파일 포맷을, 리눅스 포맷으로 변경하는 리눅스 명령어 (ex. 개행문자 등)
RUN chmod +x gradlew

RUN ./gradlew bootJar
RUN mkdir -p build/libs/dependency && (cd build/libs/dependency; jar -xf ../*.jar)
RUN mkdir /workspace/app/video

FROM openjdk:17-alpine
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/build/libs/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-cp","app:app/lib/*","com.example.newsvision.NewsVisionApplication"]