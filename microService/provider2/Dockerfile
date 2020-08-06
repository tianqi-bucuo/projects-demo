FROM basic:latest
COPY provider2-1.0-SNAPSHOT.jar /apps/provider2.jar
EXPOSE 8002
ADD start.sh /apps
RUN chmod +x /apps/start.sh && \
    echo "tail -f /dev/null" >> /apps/start.sh
ENTRYPOINT /bin/bash /apps/start.sh