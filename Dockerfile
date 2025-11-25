FROM maven:3.9-eclipse-temurin-17

WORKDIR /es-example

ADD . /es-example

RUN useradd -ms /bin/bash newuser

RUN chown -R newuser /es-example

USER newuser

RUN mvn clean install -DskipTests

# expose port for rest interface
EXPOSE 8080

# provide entry-point
CMD ["/bin/bash", "./entry-point.sh"]