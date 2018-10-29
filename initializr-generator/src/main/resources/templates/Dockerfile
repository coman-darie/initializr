 ###########Start Dockerfile with AppDynamics integration#############
## builder image to add AppDynamics agent
#FROM debian as appd
#RUN apt-get update && apt-get install -y --no-install-recommends  unzip \
#        && rm -rf /var/lib/apt/lists/*
#
## For a more generic build file, use a build ARG for the version of the full file name
#ARG APPD_AGENT_VERSION=4.4.2.22394
#COPY AppServerAgent-${APPD_AGENT_VERSION}.zip /
#RUN unzip -oq AppServerAgent-${APPD_AGENT_VERSION}.zip -d /tmp
#
## final image
#FROM registry.misys.global.ad/ffdc-base/alpine-java:oraclejre-8
#EXPOSE 8080
#ENV SERVER_PORT 8080
#
#COPY --from=appd /tmp /opt/appdynamics
#ENV JAVA_AGENT -javaagent:/opt/appdynamics/javaagent.jar
#
#ENTRYPOINT [ "sh", "-c", \
#    "java -Djava.security.egd=file:/dev/./urandom ${APPDYNAMICS_CONTROLLER_HOST_NAME:+$JAVA_AGENT} ${APPDYNAMICS_NODE_PREFIX:+-Dappdynamics.agent.reuse.nodeName=true -Dappdynamics.agent.reuse.nodeName.prefix=$APPDYNAMICS_NODE_PREFIX} -jar /app.jar" \
#    ]
#
#ARG JAR_FILE=target/{{artifactId}}-*.jar
#ADD ${JAR_FILE} {{artifactId}}.jar
###########End Dockerfile with AppDynamics integration###############
###########Start Dockerfile without AppDynamics integration##########
FROM registry.misys.global.ad/ffdc-base/alpine-java:oraclejre-8
ARG JAR_FILE="target/{{artifactId}}-*.jar"
COPY ${JAR_FILE} {{artifactId}}.jar
EXPOSE 8080
CMD ["java", "-jar", "{{artifactId}}.jar"]
###########End Dockerfile without AppDynamics integration############