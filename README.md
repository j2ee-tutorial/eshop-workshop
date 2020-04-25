# E-SHOP WORKSHOP
A workshop based on react as frontend and spring boot as backend

## DATABASE CONFIGURATION
### MARIADB
#### CREATE USER
````
$mysql -u root -p
CREATE DATABASE tasnim;
CREATE USER tasnim@localhost IDENTIFIED BY '123456';
SELECT user, host FROM mysql.user;
GRANT ALL PRIVILEGES ON tasnim.* TO tasnim@localhost;
SHOW GRANTS FOR tasnim@localhost;
````
#### TABLES
````
MariaDB [tasnim]> show columns from users;
+----------+--------------+------+-----+---------+-------+
| Field    | Type         | Null | Key | Default | Extra |
+----------+--------------+------+-----+---------+-------+
| username | varchar(255) | NO   | PRI | NULL    |       |
| email    | varchar(255) | YES  |     | NULL    |       |
| password | varchar(255) | YES  |     | NULL    |       |
+----------+--------------+------+-----+---------+-------+
````

## Spring Security with JWT
### Spring Security Entry Point
By default, the BasicAuthenticationEntryPoint provisioned by Spring Security returns 
a full page for a 401 Unauthorized response back to the client. This HTML representation 
of the error renders well in a browser, but it not well suited for other scenarios, 
such as a REST API where a json representation may be preferred.

