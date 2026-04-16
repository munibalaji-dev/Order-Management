# Order Service

## Overview
Order Service is a Spring Boot microservice responsible for managing orders and integrating with Customer Service and Product Service using OpenFeign. It fetches customer and product details and returns a combined response.

## Features
- Create and manage orders
- Stores only customerId and productId
- Fetch order by ID
- Fetch orders by customer ID
- Pagination and sorting support
- Filtering by order status
- Integration with Customer and Product services using OpenFeign
- Aggregated response using DTO mapping

## Tech Stack
- Java 21
- Spring Boot
- Spring Data JPA
- OpenFeign
- MySQL
- Lombok
- Maven

## Base URL
http://localhost:3003/api/v3/orders

## API Endpoints

Create Order  
POST /

Get Order by ID  
GET /{id}

Get All Orders (Pagination & Sorting)  
GET /?page=0&size=10&sortBy=price&direction=asc

Get Orders by Customer ID  
GET /customer/{customerId}

Get Order Details (Integrated Response)  
GET /{id}/details

## Sample Response
```json
{
  "id": 1,
  "customer": {
    "id": 1,
    "customerName": "Ravi Kumar",
    "email": "ravi1@gmail.com",
    "phone": 9000000001,
    "address": "Hyderabad"
  },
  "product": {
    "id": 1,
    "productName": "Laptop",
    "description": "Gaming Laptop",
    "price": 70000,
    "stockQuantity": 10
  },
  "quantity": 1,
  "price": 70000,
  "orderStatus": "PLACED"
}
### Database
Dedicated **MySQL** database used only for Order Service.

### Stores:
* `customerId`
* `productId`
* `quantity`
* `price`
* `status`

### Architecture Flow
Order Service communicates with:

Customer Service (fetch customer data)
Product Service (fetch product data)

Then combines responses using DTO mapping and returns a single aggregated response.

### Testing
Tested using Postman
Important Design Decisions
No direct entity relationships between services
Loose coupling using IDs
DTO-based aggregation using Feign Client

### Future Improvements

Validate customer and product before order creation
Reduce product stock after order placement
API Gateway implementation
Service Discovery using Eureka
Unit and integration testing
