# 🛒 Thogakade Management System

A modern JavaFX-based POS (Point of Sale) system designed for managing store operations such as Customers, Items, Orders, and Order Details — built using MVC Architecture and Singleton Pattern for clean & scalable code.

---

## 📌 ✨ Features Overview

### 👤 Customer Management

- Add / Update / Delete customers
- Search customer by ID
- View customer list

### 📦 Item Management

- Add new items
- Update price, quantity, and pack size
- Delete items
- Search and list all items

### 🧾 Order Management

- Create new orders
- Select customer + multiple items
- View existing orders

### 🔗 Order Detail Management

- Added automatically when an order is created
- Stores line items of each order
- Includes foreign keys:
   `OrderDetail.custId` → `Customer.custId`
   `OrderDetail.itemCode` → `Item.itemCode`

---

## 🧩 ⚙️ Tech Stack

- JavaFX – Frontend UI
- Java – Core logic & controllers
- MySQL / SQL – Database
- JDBC – Database integration
- MVC Pattern – Organized architecture
- Singleton Pattern – Centralized DB connection manager
