# KMProfessor

[🇧🇷 Portuguese Version](README.pt-BR.md)

Exam management system built with **Java 17+ (Spring Boot)**, **Angular 17+**, and **PostgreSQL**.

---

## 📚 About the Project

The goal of **KMProfessor** is to allow teachers to register exams, questions, and answer keys, with ChatGPT integration for automatic answer generation and future features for import/export.

---

## ⚙️ Technologies

- **Backend:** Java 17+ (Spring Boot)
- **Frontend:** Angular 17+
- **Database:** PostgreSQL 16 (via Docker)
- **ORM:** Spring Data JPA / Hibernate
- **Authentication:** JWT (JSON Web Token)

---

## 📌 Initial Structure

- `Professor` entity created, containing:
  - Name
  - Email (with unique index in the database)
  - Password (stored as hash)
  - OpenAI API Key (stored encrypted)
  - Creation date (`CreatedAt`)

- `Spring Data JPA Repository` implemented and configured.

- Initial `Flyway migration` applied, creating the `Professors` table in the `provas_db` database.

---

## ⚙️ Configuration

In `src/main/resources/application.properties`, configure:

```properties
server.port=8080

spring.datasource.url=jdbc:postgresql://localhost:5432/provas_db
spring.datasource.username=km
spring.datasource.password=km

jwt.secret=a-very-long-and-secret-key-with-at-least-256-bits
```

---

## 🧪 Running the Application

```bash
# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

Access the API documentation (Swagger UI) at:
🔗 http://localhost:8080/swagger-ui/index.html

---

## ✅ Migrations (Flyway)

Database migrations are managed by **Flyway** and are automatically applied on startup. To create a new migration, add a new SQL file to `src/main/resources/db/migration/` following the pattern `V<VERSION>__<DESCRIPTION>.sql`.
