# Language Tutor Web Application

A full-stack web application built with Spring Boot 3, Thymeleaf, Spring Data JPA, and PostgreSQL, and fully containerized with Docker.

## Key Features

1. **Dual-Language Audience Routing**:
   - /learn-english (Spanish interface for Spanish speakers learning English)
   - /learn-spanish (English interface for English speakers learning Spanish)
2. **Dynamic Course Catalog**: Powered by Spring Data JPA and PostgreSQL.
3. **Student Inquiry Form**: Input validation with Jakarta Bean Validation, timestamped inquiries.
4. **Admin Inquiry Dashboard**: Internal panel at /admin/inquiries listing received student requests.
5. **Docker Containerization**: Multi-stage Dockerfile and Docker Compose setup.

## Tech Stack

- Backend: Java 17, Spring Boot 3.3.x, Spring Data JPA, Jakarta Bean Validation, Lombok
- Frontend: Thymeleaf, Bootstrap 5, Bootstrap Icons
- Database: PostgreSQL 16
- Containerization: Docker, Docker Compose

## Quick Start with Docker Compose

1. Clone the repository and navigate into the folder.
2. Run: docker-compose up --build

```powershell
cd "PROJECT ROOT PATH"
docker-compose up --build -d
```

3. Access the web application:
   - Homepage: http://localhost:8080
   - Admin Panel: http://localhost:8080/admin/inquiries
   - PostgreSQL: `localhost:5432`

4. To stop it and remove containers, networks, and volumes:

```powershell
docker-compose down -v
```

## Endpoint Summary

- GET / : Root portal with language selection
- GET /learn-english : Spanish view for English lessons
- GET /learn-spanish : English view for Spanish lessons
- GET/POST /contact : Student inquiry form
- GET /admin/inquiries : Admin inquiry table view
