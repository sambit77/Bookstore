# Bookstore Application
##### Please refer Projects tab for step-to-step implementation of the project container-wise

## Steps to run the application:

#### Install [Docker](https://www.docker.com/) and ensure Docker is running.

Start the Application: `docker compose -f ./deployment/infra.yml -f ./deployment/apps.yml up -d` <br>
Endpoint-URL: [localhost:8080](http://localhost:8080/products?) <br>
Stop the Application:  `docker compose -f ./deployment/infra.yml -f ./deployment/apps.yml stop` <br>
Remove Containers: `docker compose -f ./deployment/infra.yml -f ./deployment/apps.yml rm -f` <br>


##### Install Taskfile for better managing of the application during development.
###### Follwoing command can be triggered from root of the application
`task start_infra` : ###### Starts only the dependent services in docker (PostgresSQL DB for 3 microservices, RabbitMQ, MailHog) post which 4 microservices (Catalog-Service, Order-Service, Notifications-Service, WebUI) can be manually run from GUI or using ./mvnw spring-boot:run command. <br>
`task start`: spin up all the services in docker. <br>
`task test` : Runs tests for all the microservices by running ./mvnw clean package internally. <br>
`task build` : Build docker image for all the microservices <br>

###### Access all the commands in Taskfile.yml


