# College Directory Management System

## Overview

The College Directory Management System is a web application designed to manage user profiles, courses, 
and enrollments within a college environment. This project focuses on providing a robust backend built with Spring Boot, while the frontend will be developed using React.

## Technologies Used

- **Backend:**
  - Java 20.0.2
  - Spring Boot 3.3.4
  - PostgreSQL (for database management)
  
- **Frontend:**
  - React (to be developed)

## Project Structure

college-directory
├── src
│   └── main
│       ├── java
│       │   └── com
│       │       └── example
│       │           └── collegedirectory
│       │               ├── CollegeDirectoryApplication.java
│       │               ├── controller
│       │               │   └── UserController.java
│       │               ├── model
│       │               │   ├── User.java
│       │               │   ├── Role.java
│       │               │   ├── StudentProfile.java
│       │               │   ├── FacultyProfile.java
│       │               │   ├── AdministratorProfile.java
│       │               │   ├── Course.java
│       │               │   └── Enrollment.java
│       │               └── repository
│       │                   ├── UserRepository.java
│       │                   ├── StudentProfileRepository.java
│       │                   ├── FacultyProfileRepository.java
│       │                   ├── AdministratorProfileRepository.java
│       │                   ├── CourseRepository.java
│       │                   └── EnrollmentRepository.java
│       └── resources
│           └── application.properties
└── pom.xml
