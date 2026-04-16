# Order Service

## Overview
Order Service is the core microservice responsible for managing orders and orchestrating communication between Customer Service and Product Service.

It uses OpenFeign to fetch customer and product data and returns an aggregated response.

---

## Features
- Create and manage orders
- Stores only references (customerId, productId)
- Fetch order details with full integration
- Pagination and sorting
- Filtering by order status
- Service-to-service communication using Feign Client

---

## Tech Stack
- Java 21
- Spring Boot
- Spring Data JPA
- OpenFeign
- MySQL
- Lombok
- Maven

---

## Base URL
http://localhost:3003/api/v3/orders

---

## API Endpoints

### Create Order
POST /

### Get Order by ID
GET /{id}


### Get All Orders
GET /?page=0&size=10&sortBy=price&direction=asc


### Get Orders by Customer
GET /customer/{customerId}

---

## Integrated Endpoint

### Get Order Details (Aggregated)
GET /{id}/details

### Sample Response
```json
{
  "id": 1,
  "customer": {
    "id": 1,
    "customerName": "Ravi Kumar",
    "email": "ravi1@gmail.com"
  },
  "product": {
    "id": 1,
    "productName": "Laptop",
    "price": 70000
  },
  "quantity": 1,
  "price": 70000,
  "orderStatus": "PLACED"
}
--------
Architecture :
Order Service communicates with other services using Feign:

- Fetch customer data from Customer Service
- Fetch product data from Product Service
- Combine responses into a single API response
------
Database :
Dedicated MySQL database
Stores only:
customerId
productId
order details
-------
Testing :

APIs tested using Postman
-------
Important Design Decisions :

No direct object references between services
Loose coupling using IDs
Aggregation handled at service layer
-------
Future Improvements :

Validate customer and product before order creation
Reduce product stock after order placement
API Gateway implementation
Service discovery using Eureka
Unit and integration testing
