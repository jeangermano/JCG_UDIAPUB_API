FROM adoptopenjdk/openjdk11:alpine-slim
RUN apk --no-cache add curl

ENV APP_TARGET target
ENV APP udiapub-job.jar

RUN mkdir -p /opt

COPY ${APP_TARGET}/${APP} /opt
CMD ["sh", "-c", "java -jar /opt/${APP}"]

HEALTHCHECK --start-period=1s --interval=5s --timeout=3s --retries=3 \
            CMD curl --fail  http://localhost:8090/actuator/health || exit 1