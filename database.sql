CREATE DATABASE IF NOT EXISTS `neszuz`;
use `neszuz`; 

-- ---- TABLA DE PROYECTOS ----

CREATE TABLE IF NOT EXISTS `proyecto`(
	`idProyecto` int(11) NOT NULL AUTO_INCREMENT,
	`nombre` varchar(100) NOT NULL,
	`fechaDeInicio` datetime NOT NULL,
	`fechaDeTermino` datetime NOT NULL, 
	`duracion` int(6) DEFAULT 0, 
	`descripcion` text,

	PRIMARY KEY (`idProyecto`)
	
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DELETE FROM `proyecto`;

INSERT INTO `proyecto` (`idProyecto`,`nombre`,`fechaDeInicio`,`fechaDeTermino`,`duracion`,`descripcion`) VALUES 
(50,'Proyecto Final','2019-04-19 10:34:09.000' ,'2020-04-19 10:34:09.000' ,365,'Proyecto Final!'),
(30,'Proyecto Parcial','2019-04-19 10:34:09.000' ,'2021-04-19 10:34:09.000' ,730,'Proyecto Parcial!');

-- ---- TABLA DE CUENTA ----

CREATE TABLE IF NOT EXISTS `cuenta`(
	`ID` int(21) NOT NULL AUTO_INCREMENT,
	`contrasenia` varchar(20) DEFAULT NULL,

	PRIMARY KEY (`ID`)
	
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DELETE FROM `cuenta`;

INSERT INTO `cuenta` (`ID`,`contrasenia`) VALUES 
(1,'neszuz'),
(2,'neszuz');
-- ---- TABLA DE TRABAJADORES ----

CREATE TABLE IF NOT EXISTS `trabajador`(
	`idTrabajador` int(11) NOT NULL AUTO_INCREMENT,
	`direccion` text, 
	`telefono` int (8) NOT NULL,
	`correo` tinytext, 
	`puesto` tinytext, 
	`edad` int (2) NOT NULL,
	`nombre` varchar(100) NOT NULL,
	`apellido` varchar(100) NOT NULL,
	`cuenta` int(21) NOT NULL,
	`contrasenia` varchar(20) NOT NUll, 

	PRIMARY KEY (`idTrabajador`),
	KEY `cuenta` (`cuenta`),
	CONSTRAINT `trabajador_ibfk_1` FOREIGN KEY (`cuenta`) REFERENCES `cuenta` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DELETE FROM `trabajador`;

INSERT INTO `trabajador` (`idTrabajador`,`direccion`,`telefono`,`correo`,`puesto`,`edad`,`nombre`,`apellido`,`cuenta`,`contrasenia`) VALUES 
(30, 'Anahuac #100', 50129390, 'ruben@hotmail.com', 'distribuidor', 22, 'Ruben', 'Salazar', 1,'neszuz'),
(31, 'Mirador #52', 51699657, 'alan@hotmail.com', 'contador', 25, 'Alan', 'Zavala', 2,'neszuz');

-- ---- TABLA DE TRABAJADORES Y PROYECTOS ----

CREATE TABLE IF NOT EXISTS `trabajador_proyecto`(
	`idTrabajador` int(11) NOT NULL,
	`idProyecto` int(11) NOT NULL, 

	PRIMARY KEY (`idTrabajador`,`idProyecto`),
	KEY `idProyecto` (`idProyecto`),
	KEY `idTrabajador` (`idTrabajador`),
	CONSTRAINT `trabajador_proyecto_ibfk_1` FOREIGN KEY (`idTrabajador`) REFERENCES `trabajador` (`idTrabajador`),
	CONSTRAINT `trabajador_proyecto_ibfk_2` FOREIGN KEY (`idProyecto`) REFERENCES `proyecto` (`idProyecto`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DELETE FROM `trabajador_proyecto`;

-- ---- TABLA DE PRODUCTOS ----

CREATE TABLE IF NOT EXISTS `producto`(
	`idProducto` int(11) NOT NULL AUTO_INCREMENT,
	`Uso` varchar(100) NOT NULL,
	`fechaDeLlegada` datetime NOT NULL,
	`fechaDeVenta` datetime NOT NULL, 
	`precioProveedor` float(9,2) DEFAULT NULL,
	`precioCliente` float(9,2) DEFAULT NULL,
	`proveedor` mediumtext,
	`tabla` int (11) DEFAULT NULL, 
	`ganancia` float(9,2) DEFAULT NULL,

	PRIMARY KEY (`idProducto`)
	
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DELETE FROM `producto`;

INSERT INTO `producto` (`idProducto`,`Uso`,`fechaDeLlegada`,`fechaDeVenta`,`precioProveedor`,`precioCliente`,`proveedor`,`tabla`,`ganancia`) VALUES 
(4,'lavar','2019-04-19 10:34:09.000' ,'2020-04-19 10:34:09.000' ,120.50, 122.22,'nose',10,2.30),
(5,'cocinar','2019-04-19 10:34:09.000' ,'2020-04-19 10:34:09.000' ,30.00, 20.00,'nose',11,10.00);

-- ---- TABLA DE PRODUCTOS Y TRABAJADORES ----

CREATE TABLE IF NOT EXISTS `producto_trabajador`(
	`idProducto` int(11) NOT NULL, 
	`idTrabajador` int(11) NOT NULL,
	
	PRIMARY KEY (`idTrabajador`,`idProducto`),
	KEY `idProducto` (`idProducto`),
	KEY `idTrabajador` (`idTrabajador`),
	CONSTRAINT `producto_trabajdor_ibfk_1` FOREIGN KEY (`idTrabajador`) REFERENCES `trabajador` (`idTrabajador`),
	CONSTRAINT `producto_trabajador_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DELETE FROM `producto_trabajador`;

-- ---- TABLA DE CLIENTES ----

CREATE TABLE IF NOT EXISTS `cliente`(
	`ID` int(11) NOT NULL AUTO_INCREMENT,
	`telefono` int (8) NOT NULL,
	`correo` tinytext, 

	PRIMARY KEY (`ID`)
	
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DELETE FROM `cliente`;

INSERT INTO `cliente` (`ID`,`telefono`,`correo`) VALUES 
(1,50129093,'cliente1@hotmail.com'),
(2,50210939,'cliente2@hotmail.com');

-- ---- TABLA DE VENTAS ----

CREATE TABLE IF NOT EXISTS `venta`(
	`idVenta` int(11) NOT NULL AUTO_INCREMENT, 
	`fechaDeExpedicion` datetime NOT NULL,
	`precioTotal` float(9,2) DEFAULT NULL,
	`idCliente` int(11) NOT NULL,
	`idTrabajador` int(11) NOT NULL,

	PRIMARY KEY (`idVenta`),
	KEY `idCliente` (`idCliente`),
	KEY `idTrabajador` (`idTrabajador`),
	CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`idTrabajador`) REFERENCES `trabajador` (`idTrabajador`),
	CONSTRAINT `venta_ibfk_2` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`ID`)

) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DELETE FROM `venta`;

INSERT INTO `venta` (`idVenta`,`fechaDeExpedicion`,`precioTotal`,`idCliente`,`idTrabajador`) VALUES 
(121,'2019-04-19 10:34:09.000'  ,122.22, 1, 30),
(122,'2019-04-19 10:34:09.000'  ,124.24, 2, 31);

-- ---- TABLA DE PRODUCTOS Y VENTAS ----
CREATE TABLE IF NOT EXISTS `producto_venta`(
	`idProducto` int(11) NOT NULL AUTO_INCREMENT, 
	`idVenta` int(11) NOT NULL,
	`costoTotal` float(9,2) DEFAULT NULL,
	`precioVenta` float(9,2) DEFAULT NULL,
	`cantidad` float(9,2) DEFAULT NULL,
	
	PRIMARY KEY (`idVenta`,`idProducto`),
	KEY `idProducto` (`idProducto`),
	KEY `idVenta` (`idVenta`),
	CONSTRAINT `producto_venta_ibfk_1` FOREIGN KEY (`idVenta`) REFERENCES `venta` (`idVenta`),
	CONSTRAINT `prodcuto_venta_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DELETE FROM `trabajador_proyecto`;
