CREATE DATABASE OnlineMealOrderingDB
USE OnlineMealOrderingDB
--create tables
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager`(
 `manager_id` int NOT NULL AUTO_INCREMENT,
 `name` varchar(30) NOT NULL,
 `username` varchar(30) NOT NULL UNIQUE,
 `password` varchar(20) NOT NULL,
 PRIMARY KEY (manager_id)   
)
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`(
 `menu_id` int NOT NULL AUTO_INCREMENT,
 `resturant_name` varchar(30) NOT NULL,
 `manager_id` int NOT null,
 PRIMARY KEY (menu_id),
 FOREIGN KEY (manager_id) REFERENCES manager(manager_id)
)
DROP TABLE IF EXISTS `dish`;
CREATE TABLE `dish`(
    `dish_id` int NOT NULL AUTO_INCREMENT,
    `menu_id` int NOT NULL,
    `price` float NOT NULL,
    `name` varchar(40) NOT NULL,
    `description` text,
    `picture` text,
    PRIMARY KEY (dish_id),
    FOREIGN key (menu_id) REFERENCES menu(menu_id)
)
