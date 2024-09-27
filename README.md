# fiap-hc-patient-api

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=tech-challenge-fiap-5soat_fiap-hc-patient-api&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=tech-challenge-fiap-5soat_fiap-hc-patient-api) [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=tech-challenge-fiap-5soat_fiap-hc-patient-api&metric=coverage)](https://sonarcloud.io/summary/new_code?id=tech-challenge-fiap-5soat_fiap-hc-patient-api)

#### API to manage patient data and create appointment requests with doctors

### Architecture

![hackathon drawio](https://github.com/user-attachments/assets/4a0aee84-0454-46f7-b77d-5417feb23015)


## Technology stack

This API was built using [Java](https://www.java.com/) and several tools:
- [Spring Boot](https://spring.io/projects/spring-boot) - Framework for creating stand-alone, production-grade Spring-based Applications
- [Maven](https://maven.apache.org/) - Dependency management and build automation tool
- [PostgreSQL](https://www.postgresql.org/) - Open-source relational database
- [Springdoc OpenAPI UI](https://springdoc.org/) - API documentation tool for Spring Boot projects
- [JUnit](https://junit.org/junit5/) - Testing framework for Java
- [Mockito](https://site.mockito.org/) - Mocking framework for unit tests
- [MapStruct](https://mapstruct.org/) - Code generator for bean mappings
- [Jackson](https://github.com/FasterXML/jackson) - JSON parser for Java
- [Amazon Cognito](https://aws.amazon.com/cognito/) - Access user management
- [Feign](https://github.com/OpenFeign/feign) - Java to HTTP client binder
- [Spring Security](https://spring.io/projects/spring-security) - Powerful and highly customizable security framework
- [Lombok](https://projectlombok.org/) - Library to reduce boilerplate code
- [Docker](https://www.docker.com/) - Platform for developing, shipping, and running applications in containers 
------

### Requests flow

#### 1. Create Patient
```mermaid 
      flowchart LR 
          A[Create Patient] -->|Request auth credetentials creation| B(Account-api)
          B -->|Data validation | C{credentials is valid}
          C -->|yes| D[Request credentials creation on AWS Cognito ]
          C -->|no| E[Return error message]
          F[Save Patient data locally] 
          D -->F 
```
#### 2. Request authorization token
```mermaid
     flowchart LR 
          A[Request token] -->|Request token with user and pass| B(Account-api)
          B -->|checking credentials | C{user exists and credentials is valid}
          C -->|yes| D[AWS Cognito generate a valid token]
          C -->|no| E[Return error message]
          F[Valid token is returned] 
          D -->F 
```
#### 3. Create a schedule appointment
```mermaid
     flowchart LR
    A[Create appointment] -->|Request an appointment creation with a previous available slot| B(Scheduling-api)
    B -->|Data validation | C{Schedule slot still available}
    C -->|yes| D[create scheduling with a doctor]
    C -->|no| E[Return schedule slot unavailable message]
    F[Save scheduling data locally] 
    D -->F
```

### Development

Before run the application, you need to export the variables below:

```sh
export AWS_ACCESS_KEY_ID=test
export AWS_SECRET_ACCESS_KEY=test
```

### Testing

Locally, you can use the command below:

```sh
make test
```

This command will run all unit tests.
