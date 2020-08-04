FROM basic:1.0
COPY provider2-1.0-SNAPSHOT.jar /apps/provider2.jar
CMD ["--server.port=8002"]
EXPOSE 8002
ENTRYPOINT ["java", "-jar", "/apps/provider2.jar", "-javaagent:/apps/skywalking/agent/skywalking-agent.jar", "-Dskywalking.agent.service_name=provider2"]