#！/bin/bash
nohup java -jar /apps/gateway.jar -javaagent:/apps/skywalking/agent/skywalking-agent.jar -Dskywalking.agent.service_name=gateway &
/bin/sh -c /apps/skywalking/bin/startup.sh
