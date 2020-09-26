FROM openjdk:11

WORKDIR /app

ADD ./target/testing-system-0.0.1-SNAPSHOT.jar .

CMD [ "java","-jar","testing-system-0.0.1-SNAPSHOT.jar" ]