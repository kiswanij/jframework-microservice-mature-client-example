# JKFramework Mature MicroServie ClientExample
_Last updated: 2022-11-26_


This repository contains a _JKFramework-SerivceClient_ that commnicates with a mature microservice

## Prerequisites:
- JDK 17+ Installed
- [MatureMicroserive is running](https://github.com/kiswanij/jk-framework-microservice-mature-example)

## Usage:
1. Clone the repository
2. Import as Java project into your favorite IDE (we use _SpringToolSuite_ and _Eclipse-JavaEE_)
3. Run `App` class.

## Project Main Contents 
The repository  contains the following main contents: 
1. Maven project with [pom.xml](pom.xml)
  > :page_facing_up:*Note*: If you are using Eclipse, be sure to refresh your project (select your project→ right click→ Maven→ Update Project)
2. [Config file](src/main/resources/config.properties) which contains the service url config.
3. [Model class](src/main/java/com/app/person/Model.java) which is contains the model fields.
4. [ServiceClient](src/main/java/com/app/person/ServiceClient.java) which is the client used to communicate with the backend. 
5. [App class](src/main/java/com/app/App.java)  

