# CZ3002 assignment 2: Login application with struts 2 and MySQL database

## Requirements 
1. Java jdk 
2. maven
3. mysql 
4. mysql jdbc driver

## Set up
2. add JAVA_HOME into sys environment (Eg. `C:\Progra~1\Java\jdk-12.0.1`)
3. add MAVEN_HOME into sys environment (Eg. `C:\Progra~1\apache-maven-3.6.3`)
4. add path: `%MAVEN_HOME%\bin;` to environment 

## Load script into database (mySQL) - assuming my sql is already set up: 
1. start server <br>
`cd ..\mysql\bin` <br>
`mysqld --console`

2. start client <br>
`cd ..\mysql\bin` <br>
`mysql -u myuser -p` myuser is username. password will be requested.

3. run script <br>
`source ..\login\db.sql;`

## How to run? <br>
`mvn jetty:run` into terminal 

Website: `http://localhost:8080/login/view/login.jsp`


