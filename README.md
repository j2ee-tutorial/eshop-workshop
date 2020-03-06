# E-SHOP WORKSHOP
A workshop based on react as frontend and spring boot as backend

## DATABASE CONFIGURATION
### MARIADB
````
$mysql -u root -p
CREATE DATABASE tasnim;
CREATE USER tasnim@localhost IDENTIFIED BY '123456';
GRANT ALL PRIVILEGES ON tasnim.* TO tasnim@localhost;
SHOW GRANTS FOR tasnim@localhost;
````
