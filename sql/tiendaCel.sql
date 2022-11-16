-- MySQL Script generated by MySQL Workbench
-- Sat Sep 17 22:09:05 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema tiendaCel
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tiendaCel
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tiendaCel` DEFAULT CHARACTER SET utf8 ;
USE `tiendaCel` ;
-- -----------------------------------------------------
-- Table `tiendaCel`.`categorias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tiendaCel`.`categorias` (
  `id_categoria` INT NOT NULL auto_increment,
  `nombre_categoria` VARCHAR(50) NULL,
  PRIMARY KEY (`id_categoria`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `tiendaCel`.`proveedores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tiendaCel`.`proveedores` (
  `id_proveedor` INT NOT NULL auto_increment,
  `nomb_proveedor` VARCHAR(100) NULL,
  `tel_proveedor` VARCHAR(20) NULL,
  PRIMARY KEY (`id_proveedor`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `tiendaCel`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tiendaCel`.`roles` (
  `id_role` INT NOT NULL auto_increment,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id_role`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `tiendaCel`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tiendaCel`.`users` (
  `id_user` INT NOT NULL auto_increment,
  `username` VARCHAR(100) NULL,
  `password` VARCHAR(45) NULL,
  `correo` VARCHAR(75) NULL,
  `id_role` INT NOT NULL,
  PRIMARY KEY (`id_user`),
  CONSTRAINT `id_role`
    FOREIGN KEY (`id_role`)
    REFERENCES `tiendaCel`.`roles` (`id_role`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `tiendaCel`.`factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tiendaCel`.`factura` (
  `id_factura` INT NOT NULL auto_increment,
  `id_user` INT NULL,
  `fecha` DATE NULL,
  PRIMARY KEY (`id_factura`),
  CONSTRAINT `id_user`
    FOREIGN KEY (`id_user`)
    REFERENCES `tiendaCel`.`users` (`id_user`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tiendaCel`.`productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tiendaCel`.`productos` (
  `id_producto` INT NOT NULL auto_increment,
  `id_categoria` INT NULL,
  `id_proveedor` INT NULL,
  `nomb_producto` VARCHAR(75) NULL,
  `precio_unitario` DECIMAL(10,2) NULL,
  PRIMARY KEY (`id_producto`),
  CONSTRAINT `id_categoria`
    FOREIGN KEY (`id_categoria`)
    REFERENCES `tiendaCel`.`categorias` (`id_categoria`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `id_proveedor`
    FOREIGN KEY (`id_proveedor`)
    REFERENCES `tiendaCel`.`proveedores` (`id_proveedor`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tiendaCel`.`detalle_factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tiendaCel`.`detalle_factura` (
  `id_detalle_factura` INT NOT NULL auto_increment,
  `id_factura` INT NULL,
  `id_producto` INT NULL,
  `cantidad_unidades` INT NULL,
  `precio_unitario` DECIMAL(10,2) NULL,
  `total` DECIMAL(10,2) NULL,
  PRIMARY KEY (`id_detalle_factura`),
  CONSTRAINT `id_factura`
    FOREIGN KEY (`id_factura`)
    REFERENCES `tiendaCel`.`factura` (`id_factura`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `id_producto`
    FOREIGN KEY (`id_producto`)
    REFERENCES `tiendaCel`.`productos` (`id_producto`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

use tiendacel;

INSERT INTO `tiendacel`.`roles` (`name`) VALUES
('customer'),
('admin'); 

INSERT INTO `tiendacel`.`users` (`username`,`password`,`correo`,`id_role`) VALUES 
('Carlos123','12345','car@gmail.com',1),
('Juan123','12345','juan@gmail.com',2),
('Ben123','12345','ben@gmail.com',1),
('albert578','12345','albert@gmail.com',1),
('steven457','12345','steven@gmail.com',1),
('karla124','12345','karla@gmail.com',1),
('aby123','12345','aby@gmail.com',1),
('keyla12','12345','key@gmail.com',1),
('pepe784','12345','pepe@gmail.com',1),
('heidi784','12345','heidi@gmail.com',1);
select * from users;

INSERT INTO `tiendacel`.`proveedores` (`nomb_proveedor`,`tel_proveedor`) VALUES
('Huawei','4578-9585'),
('LG','1451-8474'),
('SONY','8695-2541'),
('ZTE','7524-8575'),
('Apple','4578-9636'),
('Xiaomi','2536-8552'),
('Motorola','2585-2535'),
('Blackberry','7585-6335'),
('TCL','5865-8569'),
('Samsung','1425-7458'),
('Honor','8574-8514');
select * from proveedores;

INSERT INTO `tiendacel`.`categorias` (`nombre_categoria`) VALUES
('smartphone'),
('cargador usd'),
('audifonos'),
('soporte'),
('bateria'),
('protector de pantalla'),
('cover'),
('cargador inalambrico'),
('micro sd'),
('tripode');
select * from categorias;

INSERT INTO `tiendacel`.`productos`
(`id_categoria`,`id_proveedor`,`nomb_producto`,`precio_unitario`) VALUES
(1,1,'huawey Y7',150.00),
(1,1,'huawey Y9',250.00),
(1,1,'huawey Y7 LITE',130.00),
(1,2,'LG stylus 3G',115.00),
(1,1,'huawey Y9 LITE',150.00),
(1,3,'Sony Xperia 11',300.00),
(1,4,'ZTE v11 LITE',80.00),
(1,5,'iphone X',800.00),
(1,6,'Xiaomi A9',140.00),
(1,7,'Blackberry 500',70.00);
select * from productos;

INSERT INTO `tiendacel`.`factura`
(`id_user`,`fecha`) VALUES
(3,'2022-7-15'),
(4,'2022-8-12'),
(5,'2022-9-04'),
(6,'2022-5-03'),
(7,'2022-4-02'),
(8,'2022-3-01'),
(9,'2022-4-16'),
(10,'2022-5-20'),
(2,'2022-6-21'),
(3,'2022-7-15');
select * from factura;

INSERT INTO `tiendacel`.`detalle_factura`
(`id_factura`,`id_producto`,`cantidad_unidades`,`precio_unitario`,`total`) VALUES
(1,1,1,150.00,150.00),
(2,2,2,250.00,500.00),
(3,3,1,130.00,130.00),
(4,4,1,115.00,115.00),
(5,5,1,150.00,150.00),
(6,6,3,300.00,900.00),
(7,7,2,80.00,160.00),
(8,8,5,800.00,4000.00),
(9,9,2,140.00,280.00),
(10,10,3,70.00,210.00);
select * from detalle_factura;

/* USERNAMES CON SUS RESPECTIVAS FACTURAS CON DETALLES DE FACTURA EXISTENTES AL 
QUE PERTENECE */
select  users.id_user, users.username, factura.id_factura, 
detalle_factura.id_producto,detalle_factura.cantidad_unidades, detalle_factura.total
from users
inner join factura
on factura.id_user = users.id_user
inner join detalle_factura
on detalle_factura.id_factura = factura.id_factura;

/* DETALLES DE FACTURAS, MOSTRANDO FACTURAS A LAS QUE PERTENECEN MÁS INFO DEL PRODUCTO */
select factura.id_factura,detalle_factura.id_detalle_factura,detalle_factura.id_producto,productos.nomb_producto,
detalle_factura.cantidad_unidades, detalle_factura.total from factura
inner join detalle_factura
on factura.id_factura = detalle_factura.id_factura
inner join productos
on productos.id_producto = detalle_factura.id_producto;

/*DETALLE DE PRODUCTOS MÁS CATEGORÍA MÁS INFO DEL PROVEEDOR DEL PRODUCTO*/
select productos.id_producto, productos.nomb_producto, categorias.nombre_categoria,
proveedores.nomb_proveedor, proveedores.tel_proveedor
from productos
inner join categorias
on productos.id_categoria = categorias.id_categoria
inner join proveedores
on productos.id_proveedor = proveedores.id_proveedor; 



