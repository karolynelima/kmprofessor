# KMProfessor

[🇧🇷 Portuguese Version](README.pt-br.md)

Exam management system built with **Java 17+ (Spring Boot)**, **Angular 17+**, and **PostgreSQL**.

---

## 📚 About the Project

The goal of **KMProfessor** is to allow teachers to register exams, questions, and answer keys, with AI integration for automatic answer generation and future features for import/export.

---

## ⚙️ Technologies

- **Backend:** Java 17+ (Spring Boot)
- **Frontend:** Angular 17+
- **Database:** PostgreSQL 16 (via Docker)
- **ORM:** Spring Data JPA / Hibernate
- **Authentication:** JWT (JSON Web Token)

---

## ✨ Implemented Features

- `Professor` entity created, containing:
  - Name
  - Email (with unique index in the database)
  - Password (stored as hash)
  - OpenAI API Key (to be stored encrypted)
  - Creation date (`CreatedAt`)

- `Spring Data JPA Repository` implemented and configured.

- JWT-based authentication with Spring Security:
  - `POST /auth/register`: Register a new professor.
  - `POST /auth/login`: Authenticate and receive a JWT.

---

## ⚙️ Configuration

The main configuration is in `src/main/resources/application.yml`. The application uses environment variables for sensitive data to enhance security, with default values for a development environment.

Create a `.env` file in the root of the project or set the following environment variables:

```
# Database password (default is 'km')
DB_PASSWORD=your_postgres_password

# JWT secret for token signing (must be a long and secure string)
JWT_SECRET=a-very-long-and-secret-key-with-at-least-256-bits

# AI Provider API Keys (optional for now)
OPENAI_API_KEY=your_openai_api_key
OPENROUTER_API_KEY=your_openrouter_api_key
DEEPSEEK_API_KEY=your_deepseek_api_key
```

---

## 🧪 Running the Application


1. Set up the Database:

Make sure you have a PostgreSQL instance running and that the provas_db database exists. You can use Docker for this:

````
docker run --name kmprofessor-db -e POSTGRES_USER=km -e POSTGRES_PASSWORD=km -e POSTGRES_DB=provas_db -p 5432:5432 -d postgres:16
````

2. Build and Run:
### Build the project
```
mvn clean install
```

### Run the application
```
mvn spring-boot:run
```

3. Access the API documentation (Swagger UI) at:
🔗 http://localhost:8080/swagger-ui/index.html

The application will be available at http://localhost:8080.

---

## ✅ Migrations (Flyway)

- Database migrations are managed by Flyway and are automatically applied on startup.
- To create a new migration, add a new SQL file to src/main/resources/db/migration/ following the pattern V<VERSION>__<DESCRIPTION>.sql.
- Database migrations are managed by Flyway. They are located in src/main/resources/db/migration/.

Note: In the current application.yml, Flyway is disabled (flyway.enabled: false). To have migrations run automatically on startup, change this property to true. 

---

## 🚀 Next Steps
- Encrypt and save the OpenAI API Key upon user registration. 
- Create endpoints for managing exams and questions. 
- Integrate with an AI service (like OpenAI/OpenRouter) for automatic answer generation. - Implement exam export to PDF/Word formats.
