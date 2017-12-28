
### DESCRIPTION

This application allows to make any CRUD operation on a Sport entity. Just for OCS interview purporse.

All sports that the application manages you are able to see it just below these lines 

Tecnologies used: Spring Boot, Java 1.8, MVN, AngularJS, MongoDB

In case you want to add a new Sport, 'Name' and 'Players' fields are mandatory. Once added, you would be able to inspected in the op of the screen 

In case you want to update a Sport, 'Id', 'Name' and 'Players' fields are mandatory. Once updated, you would be able to inspected in the top of the screen

In case you want to delete a Sport, 'Id' field is mandatory. Once removed, rest of the sports listed on the top of the screen. 

In case you want to find a Sport, if you specify an Id, that is the one retrieved, if empty all sports will be listed.

### Technology Stack

Spring Boot, no-xml Spring MVC 3 web application for Servlet 3.0 environment
Spring Data MongoDB
Database (MongoDB, embedded MongoDB, MongoLab)
Thymeleaf templates with added Joda Time & Spring Security Dialects
Heroku fully cloud deployable
Java 8,  Maven 3,  Java 1.8 etc

### Compatibility
MongoDB version v3.x.x
Java 1.8
spring-boot-starter-parent 1.5.9
AngularJS >1.2


### Live Demo

Be aware that this application is currently running on a free Heroku account. If it hasn't been accessed in 30 minutes, then the first request will take up to 120 seconds. Note that the demo application might fail to load altogether if the Heroku servers are busy.


### Local Deployment

$ mvn clean install  
$ mvn spring-boot:run
Navigate to http://localhost:8080.

The application can also be deployed by running the Application.java class.

###Deploying to Heroku

The following steps require that the Heroku CLI has been installed locally and that a Heroku account has been created.

Navigate to the project directory on the command line.

Before creating your Heroku application, make sure that there is a Git repository associated with the project.

$ git status
If a Git repository is not associated with the project, then create one before continuing.

Create a new application on Heroku

$ heroku create
Rename your Heroku application if interested

$ heroku apps:rename new-name
Add a MongoDB database to your Heroku application with MongoLab. Note that your Heroku account must have a credit card attached in order to use free add-ons other than the PostgreSQL and MySQL add-ons.

$ heroku addons:create mongolab:sandbox
Retrieve your MongoDB database name by clicking on the MongoLab addon. Place the database name into the src/main/resources/config/application-prod.yml configuration file in the database field.

Create a new collection by clicking on the MongoLab addon.
Click on the Add collection button.
Create a collection named sport

Deploy project to Heroku.

$ git push heroku master
Look at your application logs to see what is happening behind the scenes.

$ heroku logs
If your application deploys without timing out then open it as follows.

$ heroku open


