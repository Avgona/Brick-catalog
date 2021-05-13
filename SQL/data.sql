CREATE DATABASE `assingment`;

CREATE TABLE `bricks` (
  `id` int NOT NULL AUTO_INCREMENT,
  `color` varchar(45) NOT NULL,
  `amount_of_bricks` int NOT NULL,
  `amount_of_pallets` float NOT NULL,
  `amount_of_bricks_in_pallet` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `color_UNIQUE` (`color`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `bricks` VALUES
	(1,'red','5000','50', 100),
	(2,'yellow','5000','71.4286', 70),
	(3,'black','5000','20', 250);

CREATE TABLE `reservations` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nickname` varchar(45) DEFAULT NULL,
  `type_of_client` varchar(45) NOT NULL,
  `id_of_brick` int NOT NULL,
  `amount_of_bricks` int DEFAULT NULL,
  `amount_of_pallets` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

