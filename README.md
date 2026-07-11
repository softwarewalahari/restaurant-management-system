# 🍽️ Restaurant Management System

A Spring Boot REST API project for managing restaurant information. This application provides complete CRUD operations, search functionality, pagination, sorting, validation, exception handling, and interactive API documentation using Swagger UI.

---

## 🚀 Features

- Add a Restaurant
- Get All Restaurants
- Get Restaurant by ID
- Update Restaurant Details
- Delete Restaurant
- Search Restaurants by Name
- Search Restaurants by Address
- Search Restaurants by Owner Name
- Pagination & Sorting
- DTO Pattern
- Exception Handling
- Request Validation
- Swagger API Documentation

---

## 🛠️ Tech Stack

- Java 21
- Spring Boot 3
- Spring Data JPA (Hibernate)
- MySQL
- Maven
- Swagger (OpenAPI)
- Lombok
- Git & GitHub

---

## 📂 Project Structure

```
src
├── controller
├── service
│   ├── RestaurantService
│   └── impl
├── repository
├── entity
├── dto
├── util
├── exception
└── resources
```

---

## 🏗️ Architecture

```
Client
   │
   ▼
Controller
   │
   ▼
Service
   │
   ▼
Repository
   │
   ▼
MySQL Database
```

---

## 📌 REST API Endpoints

### Restaurant CRUD APIs

| Method | Endpoint | Description |
|----------|-------------------------|------------------------|
| POST | /restaurants | Add Restaurant |
| GET | /restaurants | Get All Restaurants |
| GET | /restaurants/{id} | Get Restaurant By ID |
| PUT | /restaurants/{id} | Update Restaurant |
| DELETE | /restaurants/{id} | Delete Restaurant |

---

### Search APIs

| Method | Endpoint |
|----------|----------------------------|
| GET | /restaurants/search?name=ABC |
| GET | /restaurants/search/address?address=Hyderabad |
| GET | /restaurants/search/owner?ownerName=Hari |

---

### Pagination & Sorting

| Method | Endpoint |
|----------|------------------------------------------------|
| GET | /restaurants/page?page=0&size=5&sortBy=name |

Example

```
GET /restaurants/page?page=0&size=5&sortBy=id
```

---

## 📖 Swagger Documentation

After running the application, open:

```
http://localhost:8080/swagger-ui/index.html
```

Swagger provides interactive API documentation where all endpoints can be tested.

---

## ⚙️ How to Run

### Clone Repository

```bash
git clone https://github.com/softwarewalahari/restaurant-management-system.git
```

### Navigate to Project

```bash
cd restaurant-management-system
```

### Configure Database

Update `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/restaurantdb
spring.datasource.username=root
spring.datasource.password=your_password
```

---

### Run Application

```bash
mvn spring-boot:run
```

OR

```bash
mvn clean package
java -jar target/restaurant-0.0.1-SNAPSHOT.jar
```

---

## ✅ Validation

The project validates incoming requests using Jakarta Bean Validation.

Examples:

- Restaurant Name cannot be empty
- Address cannot be empty
- Phone number cannot be empty
- Owner Name cannot be empty

Invalid requests return HTTP 400 (Bad Request).

---

## 🚨 Exception Handling

Global exception handling is implemented using `@ControllerAdvice`.

Example:

```
Restaurant not found with id : 100
```

Returns

```
HTTP 404 Not Found
```

---

## 📊 Project Highlights

- Layered Architecture
- DTO Pattern
- RESTful API Design
- Global Exception Handling
- Request Validation
- Search Functionality
- Pagination & Sorting
- Swagger Documentation
- Maven Build
- Git Version Control

---

## 👩‍💻 Author

**Haritha Yadav**

GitHub:
https://github.com/softwarewalahari

---

## ⭐ Future Enhancements

- JWT Authentication
- Spring Security
- Role Based Authorization
- Docker Support
- Unit Testing (JUnit & Mockito)
- Cloud Deployment (Render)
- CI/CD Integration
