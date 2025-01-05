## Introduction

This repository implements a chatbot using SpringBoot that supports sending messages to connected users using WebSocket. 

## Run the Application

There are multiple ways to start a SpringBoot application.
### Maven in local machine
Enter the `chat` directory and run the following commands
```declarative
mvn clean package # re-build the jar file
java -jar target/chat-1.0-SNAPSHOT.jar
```


### Docker
Make sure docker is installed in the host machine by checking `docker -v`. 

First, build the image named "chat-app"
```declarative
docker build -t chat-app .
```

Then, create a container named "chat-container"
```declarative
docker run -p 8080:8080 chat-container chat-app
```
the port 8080 on the host machine is mapped to the port 8080 inside the container. 


### Docker compose
Start all services
```declarative
docker compose up 
```
or 
```declarative
docker compose up --build
```
if rebuilding is needed.
Verify the containers by `docker ps`. To enter into the bash environment of a specific container, run `docker exec -it mysql_db bash`. 
Now the app is already running in a docker container and the endpoints can be accessed at the exposed port 8080. 

To start the command in detached mode, add `-d` flag at the end. To shut down the containers, run `docker compose down` or `docker compose down -v` to remove the volume. 

A MySQL service is included in `docker-compose.yml` for durable data storage. A docker volume is created which is mirrored in the host machine. List the volumes by
```declarative
docker volume ls
```
and then check the detail of the volume by 
```declarative
docker volume inspect chat_db_data
```
here `chat_db_data` is the volume name defined in `docker-compose.yml`. 



## Plan
- [x] Broadcast messages to all users.
- [ ] Send the message only to a specific recipient
- [ ] Implement a message queue such as RabbitMQ or ActiveMQ.
- [ ] Launch to GCP platform.



