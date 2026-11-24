# Social Media API

A Spring Boot project developed to practise entity relationships and database mapping using Spring Data JPA and Hibernate.

## Overview

This project simulates a basic social media platform where users can have personal profiles, create posts and participate in multiple groups.

The main purpose of this project is to understand how different entities relate to each other and how JPA manages these relationships in a relational database.

## Technologies

- Java 17
- Spring Boot 4.2.0
- Spring Data JPA
- Hibernate
- H2 Database
- Maven
- Lombok

## Entity Relationships

The application currently implements three types of relationships:

### One-to-One

**SocialUser ↔ SocialProfile**

Each user has an associated social profile. The relationship is managed through `@OneToOne`, with `SocialProfile` owning the relationship and `SocialUser` using `mappedBy`.

### One-to-Many

**SocialUser → Post**

A user can have multiple posts, while each post belongs to one user.

Implemented using `@OneToMany` and `@ManyToOne`.

### Many-to-Many

**SocialUser ↔ SocialGroup**

A user can participate in multiple groups, and each group can contain multiple users.

Implemented using `@ManyToMany` with a custom join table named `user_group`.

## Project Structure

```text
src/main/java/com/social/media/
│
├── controller/
│   └── SocialController.java
│
├── models/
│   ├── SocialUser.java
│   ├── SocialProfile.java
│   ├── Post.java
│   └── SocialGroup.java
│
├── repositories/
│   ├── SocialUserRepository.java
│   ├── SocialProfileRepository.java
│   ├── PostRepository.java
│   └── SocialGroupRepository.java
│
├── services/
│   └── SocialService.java
│
├── DataInitializer.java
└── MediaApplication.java
```

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/social/users` | Retrieve all users |
| POST | `/social/users` | Create a user |
| DELETE | `/social/users/{userId}` | Delete a user |

## Database

The project uses an in-memory H2 database.

The application automatically initializes sample users, groups, posts and profiles when it starts.

H2 Console:

```text
http://localhost:8080/h2-console
```

JDBC URL:

```text
jdbc:h2:mem:test
```

## Running the Application

Clone the repository:

```bash
git clone YOUR_REPOSITORY_URL
```

Navigate to the project directory:

```bash
cd media
```

Run the application:

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

The application starts on:

```text
http://localhost:8080
```

## Learning Objectives

This project is part of my Java and Spring Boot learning journey, focusing on:

- Understanding JPA entity relationships.
- Configuring owning and inverse sides of relationships.
- Working with `mappedBy` and `@JoinColumn`.
- Understanding join tables in many-to-many relationships.
- Exploring cascade types and fetch strategies.
- Understanding how Hibernate manages entity persistence and associations.

