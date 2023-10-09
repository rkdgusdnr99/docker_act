#FROM openjdk:17-oracle
#WORKDIR /app
#COPY build/libs/*.jar app.jar
#CMD ["java", "-jar", "app.jar"]

#Docker File

#jdk11 Image Start
FROM openjdk:17-jdk
#LABEL authors="Administrator"

#인자 정리 - jar
ARG JAR_FILE=build/libs/*.jar
# jar File Copy  / 파일 위치  파일명
COPY ${JAR_FILE} docker_act-0.0.1-SNAPSHOT.jar

#생략가능 - 8080 port 사용한다는 의미
EXPOSE 8080

#docker run시 실행 필수 명령어 , 처음에 있는 "top" 등의 파라미터를 지워야함! , 왜인지 모름
ENTRYPOINT ["java", "-jar", "/docker_act-0.0.1-SNAPSHOT.jar"]