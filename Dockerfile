FROM openjdk:8

COPY target/*.war /usr/src/app/app.war

WORKDIR /usr/src/app

ENTRYPOINT ["java"]

CMD ["-jar", "app.war"]