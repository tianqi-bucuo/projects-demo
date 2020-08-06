#！/bin/bash
nohup java -javaagent:/apps/agent/skywalking-agent.jar -Dskywalking.agent.service_name=provider -Dskywalking.collector.backend_service=101.132.178.134:11800 -jar /apps/provider.jar &

