# Bookstore
##### Please refer Projects tab for step-to-step implementation of the project container-wise

## Steps to run the application:

#### Install Docker and ensure Docker is running.

#### Start the Application: `docker compose -f ./deployment/infra.yml -f ./deployment/apps.yml up -d`

#### Stop the Application:  `docker compose -f ./deployment/infra.yml -f ./deployment/apps.yml stop`
#### Remove Containers: `docker compose -f ./deployment/infra.yml -f ./deployment/apps.yml rm -f`

