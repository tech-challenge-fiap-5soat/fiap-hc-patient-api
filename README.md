# fiap-hc-patient-api

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=tech-challenge-fiap-5soat_fiap-hc-patient-api&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=tech-challenge-fiap-5soat_fiap-hc-patient-api) [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=tech-challenge-fiap-5soat_fiap-hc-patient-api&metric=coverage)](https://sonarcloud.io/summary/new_code?id=tech-challenge-fiap-5soat_fiap-hc-patient-api)

API to manage patient data and create appointment requests with doctors


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
 
