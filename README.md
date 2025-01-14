# QuizApp (Microservices Architecture)

QuizApp is a microservices-based application designed to manage quizzes and questions efficiently. The project follows a modular structure, with separate services for different functionalities.

## Project Structure

The application consists of the following services:

1. **Quiz Service**:
   - Handles all quiz-related operations such as creating, updating, and retrieving quizzes.
   - Directory: `quiz-service`

2. **Question Service**:
   - Manages questions, including adding, updating, and fetching questions.
   - Directory: `question-service`

3. **Service Registry**:
   - Implements service discovery using Eureka Server.
   - Directory: `service-registry`

4. **API Gateway**:
   - Acts as a gateway for routing requests to the appropriate services.
   - Directory: `api-gateway`

## Prerequisites

Before running the application, ensure the following are installed on your system:

- Java 11 or higher
- Maven
- Spring Boot
- Git

## Getting Started

### Cloning the Repository

1. Initialize Git in your local directory:
   ```bash
   git init
   ```
2. Clone the repository:
   ```bash
   git clone https://github.com/chirdekaran262/QuizApp-Microservices-.git
   ```

### Running the Application

1. Navigate to each service directory (`quiz-service`, `question-service`, `service-registry`, `api-gateway`).
2. Build the services using Maven:
   ```bash
   mvn clean install
   ```
3. Start each service:
   ```bash
   mvn spring-boot:run
   ```

### Accessing the Application

- API Gateway: `http://localhost:8765` 
- Service Registry Dashboard: `http://localhost:8761`
- check the port in `applcation.properties` file for respective microservice
  
## Technologies Used

- **Java**: Backend language
- **Spring Boot**: Framework for microservices
- **Eureka**: Service discovery
- **Maven**: Dependency management
- **Git**: Version control

## Key Features

- Microservices architecture
- Service registry for dynamic discovery
- API gateway for centralized routing
- Modular design for scalability

## Troubleshooting

If you encounter warnings such as `LF will be replaced by CRLF`, ensure your Git configuration is set correctly. You can configure Git to handle line endings appropriately using:

```bash
git config --global core.autocrlf true
```

## Contributing

Feel free to contribute to the project by submitting pull requests or reporting issues.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

Happy Coding!
