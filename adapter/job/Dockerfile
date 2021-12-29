FROM adoptopenjdk/openjdk11:alpine-slim

RUN apk update && \
    apk upgrade && \
    apk apk --no-cache add curl=7.79.1-r0

ENV APP_TARGET target
ENV APP udiapub-job.jar

RUN mkdir -p /opt

COPY ${APP_TARGET}/${APP} /opt
CMD ["sh", "-c", "java -jar /opt/${APP}"]

HEALTHCHECK --start-period=1s --interval=5s --timeout=3s --retries=3 \
            CMD curl --fail  http://localhost:8090/actuator/health || exit 1