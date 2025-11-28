## JavaAssignment — Product Management REST API

This project is a Spring Boot REST API for managing products.
It supports creating, updating, retrieving, listing, and deleting products, with proper validation and structured API responses.

## Features

Create a new product

Update an existing product

Get product by ID

Get list of all products

Delete a product

Centralized API responses

Custom exceptions

Validation using Jakarta Validation (@Valid)

MySQL database integration

Clean layered architecture (Controller → Service → Repository)

## Project Structure
```bash
JavaAssignment
 ├── src/main/java/com/sarvika/java/assignment
 │    ├── config
 │    │    ├── ApiResponse.java
 │    │    └── SwaggerConfig.java
 │    ├── controller
 │    │    └── ProductController.java
 │    ├── entity
 │    │    └── ProductEntity.java
 │    ├── exception
 │    │    └── ProductException.java
 │    ├── model
 │    │    ├── ResquestModel.java
 │    │    └── ResponseModel.java
 │    ├── repository
 │    │    └── ProductRepository.java
 │    └── service
 │         └── ProductService.java
 ├── src/main/resources
 │    └── application.properties
 └── pom.xml
```
## Technologies Used

Java 17+

Spring Boot

Spring Web

Spring Data JPA

Hibernate

MySQL

Swagger / OpenAPI

## How to Run the Project
1️⃣ Clone the repository
git clone https://github.com/Arbaazshirani/Sarvika.git
cd JavaAssignment

## Configure MySQL

Create the schema:

CREATE DATABASE sarvika_assignment;


### Update application.properties if needed:

spring.datasource.url=jdbc:mysql://localhost:3306/sarvika_assignment?useSSL=false

spring.datasource.username=root

spring.datasource.password=pass@1234

spring.jpa.hibernate.ddl-auto=update

## Run the application

Using Maven:

mvn spring-boot:run


OR run from your IDE.

Server runs on:

http://localhost:8081

## API Endpoints
➤ Create Product
POST /api/products/create

➤ Update Product
PUT /api/products/{id}/update

➤ Get Product by ID
GET /api/products/{id}/getById

➤ Get All Products
GET /api/products/getProductList

➤ Delete Product
DELETE /api/products/{id}/delete

## Request Model (JSON)

ResquestModel
```bash
{
  "name": "Laptop",
  "description": "High performance",
  "price": 50000
}
```
## API Response Format

All responses follow a unified structure:
```bash
{
 "status": 200,
 "message": "Product updated",
 "data": {
    "id": 1,
    "name": "Laptop",
    "description": "High performance",
    "price": 50000
  }
}
```
## Common Validations

Price must be greater than 0

Name cannot be empty

RequestModel is validated using @Valid

## Swagger Documentation

Once the project is running, access Swagger UI:

http://localhost:8081/swagger-ui/index.html
