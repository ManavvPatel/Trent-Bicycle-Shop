# 🚲 Bicycle Shop Management System (Spring Boot + MS SQL Server)

This is a multi-tier Java-based application designed to manage core operations for a retail bicycle shop. It includes modules for managing customers, products, sales, returns, inventory, suppliers, service transactions, and user accounts with role-based access control.

Originally developed as part of a university project, this system is a follow-up to a prototype created in Microsoft Access (Project 1) and has been redesigned using Spring Boot and MS SQL Server to support a scalable, secure, and modular architecture.

---

## 📦 Technologies Used

- Java 17
- Spring Boot 3.4.4
- Spring Data JPA
- Spring Security
- MySQL 
- JDBC
- Maven
- HTML/CSS/Bootstrap (for frontend)
- Thymeleaf (optional, if views are used)

---

## 🔐 User Roles and Access

| Role     | Permissions |
|----------|-------------|
| Admin    | Full system access, user management |
| Owner    | Product, supplier, and order management |
| Employee | View/add sales, returns, customers, repairs |

Passwords are encrypted using `BCryptPasswordEncoder`.

---

## ✅ Features

- Role-based login and session management
- Manage products, customers, inventory, suppliers, and repairs
- Track sales, returns, and orders
- Encrypted user credentials
- Modular and layered backend (Model, Repository, Service, Controller)
- Database-agnostic structure: works with MS SQL and MySQL

---
