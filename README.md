# twitter-conversation-consumer

An application designed to consume events as part of an end-to-end streaming pipeline and save them to an in-memory H2 database.   
The events being consumed are twitter conversations i.e. tweets that are posted in response to other tweets as opposed to original tweets that have not had replies.  

## Technologies

Uses Spring Boot with Java 11, Gradle, Spring Kafka, Spring Data JPA, H2 Database and Lombok.

## Pre-requisites

Sign up for a confluent cloud account and follow documents/tutorials for configuring application properties with [Confluent Developer](https://developer.confluent.io/).
