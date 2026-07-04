# 🚗 Ride Sharing Management System (Java)

A Java-based Ride Sharing Management System developed as a basic Advanced Programming course project.

The project demonstrates core Object-Oriented Programming (OOP) concepts and Java Swing GUI development through a simple ride-sharing application.

---

## 📌 Project Overview

The Ride Sharing Management System is a desktop-based Java application that connects users, drivers, and administrators in a simple ride management environment.

Users can register, log in, book rides, calculate fares, make payments, provide ratings, and use vehicle rental services.

Drivers can view ride requests, accept rides, manage active rides, complete rides, and view their earnings.

Administrators can monitor registered users, drivers, rides, payments, and rental activities.

The current version uses Java ArrayList collections for temporary in-memory data storage.

---

## ✨ Features

### 👤 User Module

- User Registration
- User Login
- Book a Ride
- Select Vehicle Type
- Automatic Fare Calculation
- View Ride History
- Make Ride Payment
- Give Ride Rating and Review
- Rent a Vehicle
- View Rental History
- User Logout

### 🚘 Driver Module

- Driver Registration
- Driver Login
- View Pending Ride Requests
- Accept Ride Requests
- View Active Ride
- Start Ride
- Complete Ride
- View Driver Ride History
- View Total Earnings
- Driver Logout

### 🛡️ Admin Module

- Admin Login
- View Registered Users
- View Registered Drivers
- Monitor Ride Information
- View Payment Records
- View Rental Records
- Admin Logout

### 🚕 Vehicle and Ride Features

- Bike Ride
- CNG Ride
- Private Car Ride
- Vehicle-based Fare Calculation
- Automatic Ride ID Generation
- Ride Status Management

Ride status flow:

Pending → Accepted → Started → Completed

### 💳 Payment Features

- Ride-based Payment
- Multiple Payment Method Selection
- Automatic Payment ID Generation
- Duplicate Payment Prevention
- Payment Record Management

### ⭐ Rating Features

- Ride Rating
- Rating Value from 1 to 5
- User Review
- Automatic Rating ID Generation
- Duplicate Rating Prevention

### 🔑 Rental Features

- Bike Rental
- CNG Rental
- Private Car Rental
- Hour-based Rental Calculation
- Automatic Rental ID Generation
- Rental History

---

## 🛠️ Technologies Used

- Java
- Java Swing
- Object-Oriented Programming (OOP)
- Java Collections Framework
- ArrayList
- Git
- GitHub
- Visual Studio Code

---

## 🧠 OOP Concepts Implemented

### Encapsulation

Private data members are used in model classes with getter and setter methods.

### Inheritance

The `User`, `Driver`, and `Admin` classes inherit common properties from the `Person` class.

```text
              Person
            /    |    \
         User  Driver  Admin

### Abstraction

The Vehicle class is implemented as an abstract class with an abstract fare calculation method.

###Polymorphism

A Vehicle reference can represent different vehicle objects such as Bike, CNG, and Private.

### Method Overriding
Each vehicle class provides its own implementation of the calculateFare() method.

### 🏗️ Project Architecture

The project follows a simple layered package structure.
src/
│
├── model/
│   ├── Person.java
│   ├── User.java
│   ├── Driver.java
│   ├── Admin.java
│   ├── Vehicle.java
│   ├── Bike.java
│   ├── CNG.java
│   ├── Private.java
│   ├── Ride.java
│   ├── Payment.java
│   ├── Rating.java
│   └── Rental.java
│
├── service/
│   ├── LoginManager.java
│   ├── RegisterManager.java
│   ├── RideManager.java
│   ├── PaymentManager.java
│   ├── RatingManager.java
│   └── RentalManager.java
│
└── ui/
    ├── LoginPage.java
    ├── RegisterSelectionPage.java
    ├── RegisterPage.java
    ├── DriverRegisterPage.java
    ├── UserDashboard.java
    ├── DriverDashboard.java
    ├── AdminDashboard.java
    ├── BookRidePage.java
    ├── RideHistoryPage.java
    ├── RideRequestPage.java
    ├── ActiveRidePage.java
    ├── DriverRideHistoryPage.java
    ├── EarningsPage.java
    ├── PaymentPage.java
    ├── RatingPage.java
    ├── RentalPage.java
    ├── RentalHistoryPage.java
    ├── AdminRidePage.java
    ├── AdminPaymentPage.java
    └── AdminRentalPage.java

### 🔄 System Flow

Application Start
        ↓
     Login Page
        ↓
 ┌──────┼──────┐
 │      │      │
User  Driver  Admin
 │      │      │
 ↓      ↓      ↓
User   Driver  Admin
Dashboard Dashboard Dashboard


### 📊 Current Project Status

[x] Project Setup
[x] Git and GitHub Integration
[x] Package Structure
[x] Person Model
[x] User Registration and Login
[x] Driver Registration and Login
[x] Admin Login
[x] Vehicle Module
[x] Fare Calculation
[x] Ride Booking
[x] Ride Request Management
[x] Ride Status Management
[x] Ride History
[x] Driver Earnings
[x] Payment System
[x] Rating System
[x] Rental System
[x] Java Swing GUI
[x] Admin Monitoring System

###⚠️ Current Limitations

- Data is stored temporarily using ArrayList.
- Data is lost when the application is closed.
- Database integration is not implemented.
- Password encryption is not implemented.
- Real-time GPS tracking is not available.
- Online payment gateway integration is not available.
- The graphical user interface uses a basic Java Swing design.

### 🚀 Future Improvements

- Database Integration
- Secure Password Encryption
- Improved Java Swing UI Design
- Real-time Ride Tracking
- GPS and Map Integration
- Online Payment Gateway
- Driver Availability Management
- Vehicle Availability Management
- Advanced Admin Management
- Ride Search and Filtering
- Persistent User Sessions

### 🎓 Academic Purpose

This project was developed for the Advanced Programming Course to demonstrate practical implementation of Java programming and Object-Oriented Programming concepts.

The project focuses on:
- Java Classes and Objects
- Encapsulation
- Inheritance
- Abstraction
- Polymorphism
- Method Overriding
- Java Collections
- Exception Handling
- Event Handling
- Java Swing GUI

### 👨‍💻 Author

Group Project led by Nayeem
Advanced Programming Course Project

