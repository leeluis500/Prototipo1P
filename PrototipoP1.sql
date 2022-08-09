SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

DROP SCHEMA IF EXISTS `Prototipo1P`;
CREATE SCHEMA IF NOT EXISTS `Prototipo1P` DEFAULT CHARACTER SET utf8 ;
USE `Prototipo1P` ;

-- AREA ADMINISTRATIVA
-- -----------------------------------------------------
-- Table `RepartoBD`.`Modulos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Prototipo1P`.`Modulos`;
CREATE TABLE IF NOT EXISTS `Prototipo1P`.`Modulos` (
  `pkidmodulos` INT NOT NULL,
  `Nommod` VARCHAR(45) NULL DEFAULT NULL,
  `Descmod` VARCHAR(200) NULL DEFAULT NULL,
  `Estmod` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`pkidmodulos`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;
INSERT INTO `Prototipo1P`.`Modulos` VALUES 
('0000', 'administracion', 'modulo relacionado a la administración', '1');
-- -----------------------------------------------------
-- Table `RepartoBD`.`Aplicaciones`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Prototipo1P`.`Aplicaciones`;
CREATE TABLE IF NOT EXISTS `Prototipo1P`.`Aplicaciones` (
  `pkidaplicaciones` INT AUTO_INCREMENT NOT NULL,
  `Nomapp` VARCHAR(50) NOT NULL,
  `Descapp` VARCHAR(100) NOT NULL,
  `Estapp` TINYINT DEFAULT 0 NOT NULL,
  PRIMARY KEY (`pkidaplicaciones`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;
INSERT INTO `Aplicaciones` VALUES 
('0001', 'CONTENEDOR ADMINISTRACIÓN', 'MDI área de administración', '1'),
('0004', 'Mantenimiento de modulos', 'Mantenimiento para el área de administración', '1'),
('0005', 'Mantenimiento de aplicaciones', 'Mantenimiento para el área de administración', '1'),
('0006', 'Mantenimiento de usuarios', 'Mantenimiento para el área de administración', '1'),
('0030', 'Asignacion de usuarios a aplicacion', 'Proceso para el área de administración', '1'),
('0009', 'Mantenimiento de producto', 'Mantenimiento para el área de administración', '1');
-- -----------------------------------------------------
-- Table `RepartoBD`.`Asignacion_Modulo_Aplicacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Prototipo1P`.`Asignacion_Modulo_Aplicacion`;
CREATE TABLE IF NOT EXISTS `Prototipo1P`.`Asignacion_Modulo_Aplicacion` (
  `pkidasignacion` INT AUTO_INCREMENT NOT NULL,
  `fpkidmodulo` INT NOT NULL,
  `fpkidaplicacion` INT NOT NULL, 
  PRIMARY KEY (`pkidasignacion`),
  FOREIGN KEY (`fpkidmodulo`) REFERENCES `Prototipo1P`.`Modulos` (`pkidmodulos`),
  FOREIGN KEY (`fpkidaplicacion`) REFERENCES `Prototipo1P`.`Aplicaciones` (`pkidaplicaciones`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;
-- -----------------------------------------------------
-- Table `RepartoBD`.`Usuarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Prototipo1P`.`Usuarios`;
CREATE TABLE IF NOT EXISTS `Prototipo1P`.`Usuarios` (
  `pkidusuarios` INT AUTO_INCREMENT NOT NULL,
  `Nomuser` VARCHAR(50) NOT NULL,
  `Apelluser` VARCHAR(50) NOT NULL,
  `Username` VARCHAR(20) NOT NULL,
  `Password` VARCHAR(50) NOT NULL,
  `Emailuser` VARCHAR(50) NOT NULL,
  `Ultimacuser` DATETIME NULL DEFAULT NULL,
  `Estuser` TINYINT DEFAULT 0 NOT NULL,
  PRIMARY KEY (`pkidusuarios`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;
INSERT INTO `Usuarios` VALUES 
('1', 'admin', 'admin', 'admin', 'MTIzNDU=', 'esduardo@gmail.com', '2022-07-02 21:00:48', '1'),('2', 'leonel', 'dominguez', 'laionel', 'MTIzNDU=', 'leonel@gmail.com', '2022-07-02 21:00:48', '1'),('3', 'luis', 'lee', 'luisk', 'MTIzNDU=', 'luisg@gmail.com', '2022-07-02 21:00:48', '1');
-- -----------------------------------------------------
-- Table `RepartoBD`.`Usuario_aplicacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Prototipo1P`.`Asignacion_Usuario_aplicacion`;
CREATE TABLE IF NOT EXISTS `Prototipo1P`.`Asignacion_Usuario_aplicacion` (
  `fpkidusuario` INT NOT NULL,
  `fpkidaplicacion` INT NOT NULL,
  `Ingresarua` TINYINT DEFAULT 0 NOT NULL,
  `Consultarua` TINYINT DEFAULT 0 NOT NULL,
  `Modificarua` TINYINT DEFAULT 0 NOT NULL,
  `Eliminarua` TINYINT DEFAULT 0 NOT NULL,
  PRIMARY KEY (`fpkidusuario`, `fpkidaplicacion`),
  FOREIGN KEY (`fpkidaplicacion`) REFERENCES `Prototipo1P`.`Aplicaciones` (`pkidaplicaciones`),
  FOREIGN KEY (`fpkidusuario`) REFERENCES `Prototipo1P`.`Usuarios` (`pkidusuarios`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;
INSERT INTO `Asignacion_Usuario_aplicacion` VALUES 
('1', '0001', '1', '1', '1', '1'),('1', '0004', '1', '1', '1', '1'),('1', '0005', '1', '1', '1', '1'),('1', '0006', '1', '1', '1', '1'),('1', '0030', '1', '1', '1', '1'),('1', '0009', '1', '1', '1', '1');
-- -----------------------------------------------------
-- Table `RepartoBD`.`producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Prototipo1P`.`Producto`;
CREATE TABLE IF NOT EXISTS `Prototipo1P`.`Producto` (
  `pkidproducto` INT AUTO_INCREMENT NOT NULL,
  `nombre` VARCHAR(20) NOT NULL,
  `cantidad` VARCHAR(20) NOT NULL,
  `estado` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`pkidproducto`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;
-- -----------------------------------------------------
-- Table `RepartoBD`.`solicitud`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Prototipo1P`.`solicitud`;
CREATE TABLE IF NOT EXISTS `Prototipo1P`.`solicitud` (
  `pkidcompra` INT AUTO_INCREMENT NOT NULL,
  `fkidproducto` INT NOT NULL,
  `nombre` VARCHAR(20) NOT NULL,
  `cantidad` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`pkidcompra`),
  FOREIGN KEY (`fkidproducto`) REFERENCES `Prototipo1P`.`Producto` (`pkidproducto`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;