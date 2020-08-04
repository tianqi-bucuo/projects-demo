FROM ubuntu

RUN apt-get -y update && \
    apt-get -y install wget && \
    apt-get -y install openjdk-8-jdk

WORKDIR /apps

ADD http://mirrors.hust.edu.cn/apache/skywalking/7.0.0/apache-skywalking-apm-7.0.0.tar.gz .

RUN tar -zxvf apache-skywalking-apm-7.0.0.tar.gz && \
    rm -f apache-skywalking-apm-7.0.0.tar.gz && \
    mv apache-skywalking-apm-bin skywalking