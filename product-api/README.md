# Product Catalog REST API — Java Spring Boot

A backend **REST API** built with Java and Spring Boot, featuring full CRUD operations,
relational database integration with MySQL, and structured JSON responses.
Demonstrates OOP principles, service-layer architecture, and API design aligned with
enterprise engineering standards.

---

## Tech Stack

| Layer       | Technology                         |
|-------------|-------------------------------------|
| Language    | Java 17                             |
| Framework   | Spring Boot 3                       |
| Persistence | Spring Data JPA + Hibernate         |
| Database    | MySQL                               |
| Build       | Maven                               |
| Validation  | Jakarta Bean Validation             |
| Testing     | JUnit 5 / Spring Boot Test          |

---

## Features

- Full CRUD endpoints for Product resources
- Layered architecture: Controller → Service → Repository → DB
- DTO pattern — API payloads are decoupled from JPA entities
- Bean validation on request bodies (`@NotBlank`, `@Positive`, etc.)
- Global exception handling (`@RestControllerAdvice`) with consistent JSON error responses
- Auto-timestamp tracking (`createdAt`, `updatedAt`) via JPA lifecycle hooks

---

## Project Structure

```
src/main/java/com/yourname/productapi
 ├─ controller
 │   └─ ProductController.java
 ├─ service
 │   ├─ ProductService.java
 │   └─ impl
 │       └─ ProductServiceImpl.java
 ├─ repository
 │   └─ ProductRepository.java
 ├─ model
 │   └─ entity
 │       └─ Product.java
 ├─ dto
 │   ├─ ProductRequest.java
 │   └─ ProductResponse.java
 ├─ exception
 │   ├─ ResourceNotFoundException.java
 │   └─ GlobalExceptionHandler.java
 └─ ProductApiApplication.java
```

---

## Getting Started

### Prerequisites

- Java 17+
- Maven 3.8+
- MySQL server running locally

### 1. Create the database

```sql
CREATE DATABASE product_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

### 2. Update credentials

Edit `src/main/resources/application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/product_db?useSSL=false&serverTimezone=UTC
    username: root
    password: your_password
```

### 3. Build and run

```bash
mvn clean install
mvn spring-boot:run
```

API available at: `http://localhost:8080`

---

## API Endpoints

Base path: `/api/v1/products`

| Method | Endpoint                  | Description            | Status Code |
|--------|---------------------------|------------------------|-------------|
| POST   | `/api/v1/products`        | Create a new product   | 201 Created |
| GET    | `/api/v1/products`        | Get all products       | 200 OK      |
| GET    | `/api/v1/products/{id}`   | Get product by ID      | 200 OK      |
| PUT    | `/api/v1/products/{id}`   | Update product by ID   | 200 OK      |
| DELETE | `/api/v1/products/{id}`   | Delete product by ID   | 204 No Content |

---

## Sample Request & Response

### POST `/api/v1/products`

**Request**
```json
{
  "name": "Logitech MX Master 3S",
  "description": "Wireless ergonomic mouse",
  "price": 129.99
}
```

**Response 201**
```json
{
  "id": 1,
  "name": "Logitech MX Master 3S",
  "description": "Wireless ergonomic mouse",
  "price": 129.99,
  "createdAt": "2026-03-23T20:30:00",
  "updatedAt": "2026-03-23T20:30:00"
}
```

### Error — 404 Not Found

```json
{
  "timestamp": "2026-03-23T20:35:00",
  "status": 404,
  "message": "Product not found with id: 99"
}
```

### Error — 400 Validation Failed

```json
{
  "timestamp": "2026-03-23T20:35:00",
  "status": 400,
  "message": "Validation failed",
  "errors": [
    "name: Name must not be blank",
    "price: Price must be positive"
  ]
}
```

---

## Future Enhancements

- Pagination and sorting (`Pageable`)
- JWT Authentication (Spring Security)
- OpenAPI / Swagger UI documentation
- Docker Compose setup (API + MySQL)
- Search endpoint using `findByNameContainingIgnoreCase`

---

## Author

Built by [Your Name](https://github.com/pahetraj) as a portfolio project demonstrating
Java backend development with enterprise-grade patterns.
