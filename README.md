# 💊 Medicine E-commerce App

This project is a **backend REST API** for an e-commerce application that manages user authentication and medicine inventory. Built using **Spring Boot**, it provides secure user registration and login using **JWT tokens**, and full **CRUD operations** for managing medicines. The app is lightweight, uses an **H2 in-memory database** for quick testing, and is ideal for learning how to structure real-world Spring Boot applications.

## 🔧 Tech Stack
- Java
- Spring Boot
- Spring Data JPA
- Spring Security (JWT)
- H2 In-Memory DB
- Maven
- Postman

## 🚀 Features
- User registration
- User login (JWT token-based)
- Add a medicine
- Get all medicines
- Update medicine details
- Delete a medicine

## 🛠️ Endpoints

| Method | Endpoint                  | Description               |
|--------|---------------------------|---------------------------|
| POST   | `/api/user/register`      | Register a new user       |
| POST   | `/api/user/login`         | Login and get JWT token   |
| POST   | `/api/medicines/add`      | Add a new medicine        |
| GET    | `/api/medicines/all`      | Get all medicines         |
| PUT    | `/api/medicines/update`   | Update medicine details   |
| DELETE | `/api/medicines/delete/{id}` | Delete medicine by ID  |

---

## 🧪 Testing
Tested using [Postman](https://www.postman.com/). Use `Authorization: Bearer <token>` for protected routes after login.

---

## 🧪 API Testing (Postman)

All APIs (login, register, product CRUD) tested via **Postman**:
- Use `http://localhost:8080/api/auth/register` and `/login`
- Include JWT token in the `Authorization: Bearer <token>` header for protected routes

---

## 💾 H2 Database

To access the H2 Console:

1. Start the backend server
2. Visit: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
3. Use the following settings:
   - **JDBC URL**: `jdbc:h2:mem:testdb`
   - **Username**: `sa`
   - **Password**: *(leave blank)*

---

## 🔧 Run Locally

### Backend
```bash
cd backend
mvn spring-boot:run
