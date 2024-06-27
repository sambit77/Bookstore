# Bookstore Application
##### Please refer Projects tab for step-to-step implementation of the project container-wise

## Steps to run the application:
#### Install [Docker](https://www.docker.com/) and ensure Docker is running.
1. Clone the repository: `git clone https://github.com/sambit77/Bookstore.git && cd Bookstore`
2. Start the Application: `docker compose -f ./deployment/docker-compose/infra.yml -f ./deployment/docker-compose/apps.yml up -d` <br>
3. Endpoint-URL: [localhost:8080](http://localhost:8080/products?) <br>
4. Stop the Application:  `docker compose -f ./deployment/docker-compose/infra.yml -f ./deployment/docker-compose/apps.yml stop` <br>
5. Remove Containers: `docker compose -f ./deployment/docker-compose/infra.yml -f ./deployment/docker-compose/apps.yml rm -f` <br>


##### Install [Taskfile](https://taskfile.dev/) for better managing of the application during development.
###### Follwoing command can be triggered from root of the application
1. `task start_infra` : Starts only the dependent services in docker (PostgresSQL DB for 3 microservices, RabbitMQ, MailHog) post which 4 microservices (Catalog-Service, Order-Service, Notifications-Service, WebUI) can be manually run from GUI or using ./mvnw spring-boot:run command. <br>
2. `task start`: spin up all the services in docker. <br>
3. `task test` : Runs tests for all the microservices by running ./mvnw clean package internally. <br>
4. `task build` : Build docker image for all the microservices <br>

###### Access all the commands in Taskfile.yml
 

