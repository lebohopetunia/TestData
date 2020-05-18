FROM openjdk:8-jdk-alpine
ADD target/QaTestData.jar QaTestData.jar
EXPOSE 8088
ENTRYPOINT ["java","-jar","QaTestData.jar"]

#RUN cp /C:\Users\A235905\Downloads\Java Task\QaTestData\QaTestData\target
