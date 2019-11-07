DROP DATABASE IF EXISTS `spring-security-data_bcrypt`;
CREATE DATABASE `spring-security-data_bcrypt`;
USE `spring-security-data_bcrypt`;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
    `username` varchar(50) not null,
    `password` char(68) not null,
    `enabled` tinyint(1) not null,
    constraint `pk_username` primary key (`username`)
)  engine=InnoDB default charset=latin1;
-- password encrypted using bcrypt are prefixed with {bcrypt}
-- plaintext passwords are prefixed with {noop}
INSERT INTO `users` (`username`,`password`,`enabled`) values
    ("Absolute","{bcrypt}$2a$10$MGEEWkmZ4Tzegil5eIyQqe6sHYAMOXHEm0rph0siCf1xzUfQBOBUq",1),
("Nick","{bcrypt}$2a$10$QcTQrbV6T5PMZwzrzmocCeAhYf/0EYRFIHLhULR/Kr6uVYVsv0wFm",1),
("Williams","{bcrypt}$2a$10$vZp8xezp7OsOQ.QojB8q6O9s9LLCqK8uLbULuowhNSH0GIMHxkE1u",1);

DROP TABLE IF EXISTS `authorities` ;
CREATE TABLE `authorities` (
    `username` varchar(50) not null,
    `authority` varchar(100) not null,
    constraint `uq_user_role` UNIQUE KEY (`username` , `authority`),
    constraint `fk_username` foreign key (`username`)
        references `users` (`username`)
)  engine=InnoDB default charset=latin1;

INSERT INTO `authorities` (`username`,`authority`) values
   ("Absolute","ROLE_EMPLOYEE"),
("Nick","ROLE_EMPLOYEE"),
("Nick","ROLE_MANAGER"),
("Williams","ROLE_EMPLOYEE"),
("Williams","ROLE_ADMIN");