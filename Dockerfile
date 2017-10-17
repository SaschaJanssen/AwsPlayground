FROM java:9-jre
MAINTAINER me

VOLUME /tmp

ADD build/libs/RockPaperScissor-1.0-SNAPSHOT.jar app.jar

ENV JAVA_OPTS=""

EXPOSE 8080

ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar