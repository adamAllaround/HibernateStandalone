# Setting up Hibernate Java application

This project shows how to set up Java application with Hibernate and can be used as a template for Hibernate projects. Details of setting up Hibernate with Java are described in the following article on allaroundjava.com. [How to setup Java application with Hibernate](https://allaroundjava.com/)

## How to run the project
* Fork the repository
* Import code as a Maven project to your IDE
* Setup a database to run with the application
* Adjust *persistence.xml* connection properties to match your database
* Run test class - CarDaoTest

## How to set up database 
For the purpose of this tutorial I used MySql database, but you're free to use any vendor you desire. In order to create Car table I used the following DDL Query: 

```CREATE TABLE Car (     id int PRIMARY KEY NOT NULL AUTO_INCREMENT,      make varchar(100) NOT NULL,      model varchar(100) not null,      manufactured_at datetime not null  ); ```

Alternatively you can order Hibernate to drop and recreate the schema on application startup with following property. Place it in persistence.xml under properties section. 

```<property name="javax.persistence.schema-generation.database.action" value="drop-and-create"/>```

### Don't forget to visit [allAroundJava](https://allaroundjava.com/) for more Java tutorials and analyses. 

Good luck !