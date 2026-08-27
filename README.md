# API Test Automation Framework

## Project Overview

This project is a Java-based API test aitomation framework built using REST Assured and TestNG. It automates REST API testing for GET, POST, PUT, and DELETE requests and validates HTTP status codes and JSON responses fields.

The framework also includes data-driven testing, negative testing, reusable validation utilities, external JSON test data, and TestNG suite execution.

## Technologies used

-Java
-REST Assured
-TestNG
-Maven
-JSON
-IntelliJ IDEA
-Git & GitHub

## Framework Structure

```text
src
└── test
    ├── java
    │   ├── base
    │   │   └── BaseTest.java
    │   ├── endpoints
    │   │   └── Routes.java
    │   ├── negative
    │   │   ├── InvalidCreatePostTest.java
    │   │   ├── InvalidEndpointTest.java
    │   │   └── InvalidPostTest.java
    │   ├── tests
    │   │   ├── GetPostTest.java
    │   │   ├── CreatePostTest.java
    │   │   ├── DataDrivenPostTest.java
    │   │   ├── UpdatePostTest.java
    │   │   └── DeletePostTest.java
    │   └── utils
    │       ├── ApiValidator.java
    │       └── JsonReader.java
    │
    └── resources
        ├── postData.json
        ├── postTestData.json
        └── updatePostData.json

pom.xml
testng.xml
