FROM maven:3.6.0-jdk-11

WORKDIR /es-example

ADD . /es-example

RUN useradd -ms /bin/bash newuser

RUN chown -R newuser /es-example

USER newuser

RUN mvn clean install

# expose port for rest interface
EXPOSE 8080

# provide entry-point
CMD ["/bin/bash", "./entry-point.sh"]