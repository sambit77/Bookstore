# Bookstore Application
##### Please refer Projects tab for step-to-step implementation of the project container-wise

## Steps to run the application:

#### Install [Docker](https://www.docker.com/) and ensure Docker is running.

Start the Application: `docker compose -f ./deployment/infra.yml -f ./deployment/apps.yml up -d` <br>
Endpoint-URL: [localhost:8080](http://localhost:8080/products?) <br>
Stop the Application:  `docker compose -f ./deployment/infra.yml -f ./deployment/apps.yml stop` <br>
Remove Containers: `docker compose -f ./deployment/infra.yml -f ./deployment/apps.yml rm -f` <br>

