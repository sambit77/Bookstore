# Bookstore Application
##### Please refer Projects tab for step-to-step implementation of the project container-wise

This application displays a catalog of books fetched from database , enables users to browse through the books and post logging in they can place orders , which will be further processed by the backend application.

## Steps to run the application:
#### Install [Docker](https://www.docker.com/) and ensure Docker is running.
1. Clone the repository: `git clone https://github.com/sambit77/Bookstore.git && cd Bookstore`
2. Start the Application: `docker compose -f ./deployment/docker-compose/infra.yml -f ./deployment/docker-compose/apps.yml up -d` <br>
3. Endpoint-URL: [localhost:8080](http://localhost:8080/products?) <br>
4. Stop the Application:  `docker compose -f ./deployment/docker-compose/infra.yml -f ./deployment/docker-compose/apps.yml stop` <br>
5. Remove Containers: `docker compose -f ./deployment/docker-compose/infra.yml -f ./deployment/docker-compose/apps.yml rm -f` <br>
![BookStore Microservices Architecture](docs/bookstore-spring-microservices-layout.png) 
## Modules
* **catalog-service**: 
  This services provides REST API for managing catalog of products(books).
  
  **TechStack:** Spring Boot, Spring Data JPA, PostgreSQL

* **order-service**: 
  This service provides the REST API for managing orders and publishes order events to the message broker.

  **TechStack:** Spring Boot, Spring Security OAuth2, Keycloak, Spring Data JPA, PostgreSQL, RabbitMQ

* **notification-service**: 
  This service listens to the order events and sends notifications to the users.
  
  **TechStack:** Spring Boot, RabbitMQ

* **api-gateway**: 
  This service is an API Gateway to the internal backend services (catalog-service, order-service).

  **TechStack:** Spring Boot, Spring Cloud Gateway

* **bookstore-webapp**: 
  This is the customer facing web application where customers can browse the catalog, place orders, and view their order details. 

  **TechStack:** Spring Boot, Spring Security OAuth2, Keycloak, Thymeleaf, Alpine.js, Bootstrap

* **Bookstore-Web-Application**:  [localhost:8080](http://localhost:8080/) Users:{sambit,sambit1234} & {virat,virat1234}
* **Swagger-API-Docs+API-Gateway**:  [localhost:8989](http://localhost:8989/)
* **Prometheus-For-Monitoring-Metrics**: [localhost:9090](http://localhost:9090/targets?search=)
* **Grafana-UI+Traceing-Using-Tempo+LogDump-Using-Promatail-And-Loki**: [localhost:3000](http://localhost:3000)
* **KeyCloak-For-Access-Management** [localhost:9191](http://localhost:9191/)
* **Mailhog-Dummy-MailBox** [localhost:8025](http://localhost:8025/)
* **Rabbit-MQ** [localhost:15672](http://localhost:15672/)

## Other Key Learnings:- 

*  Database Persistence using Flyway DB Migrations 
*  Event Driven Async Communication using RabbitMQ
*  Job Scheduling with ShedLock-based distributed Locking
*  Using RestClient, Declarative HTTP Interfaces to invoke other APIs
*  Creating Aggregated Swagger Documentation at API Gateway
*  Local Development Setup using Docker, Docker Compose and Testcontainers
*  Testing using JUnit 5, RestAssured, Testcontainers, Awaitility, WireMock
*  Monitoring & Observability using Grafana, Prometheus, Loki, Tempo

##### Install [Taskfile](https://taskfile.dev/) for better managing of the application during development.
###### Follwoing command can be triggered from root of the application
1. `task start_infra` : Starts only the dependent services in docker (PostgresSQL DB for 3 microservices, RabbitMQ, MailHog) post which 4 microservices (Catalog-Service, Order-Service, Notifications-Service, WebUI) can be manually run from GUI or using ./mvnw spring-boot:run command. <br>
2. `task start`: spin up all the services in docker. <br>
3. `task test` : Runs tests for all the microservices by running ./mvnw clean package internally. <br>
4. `task build` : Build docker image for all the microservices <br>

###### Access all the commands in Taskfile.yml
 

