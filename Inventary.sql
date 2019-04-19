CREATE DATABASE IF NOT EXISTS `neszuz`
use `neszuz`;
CREATE TABLE IF NOT EXISTS `cuenta`(
	`ID` int(11) NOT NULL AUTO_INCREMENT,
	`contrasenia` varchar(20) DEFAULT NULL,

	PRIMARY KEY (`ID`)
	
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DELETE FROM `cuenta`;

INSERT INTO `cuenta` () VALUES ();


CREATE TABLE IF NOT EXISTS `producto`(
	`ID` int(11) NOT NULL AUTO_INCREMENT,
	`nombre` text,
	`uso` text,
	`fechaLlegada` date DEFAULT NULL,
	`precioProveedor` float(9,2) DEFAULT NULL,
	`precio_cliente` float(9,2) DEFAULT NULL,
	`proveedor` mediumtext,
	`tabla` mediumtext,
	`ganancia` float(9,2) DEFAULT NULL,

	PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DELETE FROM `producto`;

INSERT INTO `producto` () VALUES ();

CREATE TABLE IF NOT EXISTS `cliente`(
	`ID` int(11) NOT NULL AUTO_INCREMENT,
	`correo` tinytext,
	`telefono` int(8) NOT NULL AUTO_INCREMENT,

	PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DELETE FROM `cliente`;

INSERT INTO `cliente`() VALUES ();

CREATE TABLE IF NOT EXISTS `trabajador`(
	`ID` int(11) NOT NULL AUTO_INCREMENT,
	`direccion` text,
	`telefono` int(8) NOT NULL AUTO_INCREMENT,
	`correo` tinytext,
	`puesto`tinytext,

	`edad` int(2) NOT NULL,
	`nombre` tinytext,
	`apellido` tinytext,
	`username` tinytext,
	`contrasenia` varchar(20) DEFAULT NULL,
	PRIMARY KEY (`ID`)

) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DELETE FROM `trabajador`;

CREATE TABLE IF NOT EXISTS `trabajador`(
	`ID` int(11) NOT NULL AUTO_INCREMENT,
	`uso` text,
	`fechaLlegada` date DEFAULT NULL,
	`fechaVenta` date DEFAULT NULL,
	`precioProveedor` float(9,2) DEFAULT NULL,
	`precio cliente` float(9,2) DEFAULT NULL,
	`proveedor` mediumtext,
	/*tabla???*/
	`ganancia` float(9,2) DEFAULT NULL,

	PRIMARY KEY (`ID`)
	KEY `username` (`cuenta`),
	CONSTRAINT `trabajador_ibfk_1` FOREIGN KEY (`username`) REFERENCES `cuenta` (`ID`),
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DELETE FROM `trabajador`;

INSERT INTO `trabajador` () VALUES ();


CREATE TABLE IF NOT EXISTS `proyecto`(
	`ID` int(11) NOT NULL AUTO_INCREMENT,
	`nombre` tinytext,
	`fechaInicio` date DEFAULT NULL,
	`fechaTermina` date DEFAULT NULL,
	`duracion` int(2) NOT NULL AUTO_INCREMENT,
	`precio cliente` float(9,2) DEFAULT NULL,
	`descripcion` text, 

	PRIMARY KEY (`ID`)
	
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;












