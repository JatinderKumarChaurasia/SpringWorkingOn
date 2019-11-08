DROP DATABASE IF EXISTS `spring_security_custom_user_registration`;
CREATE DATABASE `spring_security_custom_user_registration`;
USE `spring_security_custom_user_registration`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
    `id` int(20) not null auto_increment,
    `username` varchar(50) not null,
    `password` char(100) not null,
    `firstname` varchar(100) not null,
    `lastname` varchar(100) not null,
    `email` varchar(100) not null,
    constraint `pk_user_id` primary key (`id`)
)  engine=InnoDB auto_increment=1 default charset=latin1;

INSERT INTO `user` (`username`,`password`,`firstname`,`lastname`,`email`) values
   ("Absolute","{bcrypt}$2a$10$0CDq0LLKWXZrWh5cVuGwMuIoT5FyXFCKKUHrhDPMBQmci1AH1Rlo6","Absolute","Vaisa","absolute@mail.com"),
("Nick","${bcrypt}$2a$10$2EOl3neZquO5mN1DTun4sO9BLzKUG5WPmBcSH/OLv29CIba/Iec5q","Nick","Richards","nick@mail.com"),
("William","${bcrypt}$2a$10$0iSMpgLUugtLGefNAf/NnedXN0DbWzfEBUW2zVREZ1B5D2VtFQE4i","William","Cameron","william@mail.com");

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
    `id` int(20) not null auto_increment,
    `name` varchar(50) default null,
    constraint `pk_role_id` primary key (`id`)
)  engine=InnoDB auto_increment=1 default charset=latin1;

INSERT INTO `role` (`name`)
VALUES 
('ROLE_EMPLOYEE'),('ROLE_MANAGER'),('ROLE_ADMIN');

DROP TABLE IF EXISTS `users_roles`;

CREATE TABLE `users_roles` (
    `user_id` int(20) not null,
    `role_id` int(20) not null,
    constraint `pk_user_id_role_id` primary key (`user_id` , `role_id`),
  --  KEY `FK_ROLE_idx` (`role_id`),
    constraint `fk_user_id` foreign key (`user_id`)
        references `user` (`id`)
        on delete no action on update no action,
    constraint `fk_role_id` foreign key (`role_id`)
        references `role` (`id`)
        on delete no action on update no action
)  engine=InnoDB default charset=latin1;

INSERT INTO `users_roles` (user_id,role_id)
VALUES 
(1, 1),
(2, 1),
(2, 2),
(3, 1),
(3, 3)