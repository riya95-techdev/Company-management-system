
# LANOS Internals

## Project Overview

This project is my learning-based Microservices Architecture setup using:

* Java 21
* Spring Boot 3
* Spring Cloud Gateway
* Spring Security
* Keycloak
* PostgreSQL
* Docker
* Maven

The main purpose of this project is to understand how real-world backend systems and microservices work together.

This is currently a Sprint 1 foundation setup project.

---

# Sprint 1 Goal

The goal of Sprint 1 is to build the backend foundation of a microservices system.

Main focus areas:

* Microservice architecture understanding
* API Gateway setup
* JWT authentication using Keycloak
* Database connectivity
* CRUD APIs
* Shared reusable structure
* Docker local environment
* Validation and audit basics

---

# Current Project Structure

Due to learning phase and beginner-level understanding, services are currently maintained as separate projects and branches.

Current setup:

## Gateway Service

Contains:

* Spring Cloud Gateway
* Security configuration
* Route configuration
* JWT authentication setup
* Docker folder

Branch:
`main`

---

## Organization Service

Contains:

* Organization APIs
* Department APIs
* Database connection
* Controllers and service layer

Branch:
`organization`

---

## Shared Kernel

Planned reusable module for:

* Common DTOs
* API response wrapper
* Exception handling
* Audit fields
* Shared utilities

Branch:
`shared-kernel` (to be pushed)

---

# Technologies Used

| Technology           | Purpose                        |
| -------------------- | ------------------------------ |
| Java 21              | Backend language               |
| Spring Boot          | Backend framework              |
| Spring Cloud Gateway | API Gateway                    |
| Spring Security      | Authentication & Authorization |
| Keycloak             | JWT Authentication             |
| PostgreSQL           | Database                       |
| Docker               | Local development environment  |
| Maven                | Build tool                     |

---

# Learning Objectives

This project helped me learn:

* How microservices communicate
* How API Gateway works
* JWT token flow
* Keycloak authentication
* Spring Boot project structure
* REST API development
* GitHub branch management
* Database integration
* Layered architecture

---

# Current Features

## Gateway

* Public endpoint
* Protected routes
* JWT validation
* Route forwarding

## Organization Service

* Organization CRUD APIs
* Department CRUD APIs
* Database integration

---

# Planned Sprint 1 Improvements

Remaining tasks:

* Parent multi-module Maven setup
* Shared kernel integration
* Docker Compose setup
* Flyway migrations
* Validation improvements
* Audit logging
* Swagger documentation
* Better exception handling

---

# Sample Flow

1. User logs in using Keycloak
2. JWT token is generated
3. Request goes through Gateway
4. Gateway validates JWT
5. Request forwards to Organization Service
6. Data saves in PostgreSQL

---

# Important Note

This project is currently built for learning purposes.

Some architecture decisions were taken differently during the learning process, such as:

* Separate projects instead of one mono-repo
* Different GitHub branches for services

The goal was to first understand the complete flow practically before restructuring everything professionally later.

---

# Future Goals

Future planned improvements:

* Proper mono-repo structure
* Shared kernel reuse
* Redis integration
* RabbitMQ integration
* MinIO integration
* Centralized logging
* Monitoring tools
* Full production-ready architecture

---

# Author

Riya Namdev

B.Tech CSE Student
Learning Java Backend & Microservices
# Company-management-system
