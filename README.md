# Consumer
> 

## Table of Contents
* [General Info](#general-information)
* [Technologies Used](#technologies-used)
* [Setup](#setup)
* [Project Status](#project-status)
* [Room for Improvement](#room-for-improvement)


## General Information
- This project will consume  the data from topics and injest that into mongoDB.

## Technologies Used
- Java - version 1.8
- Spring Boot - version 2.5.3
- Apache Kafka 
- MongoDB 


## Setup
project requirements/dependencies.
Open application.properties and replace database name,Database IP,server.port and Kafka Server IP and Port with your details.

spring.data.mongodb.uri=mongodb://localhost:27017/eco
spring.kafka.bootstrap-servers:localhost:9092
server.port=8081




