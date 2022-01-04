FROM adoptopenjdk/openjdk11:alpine-slim

ENV APP_TARGET target
ENV APP udiapub-job.jar

# RUN apk --no-cache add curl
RUN mkdir -p /opt

COPY ${APP_TARGET}/${APP} /opt
CMD ["sh", "-c", "java -jar ${APP_ENV} /opt/${APP}"]

# HEALTHCHECK --start-period=1s --interval=5s --timeout=3s --retries=3 \
#             CMD curl --fail  http://localhost:8090/actuator/health || exit 1