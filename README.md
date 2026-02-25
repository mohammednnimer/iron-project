# 🏭 Iron Manufacturing Factory Management System (Backend)

A production-ready backend system developed for a **real iron manufacturing factory** to manage materials, products, customers, suppliers, and operational workflows.

This system provides secure, scalable, and fully-featured REST APIs integrated with a Flutter frontend application.

---

## 🚀 Project Overview

This backend system was built to digitally transform factory operations by:

* Managing iron materials and specifications
* Handling customers and suppliers
* Tracking inventory and product details
* Supporting full CRUD operations
* Providing advanced search & filtering
* Delivering scalable REST APIs for a connected Flutter application

---

## 🏗️ System Architecture

```text
[ Flutter Frontend ]
        │
        ▼
[ REST APIs - Quarkus Backend ]
        │
        ▼
[ PostgreSQL Database ]
```

The system follows a clean layered architecture:

* Controllers (REST Endpoints)
* Services (Business Logic)
* Repositories (Database Layer)
* Entities (Database Models)
* DTOs & Mappers

---

## 📦 Core Modules

### 🔩 Iron Management

Manage all iron-related data:

* Iron Type
* Iron Thickness
* Iron Size
* Iron Shape
* Weight
* Price
* Stock Quantity

Features:

* Add new iron type
* Update specifications
* Delete records
* Search by type, thickness, shape
* Filter by stock availability

---

### 👥 Customer Management

* Add / Update / Delete customers
* Track contact information
* Store transaction-related data
* Advanced search by name or phone number

---

### 🚚 Supplier Management

* Manage suppliers
* Track supplied materials
* Store contact details
* Supplier-based filtering

---

### 📊 Inventory & Data Management

* Real-time stock tracking
* Prevent duplicate records
* Data validation
* Optimized database queries

---

## 🔎 Advanced Search Features

The system supports:

* Search by iron type
* Filter by thickness range
* Filter by weight
* Search customers by name
* Search suppliers by name
* Combined filtering (multi-criteria search)

---

## 🔐 Security & Scalability

* Stateless REST architecture
* Input validation
* Exception handling
* Clean separation of concerns
* Optimized database indexing
* Scalable design for future extensions

---

## 📡 REST API Design

### Example Endpoints

#### Iron Management

```http
GET    /api/iron
POST   /api/iron
PUT    /api/iron/{id}
DELETE /api/iron/{id}
```

#### Customers

```http
GET    /api/customers
POST   /api/customers
PUT    /api/customers/{id}
DELETE /api/customers/{id}
```

#### Suppliers

```http
GET    /api/suppliers
POST   /api/suppliers
PUT    /api/suppliers/{id}
DELETE /api/suppliers/{id}
```

---

## 🗄️ Database

Database: PostgreSQL

Main Tables:

* irons
* customers
* suppliers
* inventory
* transactions

Designed with:

* Proper relationships
* Foreign keys
* Indexing for performance
* Normalized schema

---

## 🛠️ Technologies Used

* Quarkus
* REST APIs
* PostgreSQL
* Hibernate ORM
* Java
* Flutter (Frontend Integration)

---

## ▶️ Running the Project

### Development Mode

```bash
./mvnw quarkus:dev
```

### Build Production

```bash
./mvnw package
java -jar target/quarkus-app/quarkus-run.jar
```

---

## 📈 Real-World Impact

This system is actively designed for a real factory environment and helps:

* Reduce manual paperwork
* Improve stock tracking accuracy
* Speed up order management
* Improve supplier coordination
* Provide scalable digital infrastructure

---

## 📌 Future Improvements

* Role-based authentication
* Reporting & analytics dashboard
* Invoice generation
* Export reports (PDF / Excel)
* Warehouse multi-branch support

---




# ironproject

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/ironproject-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- REST ([guide](https://quarkus.io/guides/rest)): A Jakarta REST implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.

## Provided Code

### REST

Easily start your REST Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
