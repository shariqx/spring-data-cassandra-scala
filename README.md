# SpringBoot-Data-Cassandra-Scala
This repository demonstrate the usage of SpringData with Cassandra Datastax driver, compiled with Scala.  A simple Student respository with webservices to
The build is packed with gradle. Scroll down for Installation.

Concepts illustrated in the code (origin/master):
  -  ORM based access to the Database
  -  Dynamic query generation
  - AutoWiring of Service and Repositories
  - Entity-Json auto mapping using Spring Framework

# Installation
0 - Install Cassandra
```sh
https://www.guru99.com/download-install-cassandra.html
```
1 - Install Gradle

2 - Clone the project:
```sh
$ git clone https://github.com/shariqx/spring-data-cassandra-scala.git
```
 3 - Cd into spring-data-cassandra-scala, Build the project:
 ```sh
$ gradle build
```
.... or better yet, use intellij and import as  a gradle project.

5 - Make necessary change for keyspance and contact-points  in application.yaml:
```sh
spring:
   data:
	  cassandra: keyspace-name: test
	     contact-points: localhost
```
6- Run DDL/DML from the queries.sql file
```sh
1.CREATE KEYSPACE  IF NOT EXISTS TEST
WITH replication = {'class': 'SimpleStrategy',.....
2.CREATE TABLE IF NOT EXISTS test.STUDENT (
	STUDENTID INT,
	STUDENTCLASS ASCII, ....
3.INSERT INTO TEST.STUDENT (STUDENTID, STUDENTCLASS,...
```
4 - Run the project:
The build should automatically run the Main class, however, to do so manually, Run the Main.scala file

# Roadmap
  - Add Tests
  - Add templats for webservice outputs for pure MVC
  - Reactive Cassandra support for Streaming data access
  - Caching
  - Custom Query support demonstration with `@Query`
  - Abstract Factory pattern impl for mutidatabase support.

 # Contributions
I wish to make this repository a go-to for SpringBoot-Scala code samples, please make a pull request if you wish to contribute to any action item in the roadmap, or your own implementation of the plugin provided by springboot.

