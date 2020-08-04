FROM basic:1.0
COPY gateway-1.0-SNAPSHOT.jar /apps/gateway.jar
EXPOSE 8080
EXPOSE 9000
ADD start.sh /apps
RUN chmod +x /apps/start.sh && \
    echo "tail -f /dev/null" >> skywalking/bin/startup.sh
ENTRYPOINT /bin/sh -c /apps/start.sh