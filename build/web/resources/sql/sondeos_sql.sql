drop database if exists sondeos;
create database sondeos;
use sondeos;

CREATE TABLE `sondeos`.`ciudadano` 
(`idCiudadano` INT(11) NOT NULL AUTO_INCREMENT , 
`estrato` INT(11) NOT NULL , 
`tipoDoc` VARCHAR(100) NOT NULL , 
`doc` INT(11) NOT NULL , 
`nombres` VARCHAR(100) NOT NULL , 
`apellidos` VARCHAR(100) NOT NULL , 
`sexo` VARCHAR(50) NOT NULL , 
`celular` INT(11) NOT NULL , 
`fijo` INT(11) NOT NULL , 
`correo` VARCHAR(100) NOT NULL , 
`municipio` VARCHAR(150) NOT NULL , 
`direccion` VARCHAR(150) NOT NULL , 
`barrio` VARCHAR(150) NOT NULL , 
`fechaNac` DATE NOT NULL , 
`etnia` VARCHAR(100) NOT NULL , 
`condicion` VARCHAR(100) NOT NULL , 
PRIMARY KEY (`idCiudadano`)) ENGINE = InnoDB;
