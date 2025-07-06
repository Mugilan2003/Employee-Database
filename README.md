### Employee Database

````markdown
# 🗂️ Employee Database (JDBC Project)

This is a **console-based Java application** that demonstrates how to perform basic CRUD operations using **JDBC (Java Database Connectivity)** with a **MySQL** database.

## 📌 Features

- ✅ Add New Employee
- 🔍 View All Employees
- 📝 Update Employee Details
- ❌ Delete Employee

## 🛠️ Technologies Used

- Java
- JDBC
- MySQL
- SQL
- Scanner (for console input)

## 🧱 Project Structure

- `EmployeeDatabase.java` – Main class with JDBC connection and all operations.
- Uses `PreparedStatement` and `ResultSet` to interact with the database securely.

## 💻 How to Run

1. 🔧 **Set up MySQL Database**:
   - Create a database called `your_database_name`
   - Create a table with fields like `id`, `name`, `department`, `salary`, etc.

2. 🛠️ **Update DB Credentials** in the code:
   ```java
   String url = "jdbc:mysql://localhost:3306/your_database_name";
   String user = "root";
   String password = "your_password";
````

3. ▶️ **Compile and Run**

   ```bash
   javac EmployeeDatabase.java
   java EmployeeDatabase
   ```


## 📖 Concepts Used

* JDBC Connection
* SQL Queries (INSERT, SELECT, UPDATE, DELETE)
* Java Exception Handling
* OOP Principles
* Console Input with Scanner

---

🔗 [Project Repository](https://github.com/Mugilan2003/Employee-Database)

