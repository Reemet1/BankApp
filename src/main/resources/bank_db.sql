DROP SCHEMA IF EXISTS `bank`;

CREATE SCHEMA `bank`;

use `bank`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `clients`;
CREATE TABLE `clients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `details_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,

  PRIMARY KEY (`id`),
  FOREIGN KEY (details_id) REFERENCES client_details(id),
  FOREIGN KEY (user_id) REFERENCES users(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `client_details`;
CREATE TABLE `client_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) DEFAULT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `personal_id` varchar(45) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `address_1` varchar(45) DEFAULT NULL,
  `address_2` varchar(45) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,

  PRIMARY KEY (`id`),
  FOREIGN KEY (client_id) REFERENCES clients(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `details_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,

  PRIMARY KEY (`id`),
  FOREIGN KEY (details_id) REFERENCES employee_details(id),
  FOREIGN KEY (user_id) REFERENCES users(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `employee_details`;
CREATE TABLE `employee_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `personal_id` varchar(45) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `address_1` varchar(45) DEFAULT NULL,
  `address_2` varchar(45) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,

  PRIMARY KEY (`id`),
  FOREIGN KEY (employee_id) REFERENCES employees(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL UNIQUE,
  `password` varchar(45) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,

  PRIMARY KEY (`id`),
  FOREIGN KEY (client_id) REFERENCES clients(id),
  FOREIGN KEY (employee_id) REFERENCES employees(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_number` varchar(45) DEFAULT NULL,
  `balance` float(11,2) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  `limit_id` int(11) DEFAULT NULL,

  PRIMARY KEY (`id`),
  FOREIGN KEY (client_id) REFERENCES clients(id),
  FOREIGN KEY (limit_id) REFERENCES limits(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `cards`;
CREATE TABLE `cards` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `holder_id` int(11) DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL,
  `card_number` varchar(45) DEFAULT NULL,
  `valid_until` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (holder_id) REFERENCES clients(id),
  FOREIGN KEY (account_id) REFERENCES accounts(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `transactions`;
CREATE TABLE `transactions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sender_id` int(11) DEFAULT NULL,
  `receiver_id` int(11) DEFAULT NULL,
  `sender_account_id` int(11) DEFAULT NULL,
  `receiver_account_id` int(11) DEFAULT NULL,
  `amount` float(11,2) DEFAULT NULL,
  `datetime` datetime DEFAULT NULL,
  `invoice` varchar(45) DEFAULT NULL,
  `comment` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (sender_id) REFERENCES clients(id),
  FOREIGN KEY (receiver_id) REFERENCES clients(id),
  FOREIGN KEY (sender_account_id) REFERENCES accounts(id),
  FOREIGN KEY (receiver_account_id) REFERENCES accounts(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `limits`;
CREATE TABLE `limits` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) DEFAULT NULL,
  /*`card_id` int(11) DEFAULT NULL, */
  `type` varchar(45) DEFAULT NULL,
  `transaction_limit` float(11,2) DEFAULT NULL,
  `daily_limit` float(11,2) DEFAULT NULL,
  `monthly_limit` float(11,2) DEFAULT NULL,

  PRIMARY KEY (`id`),
  /*FOREIGN KEY (card_id) REFERENCES cards(id), */
  FOREIGN KEY (account_id) REFERENCES accounts(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `documents`;
CREATE TABLE `documents` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(45) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  `file` blob DEFAULT NULL,

  PRIMARY KEY (`id`),
  FOREIGN KEY (client_id) REFERENCES clients(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `loans`;
CREATE TABLE `loans` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `loan_amount` float(11,2) DEFAULT NULL,
  `interest_rate` float(11,2) DEFAULT NULL,
  `total_payback_time` int(11) DEFAULT NULL,
  `payback_amount` float(11,2) DEFAULT NULL,
  `monthly_payment_amount` float(11,2) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `contract_id` int(11) DEFAULT NULL,

  PRIMARY KEY (`id`),
  FOREIGN KEY (client_id) REFERENCES clients(id),
  FOREIGN KEY (contract_id) REFERENCES documents(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(45) DEFAULT NULL,

  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,

  PRIMARY KEY (`id`),
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (role_id) REFERENCES roles(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `fees`;
CREATE TABLE `fees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(45) DEFAULT NULL,
  `amount` float(11,2) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,

  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
