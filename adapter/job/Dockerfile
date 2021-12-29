FROM adoptopenjdk/openjdk11:alpine-slim

ENV APP_TARGET target
ENV APP udiapub-job.jar

RUN mkdir -p /opt

COPY ${APP_TARGET}/${APP} /opt
CMD ["sh", "-c", "java -jar /opt/${APP}"]