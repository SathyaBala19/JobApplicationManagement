Job Application Management System

A Java Web Application built using Jakarta Servlets, JSP, JDBC, and MySQL that allows users to manage job applications with full CRUD (Create, Read, Update, Delete) functionality.

📌 Project Overview

The Job Application Management System is a simple MVC-based web application designed to manage job applications.
Users can:

Add new job applications

View all applications

Update existing application details

Delete applications

This project follows standard Java web development practices using Servlets, JSP, DAO pattern, and MySQL.

✨ Features Implemented

✅ Add Application

✅ View Applications

✅ Update Application

✅ Delete Application

⚠️ Search Application (Optional – not implemented)

🏗️ Technology Stack

Frontend: JSP, HTML, CSS

Backend: Jakarta Servlets

Database: MySQL

Connectivity: JDBC

Server: Apache Tomcat (10.x / 11.x)

IDE: Eclipse IDE

📁 Project Folder Structure
JobApplicationManagement/
│
├── src/
│   └── com.job
│       ├── dao
│       │   ├── ApplicationDAO.java
│       │   └── ApplicationDAOImpl.java
│       │
│       ├── model
│       │   └── Application.java
│       │
│       ├── servlet
│       │   ├── AddApplicationServlet.java
│       │   ├── ViewApplicationServlet.java
│       │   ├── UpdateApplicationServlet.java
│       │   └── DeleteApplicationServlet.java
│       │
│       └── util
│           └── DBConnection.java
│
├── WebContent/
│   ├── view
│   │   ├── index.jsp
│   │   ├── add_application.jsp
│   │   ├── view_applications.jsp
│   │   └── update_application.jsp
│   │
│   ├── css
│   │   └── styles.css
│   │
│   └── WEB-INF
│       └── web.xml
│
└── README.md

🗄️ Database Schema

Database Name: jobdb
Table Name: applications

CREATE TABLE applications (
    applicationid INT PRIMARY KEY AUTO_INCREMENT,
    applicantname VARCHAR(100) NOT NULL,
    position VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    status VARCHAR(50) NOT NULL
);

⚙️ Setup Instructions
1️⃣ Prerequisites

JDK 17 or above

Apache Tomcat 10+

MySQL Server

Eclipse IDE (Enterprise Edition)

2️⃣ Database Configuration

Update DBConnection.java:

String url = "jdbc:mysql://localhost:3306/jobdb";
String user = "root";
String password = "your_password";

3️⃣ Run the Project

Import project into Eclipse

Configure Apache Tomcat server

Start the server

Open browser and visit:

http://localhost:8080/JobApplicationManagement/view/index.jsp

📸 Application Screens

Home Page

Add Application Form

View Applications Table

Update Application Form

(All CRUD operations demonstrated)

🧠 Architecture Used

MVC Architecture

Model → Application.java

View → JSP files

Controller → Servlets

DAO Pattern for database access

🚀 Future Enhancements

🔍 Search by applicant name or position

🧾 Input validation using JSTL

🔐 Login & Authentication

🎨 Improved UI with Bootstrap

👩‍💻 Author

Sathya Bala B
Department of Artificial Intelligence and Data Science
Web Application Development Project

📜 License

This project is developed for academic purposes.
