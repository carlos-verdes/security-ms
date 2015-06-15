FROM maven

MAINTAINER snorrito

RUN echo "Evitando cache 123, home: "$HOME && cd $HOME && git clone https://github.com/snorrito/omnisession-project.git/security-ms && cd security-ms && mvn clean package spring-boot:repackage

EXPOSE 8080

CMD java -jar $HOME/security-ms/target/security-ms.jar