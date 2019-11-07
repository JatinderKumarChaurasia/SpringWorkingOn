DROP DATABASE IF EXISTS `spring-security-data`;
CREATE DATABASE `spring-security-data`;
USE `spring-security-data`;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
    `username` varchar(50) not null,
    `password` varchar(50) not null,
    `enabled` tinyint(1) not null,
    constraint `pk_username` primary key (`username`)
)  engine=InnoDB default charset=latin1;
-- plaintext passwords are prefixed with {noop}
INSERT INTO `users` (`username`,`password`,`enabled`) values
    ("Absolute","{noop}absolute",1),
("Nick","{noop}nick",1),
("Williams","{noop}williams",1);

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