FROM --platform=linux/amd64 local-t9-j17
COPY  target/gpt-demo.war /usr/local/tomcat/webapps/
