
This project built using Java and the following tools:
* Maven as build automation tool
* Spring Boot as server side framework
* Hibernate as ORM/JPA implementation
* H2 database used

# Application Structure

* Model: Domain model is organized under the model package and it consists of entity classes. Entities use various annotations that describe the relationships between each other. All these annotations are used by JPA in order to map entities to database tables.
* DTO:  DTO stands for Data Transfer Object and I use DTOs ,in order to decouple the model layer from the client side. 
* Mapper: Model Mapper used for convert Domain object to DTO object.
* Repository: Repositories are interfaces that are responsible for data persistance and retrieval. The repository layer is an abstraction that provides all CRUD functionality and keeps hidden the data related information from the other layers.
* Service: Service layer depends on the repository and provides separation of concern ,encapsulating all the business logic implementation. It is there to apply business rules on data sent to and from the repository layer.
* Controller: Controller layer depends on the service layer and is responsible for the incoming for the incoming requests and the outgoing responses. A controller determines all the available endpoints that client side is able to call.

* H2 is an open-source lightweight Java database. It can be embedded in Java applications or run in the client-server mode. Mainly, H2 database can be configured to run as inmemory database, which means that data will not persist on the disk. 

 # Build Project
 
 * Build application using the following maven command.
 - mvn clean install
 * This command will create an executable .jar file at target directory.
 
 * Run Project
  java -jar target/warehouse-service-0.0.1-SNAPSHOT.jar
  
  # API Documentation
 
 When server is up and running , you can use swagger to explore the available endpoints.  http://localhost:8081/swagger-ui.html#/
  
 
 

  
