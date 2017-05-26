-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-05-2017 a las 00:13:30
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cifrasplastilina`
--
CREATE DATABASE IF NOT EXISTS `cifrasplastilina` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `cifrasplastilina`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `cifrasplastilina`.`usuario` ( `id_usuario` INT(11) NOT NULL ,
`nombre_usuario` VARCHAR(100) NULL ,
`apellido_usuario` VARCHAR(100) NULL ,
`email_usuario` VARCHAR(150) NULL , 
`constrasena_usuario` VARCHAR(20) NULL) ENGINE = InnoDB;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cifra`
--

CREATE TABLE `cifrasplastilina`.`cifra` ( 
`id_cifra` INT(11) NOT NULL  , 
`nombre_construccion` VARCHAR(100) NULL , 
`nivel` INT(11) NULL , 
`valor` INT(25) NULL ) ENGINE = InnoDB;

-- --------------------------------------------------------

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `cifrasplastilina`.`usuario` ADD PRIMARY KEY (`id_usuario`);

-- --------------------------------------------------------

--
-- Indices de la tabla `cifra`
--
ALTER TABLE `cifrasplastilina`.`cifra` ADD PRIMARY KEY (`id_cifra`);

-- --------------------------------------------------------

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `cifrasplastilina`.`usuario`  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT;

-- --------------------------------------------------------

--
-- AUTO_INCREMENT de la tabla `cifra`
--
ALTER TABLE `cifrasplastilina`.`cifra`  MODIFY `id_cifra` int(11) NOT NULL AUTO_INCREMENT;

-- --------------------------------------------------------

--
-- INSERT de la tabla `usuario`
--
INSERT INTO `cifrasplastilina`.`usuario` (`id_usuario`, `nombre_usuario`, `apellido_usuario`, `email_usuario`, `contrasena_usuario`) VALUES
(1, 'Usuario1', 'Apell', 'Usuario1@gmail.com', '12345');

-- --------------------------------------------------------

--
-- INSERT de la tabla `cifra`
--
INSERT INTO `cifrasplastilina`.`cifra` (`id_cifra`, `nombre_construccion`, `nivel`, `valor`) VALUES
(1, 'Hospital', 1, 1297504),
(2, 'Hospital', 2, 1886200),
(3, 'Vivienda Urbana', 1, 56533500),
(4, 'Vivienda Urbana', 2, 80500000),
(5, 'Vivienda Urbana', 3, 105533800);