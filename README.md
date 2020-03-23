# E-SHOP WORKSHOP
A workshop based on react as frontend and spring boot as backend

## DATABASE CONFIGURATION
### MARIADB
#### CREATE USER
````
$mysql -u root -p
CREATE DATABASE tasnim;
CREATE USER tasnim@localhost IDENTIFIED BY '123456';
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
