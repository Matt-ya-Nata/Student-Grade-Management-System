# Student Grade Management System

## 📚 Project Overview

The Student Grade Management System is a console-based Java application developed using Object-Oriented Programming (OOP) principles and Java Database Connectivity (JDBC). The system is designed to help schools and academic institutions manage student academic records efficiently through a database-driven environment.

The application allows users to add, view, update, and delete student records while automatically calculating student averages and determining pass or fail status based on academic performance.

This project was developed as part of an academic software engineering assignment to demonstrate Java programming concepts, database integration, and CRUD functionality.

---

# 🚀 Features

The system provides the following functionalities:

* Add new students
* Store student subject names and marks
* Automatically calculate averages
* Automatically determine PASS or FAIL status
* View all students
* View a student by ID
* Update specific student information
* Delete student records
* MySQL database integration using JDBC
* Menu-driven console interface

---

# 🛠️ Technologies Used

| Technology  | Purpose                   |
| ----------- | ------------------------- |
| Java        | Core programming language |
| JDBC        | Database connectivity     |
| MySQL       | Relational database       |
| XAMPP       | Local database server     |
| Eclipse IDE | Development environment   |

---



---

# 🧠 Object-Oriented Programming Concepts Used

## Encapsulation

The `Student` class uses private variables with getter methods to protect student data and maintain data integrity.

Example:

```java
private String name;
```

---

## Constructors

Constructors are used to initialize student objects when records are created or updated.

Example:

```java
Student student = new Student(...);
```

---

## Method Overloading

The `GradeCalculator` class demonstrates method overloading using multiple `calculateAverage()` methods with different parameters.

Example:

```java
public double calculateAverage(double s1, double s2, double s3)
```

and

```java
public double calculateAverage(int total, int numberOfSubjects)
```

---

## Modular Design

The application separates responsibilities into different classes:

| Class           | Responsibility             |
| --------------- | -------------------------- |
| Student         | Stores student data        |
| GradeCalculator | Performs calculations      |
| DatabaseManager | Handles JDBC operations    |
| SchoolSystem    | Controls menu and workflow |

---

# 🗄️ Database Design

## Database Name

```sql
schooldb
```

---

## Table Structure

```sql
CREATE TABLE students (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    subject1_name VARCHAR(100),
    subject1_mark DOUBLE,
    subject2_name VARCHAR(100),
    subject2_mark DOUBLE,
    subject3_name VARCHAR(100),
    subject3_mark DOUBLE,
    average_mark DOUBLE,
    status VARCHAR(20)
);
```

---

# 🔌 JDBC Connectivity

The application connects Java to MySQL using JDBC.

Example connection:

```java
private final String URL = "jdbc:mysql://localhost:3306/schooldb";
private final String USER = "root";
private final String PASSWORD = "";
```

Database operations are performed using:

* Connection
* PreparedStatement
* ResultSet
* DriverManager

---

# 📥 Installation & Setup Guide

## Step 1: Install Requirements

Install the following:

* Java JDK
* Eclipse IDE
* XAMPP
* MySQL JDBC Connector

---

## Step 2: Start XAMPP

Open XAMPP and start:

* Apache
* MySQL

---

## Step 3: Create Database

Open phpMyAdmin and create a database called:

```sql
schooldb
```

---

## Step 4: Create Students Table

Run the following SQL query:

```sql
CREATE TABLE students (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    subject1_name VARCHAR(100),
    subject1_mark DOUBLE,
    subject2_name VARCHAR(100),
    subject2_mark DOUBLE,
    subject3_name VARCHAR(100),
    subject3_mark DOUBLE,
    average_mark DOUBLE,
    status VARCHAR(20)
);
```

---

## Step 5: Add JDBC Driver

1. Download MySQL Connector/J
2. In Eclipse:

   * Right-click project
   * Build Path
   * Configure Build Path
   * Libraries
   * Add External JARs
3. Select the JDBC JAR file

---

## Step 6: Run the Program

Run:

```text
SchoolSystem.java
```

---

# 📋 Main Menu

```text
===== STUDENT GRADE SYSTEM =====
1. Add Student
2. View Student by ID
3. View All Students
4. Update Student
5. Delete Student
6. Exit
```

---

# ➕ Adding a Student

The system prompts the user to:

* Enter student name
* Enter subject names
* Enter subject marks

The application then:

* Calculates average
* Determines pass/fail status
* Stores the data in MySQL

---

# 📖 Viewing Students

The system can:

* View all students
* View a specific student using ID

Student details displayed include:

* Student ID
* Name
* Subjects
* Marks
* Average
* Status

---

# ✏️ Updating Students

The update module allows users to:

* Update student name
* Update subject names
* Update subject marks

After updates:

* Average is recalculated
* Status is updated automatically

---

# ❌ Deleting Students

Users can delete student records using student IDs.

The system permanently removes the record from the database using SQL DELETE statements.

---

# 🧪 Testing

The system was tested manually to verify:

* CRUD functionality
* Database connectivity
* Grade calculations
* Menu navigation
* Data retrieval
* Update operations

---

# ⚠️ Challenges Encountered

During development, several challenges were encountered including:

* JDBC configuration issues
* Database connection errors
* SQL query mismatches
* Scanner input handling problems
* Updating partial student records
* Recalculating averages after updates

These challenges were resolved through debugging, modular programming, and database redesign.

---

# 📈 Future Improvements

Future enhancements may include:

* JavaFX or Swing GUI
* Login authentication
* Export to PDF/Excel
* Cloud database hosting
* Web-based version
* Student report generation

---

# ✅ Conclusion

The Student Grade Management System successfully demonstrates:

* Object-Oriented Programming
* JDBC database integration
* CRUD operations
* Modular programming
* Java console application development

The project provides a strong foundation for more advanced academic management systems.

---

# 👨‍💻 Author

**Mateus Natanael**



---

# 📖 References

* Oracle Java Documentation
* MySQL Documentation
* JDBC API Documentation
* Eclipse IDE Documentation
* XAMPP Documentation
