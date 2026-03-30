Order Management System

A Spring Boot-based Order Management System that provides REST APIs to manage orders with support for pagination, sorting, filtering, validation, and API documentation using Swagger.

Tech Stack :
------------
Java: 21
Spring Boot: 3.5.12
Database: MySQL
Build Tool: Maven

Features
----------
* RESTful API design
* Layered Architecture (Controller, Service, Repository)
* DTO Pattern
-> OrderRequestDTO
-> OrderResponseDTO
* Manual Mapping
* Input Validation
* Global Exception Handling
* Pagination
* Sorting
* Filtering
* Swagger API Documentation

Project Structure
  ----------------
ordermanagement
│── controller
│── service
│── repository
│── dto
│── entity
│── exception
│── mapper

API Base URL
------------
http://localhost:3005/api/v1/orders

API Endpoints :
-----------------
Method	Endpoint	Description : 

GET	/	Get all orders (with pagination, sorting)
GET	/filter	Filter orders
GET	/{id}	Get order by ID
POST	/	Create new order
PUT	/{id}	Update order
DELETE	/{id}	Delete order

Order Fields
--------------
{
  "id": 1,
  "productName": "Laptop",
  "price": 50000,
  "status": "PLACED",
  "quantity": 2
}

Swagger Documentation
-----------------------
Access API docs at:

http://localhost:3005/swagger-ui/index.html

Exception Handling 
----------------------
Centralized using Global Exception Handler
Returns structured error responses

Architecture
--------------
Controller Layer → Handles HTTP requests
Service Layer → Business logic
Repository Layer → Database interaction
DTO Layer → Data transfer
Mapper → Manual conversion between Entity and DTO

Future Enhancements
-----------------------
Add authentication (JWT)
Microservices architecture

How to Run
------------
1. Clone the repository
git clone <your-repo-url>
2. Navigate to project
cd customermanagement
3. Configure MySQL in application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_db
spring.datasource.username=your_username
spring.datasource.password=your_password
4. Run the application
mvn spring-boot:run
5. Server runs on
http://localhost:3005

Author
----------
MUNI BALAJI N
