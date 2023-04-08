# AirportsApp

This application is designed to list flights departing from Helsinki to different destinations. The data is retrieved from a MariaDB database, and the application is built using Spring Boot and Java, following the MVC pattern.

Prerequisites
To run this application, you must have the following installed on your computer:

Java 11
MariaDB 10.5.5
Maven 3.6.3
Getting Started
Clone the repository to your local machine.
Create a new MariaDB database and execute the flights.sql script located in the root of the project to create the necessary tables.
Edit the application.properties file located in the src/main/resources directory with your MariaDB database details.
Open a terminal and navigate to the root of the project.
Run mvn spring-boot:run to start the application.
Open your web browser and go to http://localhost:8080.
Functionality
The Flight Search Application has the following functionality:

List all airports and flights stored in the database.
Allow users to login using Spring Security.
Users can view flight data but cannot add, edit or delete data.
Admin users have full rights.
User inputs are validated using @Valid.
REST is also available in the application.
JUnit testing has been implemented.
Technologies Used
This application is built using the following technologies:

Spring Boot
Java
Thymeleaf
MariaDB
Spring Security
JUnit
Contact
If you have any questions or issues with the application, please contact me at [your email]. Thank you for using the Flight Search Application!