FROM openjdk:17

COPY target/allane-leasing-contracts-restapi-0.0.1-SNAPSHOT.jar allane-leasing-contracts-restapi.jar

ENTRYPOINT ["java", "-jar", "/allane-leasing-contracts-restapi.jar"]