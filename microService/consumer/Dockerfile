FROM basic:1.0
COPY consumer-1.0-SNAPSHOT.jar /apps/consumer.jar
CMD ["--server.port=8004"]
EXPOSE 8004
ENTRYPOINT ["java", "-jar", "/apps/consumer.jar", "-javaagent:/apps/skywalking/agent/skywalking-agent.jar", "-Dskywalking.agent.service_name=consumer"]