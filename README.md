# Real-Time-Streaming

This is a project done for a task assigned to me by Inery Blockchain for a backend position

The repository contains a software solution implemented in the Java programming language using the Java Spring framework. The application tries to process the stream of data from Wikimedia.org and distribute the data to the database.
the initial project mandated that the application be able to scale horizontally as needed, as well as to use distributed computing for data processing, the database should have been distributed as well, but due to the fact that today is 9/3/2023 which is deadline for the development of this solution, I am required to submit a modified solution. Because of this topic need to be deeply researched and because of the knowledge that I had to acquire during research before starting work on the project and due to various bugs in software development that I encountered, I had to shorten the functionality in order to meet the deadline.
The solution is implemented using the Kafka distributed event streaming platform and java code, the data is stored in the MySql database. For distributed computing I planned and tried to implement Apache Spark and for distributed data storage I initially chose Cassandra distributed system.

To run this application, Apache Zookeeper, Apache Kafka as well as Java 8 must be installed on the Windows operating system.
First, you need to start zookeeper from cmd in the kafka/bin/windows folder with the command: 
zookeeper-server-start.bat ../../config/zookeeper.properties

Then, to start Kafka, start cmd from the same folder and enter the command: 
kafka-server-start.bat ../../config/server.properties

For the database, you just need to create a database under the name wikimedia and then create a simple table with the command:
CREATE TABLE `wikimedia`.`wikimedia_recent` (
   `Id` BIGINT NOT NULL AUTO_INCREMENT,
   `wiki_event_data` LONGTEXT NULL,
   PRIMARY KEY (`Id'));

When the Producer application is started in the Real-Time-Processing folder, the service that reads stream data from Wikimedia.org in real-time is started.
When the Consumer application is started, the service that consumes data from the Producer stream and places it in the database is activated
