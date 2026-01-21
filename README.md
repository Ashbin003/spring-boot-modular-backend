# Spring Boot Modular Backend

## Overview
This project is a modular Spring Boot backend application developed to demonstrate clean backend architecture and REST API development using Java and Spring Boot.

The application follows a layered architecture and is divided into multiple functional modules.

---

## Tech Stack
- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- Maven
- Swagger (SpringDoc OpenAPI)

---

## Project Structure
Each module follows the same layered structure:
- api – REST Controllers
- service – Business logic
- repository – Data access layer
- model – Entity classes
- exceptions – Centralized exception handling

---

## Modules Implemented
- Book Management
- Farm Retail Connect
- Insurance Management
- Property Management
- Transaction Management

---

## Features
- RESTful APIs
- Modular package design
- Centralized exception handling
- JPA + MySQL integration
- Swagger API documentation

---

## How to Run the Application

```bash
mvn clean install
mvn spring-boot:run
```

---

## Swagger UI:
http://localhost:8080/swagger-ui.html


---

## Author
Ashbin K George