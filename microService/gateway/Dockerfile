FROM basic:latest
COPY gateway-1.0-SNAPSHOT.jar /apps/gateway.jar
EXPOSE 9000
ADD start.sh /apps
RUN chmod +x /apps/start.sh && \
    echo "tail -f /dev/null" >> /apps/start.sh
ENTRYPOINT /bin/bash /apps/start.sh