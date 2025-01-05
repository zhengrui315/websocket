### Introduction

This repository implements a chatbot using SpringBoot that supports sending messages to connected users using WebSocket. 

### Run the Application

There are multiple ways to start a SpringBoot application.
#### Maven
Enter the `chat` directory and run the following commands
```declarative
mvn clean package # re-build the jar file
java -jar target/chat-1.0-SNAPSHOT.jar
```


#### Docker
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


#### Docker compose


