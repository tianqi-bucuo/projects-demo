FROM basic:latest
COPY provider-1.0-SNAPSHOT.jar /apps/provider.jar
EXPOSE 8001
ADD start.sh /apps
RUN chmod +x /apps/start.sh && \
    echo "tail -f /dev/null" >> /apps/start.sh
ENTRYPOINT /bin/bash /apps/start.sh