# CZ3002 assignment 2: Login application with struts 2 and MySQL database

## Requirements 
1. Java jdk 
2. maven
3. mysql 
4. mysql jdbc driver

## Windows set up
### Set up
2. add JAVA_HOME into sys environment (Eg. `C:\Progra~1\Java\jdk-12.0.1`)
3. add MAVEN_HOME into sys environment (Eg. `C:\Progra~1\apache-maven-3.6.3`)
4. add path: `%MAVEN_HOME%\bin;` to environment 

### Set up MySQL database
1.	Download MySQL Community Server "ZIP ARCHIVE" from https://dev.mysql.com/downloads/mysql/:
    - Under "Other Downloads", download "Windows (x86, 64-bit), ZIP ARCHIVE (mysql-8.0.{xx}-winx64.zip)". <br>

2.	UNZIP the downloaded file into your project directory `"C:\MySQL"`. MySQL will be unzipped as `"c:\MySQL\mysql-8.0.{xx}-winx64"`. <br>
    - For EASE OF USE, we shall shorten and rename the directory to `"c:\MySQl\mysql"`. Take note and remember your MySQL installed directory!!! <br>

3.	(NEW since MySQL 5.7.7) Initialize the database: Start a CMD (as administrator) ("Search" button ⇒ Enter "cmd" ⇒ Right-Click on "Command Prompt" ⇒ Run as Administrator) and issue these commands: <br>
	- Change directory to the MySQL's binary directory<br>
	- Eg. Suppose that your MySQL is installed in "c:\MySQL\mysql" `cd \MySQL\mysql\bin` <br>
	 
4.  Initialize the database. Create a root user with random password & show the messages on console.
    `mysqld --initialize --console` <br>
    - A temporary password is generated for root@localhost: xxxxxxxx <br>
    - During the installation, a superuser called root is created with a temporary password, as shown above. TAKE NOTE of the PASSWORD, COPY and SAVE it somewhere, and also TAKE A PICTURE!!! <br>
   
5.	If you make a mistake or forgot your password, DELETE the entire MySQL directory "C:\MySQL\mysql", and REPEAT step 2 and 3. <br>

6. Startup server
    - Change the current directory to MySQL's binary directory <br>
    - Eg. Assume that the MySQL installed directory is "c:\MySQL\mysql" `cd \MySQL\mysql\bin` <br>
     
    - Start the MySQL Database Server `mysqld --console` <br>  
    
7. Start client 
    - Change the current directory to MySQL's binary directory <br>
    - Eg. Assume that the MySQL installed directory is "c:\MySQL\mysql" `cd \MySQL\mysql\bin` <br>
       
    - Start a client as superuser "root" (-u), and prompt for password `mysql -u root -p` <br>
    
8. To change password: ` alter user 'root'@'localhost' identified by 'xxxx';` <br>

9. To create new user: ` create user 'myuser'@'localhost' identified by 'xxxx';` <br>
   To grant permission to new user: `grant all on *.* to 'myuser'@'localhost';` <br>

10. change setting in code. go to src -> main -> java -> model -> authentication.java  <br>
    In line 26, change the user and password according to your mysql account that is set up above <br>
    
    
### Load script into database (mySQL) - assuming my sql is already set up: 
1. start server <br>
`cd ..\mysql\bin` <br>
`mysqld --console`

2. start client <br>
`cd ..\mysql\bin` <br>
`mysql -u myuser -p`  <br>
myuser is username. password will be requested.

3. run script <br>
`source ..\login\db.sql;`


## How to run? <br>
`mvn jetty:run` into terminal 

Website: `http://localhost:8080/login/view/login.jsp`


