CREATE TABLE users (
                         user_id int NOT NULL AUTO_INCREMENT,
                         email varchar(45),
                         username varchar(45) NOT NULL,
                         password varchar(64) NOT NULL,
                         enabled int DEFAULT NULL,
                         PRIMARY KEY (user_id)
);

CREATE TABLE roles (
                         role_id int NOT NULL AUTO_INCREMENT,
                         name varchar(45) NOT NULL,
                         PRIMARY KEY (role_id)
);

CREATE TABLE users_roles (
                               user_id int NOT NULL,
                               role_id int NOT NULL,
                               PRIMARY KEY (user_id,role_id),
  CONSTRAINT role_fk FOREIGN KEY (role_id) REFERENCES roles (role_id),
  CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE products (
                       product_id int NOT NULL AUTO_INCREMENT,
                       name varchar(45) NOT NULL,
                       brand varchar(45),
                       madein varchar(45),
                       price float,
                       PRIMARY KEY (product_id)
);