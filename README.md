# Mutants API REST

Esta API REST es usada para determinar si una cadena de ADN corresponde a un mutante

#### Paths
http://127.0.0.1:8080/api/mutant/
http://127.0.0.1:8080/api/stats/
```
- Health Check
```
http://127.0.0.1:8080/api/health-check/
```

## Getting Started

Clone the repository
```
git clone https://github.com/jpg117/mutant.git
```

Don't forget to install Docker images or services:
- MySQL
```
docker run --name mutants -p: 3306:3306 -e MYSQL_ROOT_PASSWORD=password -d mysql
``` 

### Installing

- Spring Framework & Spring Boot 2
- Maven
- Docker - Container Framework
- MySQL

(THE PORT BY DEFAULT THAT WORK THE SERVICE IS 8080)

### Built With

* [MySQL](https://www.mysql.com/) - Relational Database used
* [Spring Boot](https://spring.io/projects/spring-boot) - The Framework
* [JUnit](https://junit.org/junit5/) - The Testing Framework

### Contributors
- **Juan Pablo Garcia** - *Backend Developer of Support Compensations* - juanpablo.garcia@rappi.com
