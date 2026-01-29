# 🛒 Shop Management System (Java Swing + Hibernate)

## 📌 Project Overview
This is a **Shop Management System** desktop application developed using **Java Swing** for UI and **Hibernate** for database operations.

The application allows **Admin users only** to manage **Users** and **Products** after successful login.  
Non-admin users are **not allowed** to perform CRUD operations.

---

## 🧭 Application Flow
1. The application starts with a **Main Dashboard (Shop JFrame)**.
2. The dashboard contains two options:
   - **User Management**
   - **Product Management**
3. When the user clicks on any option:
   - A **Login page** opens.
4. Login validation:
   - If **username & password match** AND the role is **ADMIN** → Access is granted.
   - If the user is **not ADMIN** → Access is denied.
5. After successful admin login:
   - **User Management** opens User Dashboard.
   - **Product Management** opens Product Dashboard.
6. Admin can perform **CRUD operations** on:
   - Users
   - Products

---

## 🔐 Role-Based Access
- **ADMIN**
  - Can access User Management
  - Can access Product Management
  - Can perform Create, Read, Update, Delete (CRUD)
- **CUSTOMER / Non-Admin**
  - Cannot access dashboards
  - CRUD operations are restricted

---

## 🛠 Technologies Used
- **Java (Core Java)**
- **Java Swing (JFrame, JButton, JLabel, etc.)**
- **Hibernate (ORM)**
- **SQL Database**
- **Eclipse IDE**
- **Try-Catch for Exception Handling**
- **Enums for Role Management**
  - `Role (ADMIN, CUSTOMER)`
  - `ModuleType (USER, PRODUCT)`

---

## 🧱 Key Concepts Implemented
- JFrame Navigation
- Role-based Authentication
- Enum usage for clean logic
- Hibernate Session & Transaction
- Exception Handling using Try-Catch
- Clean separation of UI and logic

---

## 📂 Modules
- **Shop (Main Dashboard)**
- **Login**
- **User Management**
- **Product Management**

---

## 🚀 Future Enhancements
- Password encryption
- Logout functionality
- More user roles
- Improved UI design
- Validation improvements

---

## 👨‍💻 Author
**Dileep N**  
Java Developer | Learning Hibernate & Desktop Applications
