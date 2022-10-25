FROM openjdk:17
EXPOSE 8081
ADD target/warehouse-service-images.jar warehouse-service-images.jar
ENTRYPOINT ["java","-jar","/warehouse-service-images.jar"]