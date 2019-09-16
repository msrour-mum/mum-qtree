FROM openjdk:8
ADD target/qtree.jar  qtree.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "qtree.jar"]