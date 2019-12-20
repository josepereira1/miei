FROM ubuntu:16.04

RUN apt-get update && \
    apt-get -y upgrade && \
    apt-get -y install software-properties-common curl default-jdk && \
    curl -O http://archive.apache.org/dist/tomcat/tomcat-7/v7.0.55/bin/apache-tomcat-7.0.55.tar.gz && \
    tar xzf apache-tomcat-7.0.55.tar.gz

COPY myapps /apache-tomcat-7.0.55/webapps/

EXPOSE 8080

CMD [ "bash", "-c", "apache-tomcat-7.0.55/bin/startup.sh && tail -f apache-tomcat-7.0.55/logs/catalina.out" ]