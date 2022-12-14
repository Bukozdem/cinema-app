# Cinema service 🎥
## Description
This is a simulator application for a cinema, which allows you to register, authenticate and authorize users and administrators of the service. Administrators can add movies, sessions, and rooms. Each user can make an order by adding it to their cart and get a ticket for a specific session.
## Features
- Registration and authentication of users / authorization of administrators due to Spring Security;
- Validation of the correspondence of the specified mail and the match of the password and re-password fields from new users;
- Distribution of access to service functions for users and administrators;
- If a request fails, the GlobalExceptionHandler will show comprehensive error information.
## Structure
According to OOP, the project is divided into several levels: controllers, services, and Tao. At the level of controllers, requests from users and administrators are received, at the level of services these requests are processed, and at the level of Tao, information is recorded, changed or deleted.
## Technologies
- Hibernate;
- Spring;
- Spring Security;
- Logger.
## Instructions for launching the project
- To run the app, you need to clone the project from my repository into IntelliJ IDEA;
- Install and configure Tomcat servlet container (version 9.0.50);
- Database connection settings in the db.properties file in the resources folder;
- Start Tomcat.
#### Credential to test app: login: admin@i.ua, password: admin123.
### Model structure
![pic](Cinema-app.png)