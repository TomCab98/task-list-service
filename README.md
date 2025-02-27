# 📝 Task List API

Task Manager API is a backend service built with **Spring Boot** that provides a task management system with full **CRUD
** capabilities. It follows a **Hexagonal Architecture** and is designed to work across multiple environments (*
*development, QA, and production**), leveraging **Docker** and **MySQL** for testing and **H2 in-memory database** for
local development.

![Static Badge](https://img.shields.io/badge/Spring_Boot-18-green?style=for-the-badge&logo=springboot&logoColor=green)
![Static Badge](https://img.shields.io/badge/JAVA-21-orange?style=for-the-badge)
![Static Badge](https://img.shields.io/badge/MySQL-8.0-blue?style=for-the-badge&logo=mysql&logoColor=blue)
![Static Badge](https://img.shields.io/badge/MAVEN-gray?style=for-the-badge&logo=apachemaven)
![Static Badge](https://img.shields.io/badge/DOCKER-gray?style=for-the-badge&logo=Docker)
![Static Badge](https://img.shields.io/badge/H2-gray?style=for-the-badge&logo=databricks&logoColor=white)


---

## 🚀 Technologies

| Technology  | Version |
|-------------|---------|
| Java        | 21      |
| Spring Boot | Latest  |
| MySQL       | 8.0     |
| Docker      | Latest  |
| Hibernate   | Latest  |
| JUnit       | 5       |
| Lombok      | Latest  |

---

## 📂 Project Structure

```
📦 task-list-service
 ┣ 📂 src
 ┃ ┣ 📂 main
 ┃ ┃ ┣ 📂 java
 ┃ ┃ ┃ ┣ 📂 com.projects.taskmanager
 ┃ ┃ ┃ ┃ ┣ 📂 core
 ┃ ┃ ┃ ┃ ┃ ┣ 📂 adapters (Adapters and Mappers)
 ┃ ┃ ┃ ┃ ┃ ┣ 📂 domain (Models and Bussiness Logic)
 ┃ ┃ ┃ ┃ ┃ ┣ 📂 infrastructure (APIs, Repositories and Configurations)
 ┃ ┃ ┃ ┃ ┣ 📂 tasks
 ┃ ┃ ┃ ┃ ┃ ┣ 📂 adapters
 ┃ ┃ ┃ ┃ ┃ ┣ 📂 domain
 ┃ ┃ ┃ ┃ ┃ ┣ 📂 infrastructure
 ┃ ┃ ┃ ┃ ┣ 📂 user
 ┃ ┃ ┃ ┃ ┃ ┣ 📂 adapters
 ┃ ┃ ┃ ┃ ┃ ┣ 📂 domain
 ┃ ┃ ┃ ┃ ┃ ┣ 📂 infrastructure
 ┃ ┃ ┣ 📂 resources
 ┃ ┃ ┃ ┣ 📜 application.yml
 ┃ ┃ ┃ ┣ 📜 application-dev.yml
 ┃ ┃ ┃ ┣ 📜 application-qa.yml
 ┃ ┃ ┃ ┣ 📜 application-prod.yml
 ┣ 📜 docker-compose.yml
 ┣ 📜 README.md
```

---

## 🎯 Running the Project

The API supports different environments (**dev, test, prod**). Choose the one that suits your needs.

### 🔹 Install

```sh
# Run with Maven
./mvnw clean install -DskipTests
```

---

### 🔹 Development (H2 Database)

```sh
# Run with Maven
./mvnw spring-boot:run
```

The **H2 database** runs in memory and is accessible at:

- **Console:** [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- **JDBC URL:** `jdbc:h2:mem:taskdb`

---

### 🔹 Testing (MySQL with Docker)

```sh
# Start MySQL container
docker-compose up -d

# Run the tests
./mvnw spring-boot:run -Dspring-boot.run.profiles=qa

```

- **Database URL:** `jdbc:mysql://localhost:3307/task_list_service`
- **User:** `admin`
- **Password:** `admin`

To stop MySQL:

```sh
docker-compose down
```

---

### 🔹 Production

```sh
# Package the app
mvn clean package

# Run the JAR file
java -jar target/task-manager-api.jar --spring.profiles.active=prod
```

---

## 📌 API Endpoints

| Method   | Endpoint      | Description    |
|----------|---------------|----------------|
| `POST`   | `/tasks`      | Create a task  |
| `GET`    | `/tasks`      | List all tasks |
| `GET`    | `/tasks/{id}` | Get task by ID |
| `PUT`    | `/tasks/{id}` | Update a task  |
| `DELETE` | `/tasks/{id}` | Delete a task  |

---

## 🛠️ Environment Configuration

The project has **three configuration files** for different environments:

- `application-dev.yml` (for local development)
- `application-qa.yml` (for testing with MySQL)
- `application-prod.yml` (for production)

Modify these files as needed to configure database connections and other settings.

---

## 🏗️ Deployment

You can deploy the project using **Docker**:

```sh
# Build the Docker image
docker build -t task-manager-api .

# Run the container
docker run -p 8080:8080 -e SPRING_PROFILES_ACTIVE=prod task-manager-api
```

---

## 🧪 Running Tests

To execute the unit tests:

```sh
mvn test
```

---

## 📧 Contact

For any issues or suggestions, feel free to reach out!

---

🎉 **Happy Coding!** 🚀

