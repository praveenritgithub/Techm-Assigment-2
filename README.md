# Techm-Assigment-2
Four Coding Problem Solutions Using SpringBoot
problem statement -1

Problem Statement:  Employee Attendance Tracker
Develop an application to track employee attendance within an organization. The system should allow employees to mark attendance and managers to view attendance reports.

Objectives:

To create a reliable attendance tracking system.

To enable employees to mark daily attendance.

To provide managers with detailed attendance reports.

To manage employee data securely with role-based access.

Requirements:

Employee entity with fields: employeeId, name, department, designation.

Attendance entity with fields: attendanceId, employeeId, date, status (Present/Absent).

Ability to mark attendance daily.

Reports showing attendance summary per employee and department.

Use PostgreSQL for data persistence.

Implement Spring Security to restrict attendance marking and report viewing.

Provide a simple UI or REST API endpoints for functionalities.



PROBLEM STATEMENT-2


Problem Statement: : E-commerce Product Catalog

Create a RESTful API to manage an e-commerce product catalog. The API should support product listing, filtering by category or price, and searching by product name.

Objectives:

To develop a secure REST API for product management.

To implement CRUD operations for products using Spring Data JPA and MySQL.

To provide filtering and search functionality for better user experience.

To secure the API using Spring Security.

Requirements:

Product entity with fields: productId, name, description, price, category, and stockQuantity.

Endpoints to add, update, delete, and fetch products.

Support filtering products by category and price range.

Search products by name (partial match).

Use MySQL as the database.

Implement authentication and authorization with Spring Security (e.g., role-based access for admin and users).

Return appropriate HTTP status codes and error messages.


PROBLEM STATEMENT-3

Problem Statement:  Student Management System  
Develop a Spring Boot application to manage student information for an educational institute. The system should allow the institute to add, update, delete, and view student records efficiently, along with searching and filtering capabilities.

Objectives:

To create a user-friendly interface for managing student data.

To enable CRUD (Create, Read, Update, Delete) operations on student records.

To ensure data persistence using Spring Data JPA and an embedded H2 database.

To allow search and filter operations on student details.

Requirements:

Student entity with fields: studentId, name, age, class, email, and address.

REST endpoints or web pages for adding, updating, deleting, and viewing students.

Validation for input fields (e.g., email format, age limits).

Search functionality by student name or class.

Display a list of all students with pagination.

Use Thymeleaf templates for the UI.

Implement error handling and display user-friendly messages.


PROBLEM STATEMENT-4

Problem Statement:  Library Management System
Build a system to manage library operations including book lending, returns, and inventory management.

Objectives:

To facilitate efficient management of library books and transactions.

To track book availability and lending history.

To allow librarians to manage books and users.

To provide search and report functionalities.

Requirements:

Entities: Book (bookId, title, author, category, availability), User (userId, name, membershipType), Transaction (transactionId, bookId, userId, issueDate, returnDate, status).

Features for adding/removing books and users.

Lending and return functionality with status updates.

Search books by title, author, or category.

Reports on overdue books and user borrowing history.

Use Spring Data JPA with H2 database.

Secure access for librarians using Spring Security.
