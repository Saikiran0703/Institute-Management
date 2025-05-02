# Institute Management System

## Description

This web application is designed to manage data for an educational institute, including students, courses, and instructors.

## Technologies Used

* Spring Boot
* Thymeleaf
* MySQL (or PostgreSQL, depending on your configuration)
* JPA/Hibernate
* Bootstrap

## Setup Instructions

1.  **Prerequisites:**
    * Java Development Kit (JDK) 17 or a later version
    * MySQL or PostgreSQL database server
    * Git (optional, for cloning the repository)
    * Maven build tool

2.  **Database Setup:**
    * Create a database named `institute_db` on your MySQL or PostgreSQL server.
    * Execute the SQL script (`institute_db_schema.sql`) located in the `database` directory to create the database schema.
    * If you named your database differently from `institute_db`, update the `spring.datasource.url`, `spring.datasource.username`, and `spring.datasource.password` properties in the `application.properties` file to reflect your database configuration. A sample `application.properties` file is shown below:

        ```properties
        spring.application.name=institute-management-system
        spring.datasource.url=jdbc:mysql://localhost:3306/institute_db?createDatabaseIfNotExist=true&autoReconnect=true&useSSL=false # Or use the appropriate PostgreSQL URL
        spring.datasource.username=your_mysql_username # Or your PostgreSQL username
        spring.datasource.password=your_mysql_password # Or your PostgreSQL password
        spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver # Add this line for MySQL
        spring.jpa.hibernate.ddl-auto=update
        spring.jpa.show-sql=true
        spring.thymeleaf.cache=false
        spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect # Add this line for MySQL
        ```

3.  **Running the Application:**

    * **Option 1: Using Git and Maven**
        * Clone the repository: `git clone <your_repository_url>`
        * Navigate to the project directory: `cd institute-management-system`
        * Build the application: `mvn clean install`
        * Run the application: `mvn spring-boot:run`
    * **Option 2: Importing into an IDE (IntelliJ IDEA, Eclipse, etc.)**
        * Import the project as a Maven project.
        * Ensure that Maven downloads the project dependencies.
        * Run the `InstituteManagementSystemAppli` class as a Java application.

4.  **Accessing the Application:**
    * Open a web browser and navigate to `http://localhost:8080/students`.

## Additional Notes

* The application provides the following functionalities:
    * Student Management: Add, edit, delete, list, and search for students.
    * Course Management: Add, edit, delete, and list courses.
    * Instructor Management: Add, edit, delete, and list instructors.
    * Dashboard: View summary information.
