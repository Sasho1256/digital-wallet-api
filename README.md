# Description
This [project](https://github.com/Sasho1256/sumUp_api) is a RESTful API built in Java using the Spring Boot framework. It serves as a digital wallet, that offers the following functionalities: 
- Creating a wallet using a username
- Accessing wallet details using the wallet's ID
- Deposit and withdrawal operations

# Local development
- **Requirements**
    - Java Development Kit - JDK 17 (or higher)
    - Maven
    - MySQL
    - Spring Boot

- **Application startup (Windows)**
    - Replace the username and password for the MySQL connection in the [application.properties](src\main\resources\application.properties) file
    - Ensure the MySQL Server (in Windows System Services) is running
    - Run the following commands in the terminal:

```bash
mvn clean install
mvn spring-boot:run
```

- **API Access**
    - Once the above steps have been completed and the application is running, the api can be accessed/tested using tools like Postman and curl

- **Example API Requests**
    - POST  http://localhost:8080/api/wallets?username=Alexa
    - GET   http://localhost:8080/api/wallets/{id}
        -   http://localhost:8080/api/wallets/1
    - POST  http://localhost:8080/api/wallets/{id}/deposit?amount=100
        -   http://localhost:8080/api/wallets/1/deposit?amount=100
    - POST  http://localhost:8080/api/wallets/{id}/withdraw?amount=40
        -   http://localhost:8080/api/wallets/1/withdraw?amount=40