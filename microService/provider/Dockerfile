FROM basic:1.0
COPY provider-1.0-SNAPSHOT.jar /apps/provider.jar
CMD ["--server.port=8001"]
EXPOSE 8001
ENTRYPOINT ["java", "-jar", "/apps/provider.jar", "-javaagent:/apps/skywalking/agent/skywalking-agent.jar", "-Dskywalking.agent.service_name=provider"]