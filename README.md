# nsbm-employ-management 🚀

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.java.com/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.4-brightgreen)](https://spring.io/projects/spring-boot)

## Description 📝

This project is a Spring Boot-based employee management system that provides authentication and authorization functionalities. It includes user login and token validation features using JWT (JSON Web Tokens) for securing API endpoints. The system uses a MySQL database for user data persistence, managed via Spring Data JPA. The application leverages Spring Security for authentication and authorization, with password encryption using BCrypt. It also integrates with Swagger for API documentation.

## Table of Contents 📚

1.  [Features](#features-sparkles)
2.  [Tech Stack](#tech-stack-computer)
3.  [Installation](#installation-gear)
4.  [Usage](#usage-rocket)
5.  [How to use](#how-to-use-question)
6.  [Project Structure](#project-structure-file_folder)
7.  [API Reference](#api-reference-link)
8.  [Contributing](#contributing-handshake)
9.  [License](#license-balance_scale)
10. [Important links](#important-links-link)
11. [Footer](#footer-page_with_curl)

## Features ✨

-   **User Authentication**: Allows users to log in with their email and password and receive a JWT token.
-   **Token Validation**: Validates the JWT token sent in the `Authorization` header to secure API endpoints.
-   **Password Encryption**: Uses BCrypt to encrypt user passwords for enhanced security.
-   **API Documentation**: Integrated with Swagger to provide API documentation.
-   **Database Integration**: Uses MySQL database to store user data.

## Tech Stack 💻

-   **Java**: Programming language.
-   **Spring Boot**: Framework for building Java-based web applications.
-   **Spring Data JPA**: Simplifies data access with JPA repositories.
-   **Spring Security**: Provides authentication and authorization.
-   **JWT (JSON Web Tokens)**: For secure authentication and authorization.
-   **MySQL**: Relational database for data persistence.
-   **Lombok**: Java library that reduces boilerplate code.
-   **Maven**: Build automation tool.
-   **H2**: In-memory database for testing.

## Installation ⚙️

1.  **Clone the repository**:

    ```bash
    git clone https://github.com/IsharaDeshan6/nsbm-employ-management.git
    cd nsbm-employ-management
    ```

2.  **Prerequisites**:

    -   Java 21 JDK installed
    -   Maven installed
    -   MySQL database instance running

3.  **Configuration**:

    -   Set up your MySQL database and update the `application.properties` file with your database credentials.

        ```properties
        spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
        spring.datasource.username=your_username
        spring.datasource.password=your_password
        ```
    - Configure the JWT secret in `application.properties`:
      ```properties
      jwt.secret=your_secret_key_here
      ```

4.  **Build the project with Maven**:

    ```bash
    mvn clean install
    ```

5.  **Run the application**:

    ```bash
    mvn spring-boot:run
    ```

## Usage 🚀

1.  **Register a user**:

    -   This project doesn't include user registration endpoint. You must manually insert the user data into the `users` table in the MySQL database. Make sure to encrypt the password using BCrypt.

2.  **Login**:

    -   Send a POST request to `/api/v1/auth/login` with the following JSON payload:

        ```json
        {
          "email": "user@example.com",
          "password": "your_password"
        }
        ```

    -   The API will return a JWT token upon successful authentication.

3.  **Validate Token**:

    -   Send a GET request to `/api/v1/auth/validate` with the JWT token in the `Authorization` header:

        ```
        Authorization: Bearer <your_jwt_token>
        ```

    -   The API will return a 200 OK status if the token is valid; otherwise, it will return a 401 Unauthorized status.

## How to use 🤔

This project can be used as a base for building an employee management system. The authentication and authorization features can be extended to secure other API endpoints and implement role-based access control. Here are some use cases:

-   **Employee Management**: Manage employee data, such as personal information, job titles, and salaries.
-   **Access Control**: Control access to different parts of the application based on user roles.
-   **API Security**: Secure API endpoints using JWT tokens.

## Project Structure 🗂️

```
nsbm-employ-management/
├── .mvn/wrapper/maven-wrapper.properties
├── api-requests/
│   ├── login.http
│   └── validate.http
├── mvnw
├── mvnw.cmd
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   └── em/
│   │   │   │       └── nsbmemploymanagement/
│   │   │   │           ├── config/
│   │   │   │           │   └── SecurityConfig.java
│   │   │   │           ├── controller/
│   │   │   │           │   └── AuthController.java
│   │   │   │           ├── dto/
│   │   │   │           │   ├── request/
│   │   │   │           │   │   └── LoginRequestDTO.java
│   │   │   │           │   └── response/
│   │   │   │           │       └── LoginResponseDTO.java
│   │   │   │           ├── entity/
│   │   │   │           │   └── User.java
│   │   │   │           ├── NsbmEmployManagementApplication.java
│   │   │   │           ├── repository/
│   │   │   │           │   └── UserRepository.java
│   │   │   │           ├── service/
│   │   │   │           │   ├── AuthSerivce.java
│   │   │   │           │   └── UserService.java
│   │   │   │           │   └── impl
│   │   │   │           │       ├── AuthServiceImpl.java
│   │   │   │           │       └── UserServiceImpl.java
│   │   │   │           └── util/
│   │   │   │               ├── JwtUtil.java
│   │   │   │               └── StandardResponse.java
│   │   ├── resources/
│   │   │   ├── application.properties
│   │   │   └── data.sql
│   └── test/
│       └── java/
│           └── com/
│               └── em/
│                   └── nsbmemploymanagement/
│                       └── NsbmEmployManagementApplicationTests.java
```

## API Reference 🔗

### Authentication

-   **POST /api/v1/auth/login**

    -   Authenticates a user and returns a JWT token.

    -   **Request Body**:

        ```json
        {
          "email": "string",
          "password": "string"
        }
        ```

    -   **Response Body**:

        ```json
        {
          "code": 200,
          "message": "Login successful",
          "data": {
            "token": "string"
          }
        }
        ```

-   **GET /api/v1/auth/validate**

    -   Validates a JWT token.

    -   **Request Headers**:

        ```
        Authorization: Bearer <token>
        ```

    -   **Response**: 200 OK if the token is valid, 401 Unauthorized otherwise.

## Contributing 🤝

Contributions are welcome! Please follow these steps:

1.  Fork the repository.
2.  Create a new branch for your feature or bug fix.
3.  Make your changes and commit them with descriptive messages.
4.  Push your changes to your fork.
5.  Submit a pull request to the main repository.

## License ⚖️

This project is licensed under the MIT License - see the [LICENSE](https://opensource.org/licenses/MIT) file for details.

## Important links 🔗

-   Repository: [https://github.com/IsharaDeshan6/nsbm-employ-management](https://github.com/IsharaDeshan6/nsbm-employ-management)

## Footer 📜

-   Repository: [nsbm-employ-management](https://github.com/IsharaDeshan6/nsbm-employ-management)
-   Author: IsharaDeshan6
-   Contact: (No contact information provided)

⭐️ Like the project? Give it a star! 

 forks, issues. Feel free to contribute!


---
