# ************************************************************
# Sequel Pro SQL dump
# Versión 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: localhost (MySQL 5.7.15)
# Base de datos: asf_anuncios
# Tiempo de Generación: 2016-10-31 10:05:22 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Volcado de tabla Anuncio
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Anuncio`;

CREATE TABLE `Anuncio` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `category_id` int(11) unsigned DEFAULT NULL,
  `creator_id` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `category` (`category_id`),
  KEY `creator` (`creator_id`),
  CONSTRAINT `category` FOREIGN KEY (`category_id`) REFERENCES `Categoria` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `creator` FOREIGN KEY (`creator_id`) REFERENCES `Usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `Anuncio` WRITE;
/*!40000 ALTER TABLE `Anuncio` DISABLE KEYS */;

INSERT INTO `Anuncio` (`id`, `name`, `description`, `price`, `category_id`, `creator_id`)
VALUES
	(1,'SEAT Ibiza SC','Con todos los filtros recién cambiados y distribución recién hecha.',6900,31,43),
	(29,'VW Passat','Coche familiar con muchas comodidades, recién pintado.',10000,31,45),
	(31,'AMD Radeon R9 390','Poco uso, la vendo por que cambio a una más potente.',125,31,47),
	(33,'TV Samsung 4K','50\" muy bien cuidada',200,31,47);

/*!40000 ALTER TABLE `Anuncio` ENABLE KEYS */;
UNLOCK TABLES;


# Volcado de tabla Categoria
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Categoria`;

CREATE TABLE `Categoria` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `Categoria` WRITE;
/*!40000 ALTER TABLE `Categoria` DISABLE KEYS */;

INSERT INTO `Categoria` (`id`, `name`, `description`)
VALUES
	(31,'Technology','Dispositivos electrónicos y gadgets'),
	(70,'Automóviles','Vehiculos comerciales y particulares');

/*!40000 ALTER TABLE `Categoria` ENABLE KEYS */;
UNLOCK TABLES;


# Volcado de tabla Usuario
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Usuario`;

CREATE TABLE `Usuario` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `signup_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;

INSERT INTO `Usuario` (`id`, `email`, `password`, `name`, `signup_date`)
VALUES
	(43,'aitor.brazaola@opendeusto.es','df75lss72','Aitor','2016-10-30 13:34:02'),
	(45,'ibon.arretxe@gmail.com','fdfdsdf2','Ibon','2016-10-30 16:50:19'),
	(47,'javi.pelaez@outlook.com','654nvcuy2','Javi','2016-10-30 16:52:41');

/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
