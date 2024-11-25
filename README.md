
##1.Technology Used
Java 8 (Version should be 8 or higher than 8)
Spring Boot (Dependency: Spring-web, Spring-jpa, MySQL)
Database – MySQL
Created using Maven

Employee entity and its attributes:
The attributes shown are:

empId
empName
empSalary
empCity
empAge

##Step By Step 
Employee CRUD API in brief
1. Employee ▪️Model contains all the attributes
2. EmployeeController-▪️RestController which has request mapping method
3. Employee Repository which extends JpaRepository to performed CRUD operation
4. Application.properties contains DB Details
5. Pom.xml contains all the dependencies needed by API

##2.
Operation	URL or API Path		 What Action will it do?

POST		/api/employees			 Create new Employee
GET		/api/employees			 Retrieve all Employees
GET		/api/employees/:id		 Retrieve an Employee by :empid
PUT		/api/employees/:id		 Update an Employee by :empid
DELETE		/api/employees/:id		 Delete an Employee by :empid
DELETE		/api/employees			 Delete all Employees
GET		/api/employees?city=[keyword]	 Find all Employees based on Employee City
GET		/api/employees?empAge=[keyword] Find all Employees whose age > empAge


##3.
Employee CRUD API in brief

Employee Model contains all the attributes
EmployeeController – RestController which has request mapping method
EmployeeRepository which extends JpaRepository to perform CRUD operation
Application.properties contains DB Details
Pom.xml contains all the dependencies needed by API


##4.
CREATE DATABASE IF NOT EXISTS EmployeeDB;
USE EmployeeDB;

-- Drop the table if it exists
DROP TABLE IF EXISTS Employee;

-- Create the Employee table
CREATE TABLE Employee (
    empid BIGINT NOT NULL AUTO_INCREMENT,
    emp_name VARCHAR(50) DEFAULT NULL,
    emp_salary FLOAT DEFAULT NULL,
    emp_age INTEGER DEFAULT NULL,
    emp_city VARCHAR(50) DEFAULT NULL, -- Corrected column name
    PRIMARY KEY (empid)
);

-- Select all records from the Employee table
SELECT * FROM Employee;


##5.Database Connectivity

spring.application.name=EmployesAPICRUD
spring.datasource.url=jdbc:mysql://localhost:3306/EmployeeDB
spring.datasource.username=root
spring.datasource.password=123
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port:4050


PostMan:
https://orange-robot-953017.postman.co/workspace/New-Team-Workspace~b45e84aa-3cfc-496d-9517-32f1334277d0/collection/30211016-f5a2e5c1-c657-4e04-9cb6-f6b77281acbd?action=share&creator=30211016
1.POST(Save)
http://localhost:4050/api/employees
{
    "emp_name": "Ramu",
    "emp_salary": 500000,
    "emp_age": 18,
    "emp_city": "Ujjain"
}

2.GET(All)
http://localhost:4050/api/employees

3.GET(All BY ID)
http://localhost:4050/api/employees/5

4.GET(All BY City)
http://localhost:4050/api/employees/empcity?emp_city=Bhopal

5.GET(Age Greater than)
http://localhost:4050/api/employee/employeeGreaterThan?emp_age=18

6.PUT(Update by ID)
http://localhost:4050/api/employees/2

7.DELETE(DELETE by ID)
http://localhost:4050/api/employees/1

8.DELETE(DELETE ALL)
http://localhost:4050/api/employees
