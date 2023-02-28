FROM  amazoncorreto:17-alpine-jdk
MAINTAINER  LGC
COPY  target/ArgProg-0.0.1-SNAPSHOT.jar  lgc-app.jar
ENTRYPOINT ["java","-jar","/lgc-app.jar"]