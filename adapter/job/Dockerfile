FROM adoptopenjdk/openjdk11:alpine-slim

ENV APP_TARGET target
ENV APP udiapub-job.jar

RUN mkdir -p /opt

COPY ${APP_TARGET}/${APP} /opt
CMD java ${JAVA_OPTS} -Xms${JAVA_XMS:-128m} -Xmx${JAVA_XMX:-1024m} -jar /opt/${APP}