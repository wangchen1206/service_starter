#FROM ypzhuang/openjdk-alpine as builder
FROM gradle:4.10.2-jdk8-alpine as builder

#WORKDIR /root
#COPY gradle.properties /root/.gradle/
#COPY . /root
#RUN ./gradlew --init-script ./init.gradle build -x test

WORKDIR /home/gradle/
COPY . /home/gradle/
RUN gradle --init-script ./init.gradle build -x test

FROM ypzhuang/openjre-alpine
LABEL maintainer="zhuangyinping@gmail.com"

#COPY  --from=builder /root/build/libs/starter-0.0.1-SNAPSHOT.jar /app.jar
COPY  --from=builder /home/gradle/build/libs/starter-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
