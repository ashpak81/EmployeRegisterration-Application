# Employee Registration Application - Backend

This is the backend part of the Employee Registration Application, built using Spring Boot.

---

## Prerequisites

Before starting, ensure you have the following installed on your system:

- **Java 17**: Required to run the Spring Boot application.
- **Maven**: For dependency management and building the project.
- **PostgreSQL**: As the database for the application.

---

## Setup Instructions

### Step 1: Clone the Repository

1. Clone the repository to your local machine:
   ```bash
   git clone https://github.com/your-username/EmployeRegistration-Application.git
   cd EmployeRegistration-Application/empApplication
   ```

---

### Step 2: Set Up the Database

1. Ensure PostgreSQL is installed and running.
2. Create a database for the application:
   ```sql
   CREATE DATABASE employeeregistration;
   ```
3. Update the database connection details in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/employeeregistration
   spring.datasource.username=your-username
   spring.datasource.password=your-password
   spring.jpa.hibernate.ddl-auto=update
   ```

---

### Step 3: Build and Run the Application

1. Build the project using Maven:
   ```bash
   mvn clean install
   ```

2. Run the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```

3. The backend server will start at:
   ```
   http://localhost:8080
   ```

---

## API Endpoints

### Employee Endpoints

- **POST** `/employee`: Add a new employee.
- **GET** `/employee/{id}`: Retrieve employee details by ID.
- **PATCH** `/employee/{id}`: Update employee details by ID.
- **DELETE** `/employee/{id}`: Delete an employee by ID.

---

## Project Structure

The main directories and files in this project:

```
empApplication/
├── src/
│   ├── main/
│   │   ├── java/                   # Java source code
│   │   │   ├── com.example.employee/ # Main application package
│   │   │   │   ├── controller/    # REST controllers
│   │   │   │   ├── service/       # Service layer
│   │   │   │   ├── model/         # Entity classes
│   │   │   │   ├── repository/    # JPA repositories
│   │   ├── resources/             # Configuration files
│   │       ├── application.properties # Application configuration
├── pom.xml                        # Maven project file
```

---

## Dependencies

The project uses the following key dependencies:

- **Spring Boot**: For the application framework.
- **Spring Data JPA**: For ORM and database access.
- **PostgreSQL Driver**: For connecting to the PostgreSQL database.
- **Lombok**: To reduce boilerplate code.

---

## Troubleshooting

1. Ensure Java 17 is installed and configured properly:
   ```bash
   java -version
   ```
   The output should show Java 17.

2. Verify that the PostgreSQL service is running:
   ```bash
   sudo service postgresql status
   application.property postgresql authentication details 
   ```

3. If the application fails to start, check the `application.properties` file for correct database credentials.

---

## Contribution

Feel free to fork this repository and create pull requests for any improvements or bug fixes.

---

## License

This project is licensed under the [MIT License](LICENSE).

```

---

### Notes:
- Replace `your-username` in the `git clone` URL with your GitHub username.
- Update the "Contribution" and "License" sections if necessary.

Let me know if you need any changes!
