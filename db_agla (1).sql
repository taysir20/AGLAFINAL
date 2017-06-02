-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-05-2017 a las 09:25:19
-- Versión del servidor: 10.1.19-MariaDB
-- Versión de PHP: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_agla`
--
CREATE DATABASE IF NOT EXISTS `db_agla` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `db_agla`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
CREATE TABLE IF NOT EXISTS `funcionario` (
  `DNI` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `funcionario`
--

INSERT INTO `funcionario` (`DNI`) VALUES
('32456565G'),
('37689365L'),
('37947358R'),
('45687234D'),
('50476695C'),
('60360534S'),
('78674555H'),
('79856745K'),
('89745634B'),
('98745627Z');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `licencia`
--

DROP TABLE IF EXISTS `licencia`;
CREATE TABLE IF NOT EXISTS `licencia` (
  `REF_CATASTRAL` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `TIPO_SUELO` enum('URBANO','RURAL') COLLATE utf8_spanish_ci NOT NULL,
  `EMPLAZAMIENTO` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `ACTIVIDAD` enum('SUELO CALIFICADO COMO INDUSTRIAL','SUELO URBANO NO CALIFICADO COMO INDUSTRIAL','CAJAS DE AHORROS,BANCOS, ENTIDADES FINANCIERAS','SEGUROS, CAJA DE PENSIONES','BARES, CAFETERIAS, RESTAURANTES','SALONES RECREATIVOS Y DE JUEGO','ESTABLECIMIENTOS, SECTOR ALIMENTICIO','HOTELES,HOSTALES Y PENSIONES','TERRAZAS DE VERANO','GASOLINERAS') COLLATE utf8_spanish_ci NOT NULL,
  `MEMORIA_ACTIVIDAD` enum('SI','NO') COLLATE utf8_spanish_ci NOT NULL DEFAULT 'NO',
  `PLANOS_LOCAL` enum('SI','NO') COLLATE utf8_spanish_ci NOT NULL DEFAULT 'NO',
  `FOTOCOPIA_OBRA` enum('SI','NO') COLLATE utf8_spanish_ci NOT NULL DEFAULT 'NO',
  `CERTIFICADO_TECNICO1` enum('SI','NO') COLLATE utf8_spanish_ci NOT NULL DEFAULT 'NO',
  `CERTIFICADO_COLEGIO_OFICIAL2` enum('SI','NO') COLLATE utf8_spanish_ci NOT NULL DEFAULT 'NO',
  `DNI_titular` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `FechaSolicitud` date NOT NULL,
  `FechaInicioActividad` date NOT NULL,
  `EstadoLicencia` enum('EN TRAMITE','DENEGADA','ACEPTADA','') COLLATE utf8_spanish_ci NOT NULL,
  `DescripcionActividad` text COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`REF_CATASTRAL`),
  UNIQUE KEY `REF_CATASTRAL` (`REF_CATASTRAL`),
  UNIQUE KEY `REF_CATASTRAL_2` (`REF_CATASTRAL`),
  KEY `DNI_titular` (`DNI_titular`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `licencia`
--

INSERT INTO `licencia` (`REF_CATASTRAL`, `TIPO_SUELO`, `EMPLAZAMIENTO`, `ACTIVIDAD`, `MEMORIA_ACTIVIDAD`, `PLANOS_LOCAL`, `FOTOCOPIA_OBRA`, `CERTIFICADO_TECNICO1`, `CERTIFICADO_COLEGIO_OFICIAL2`, `DNI_titular`, `FechaSolicitud`, `FechaInicioActividad`, `EstadoLicencia`, `DescripcionActividad`) VALUES
('456982', 'RURAL', 'Calle', 'BARES, CAFETERIAS, RESTAURANTES', 'SI', 'SI', 'SI', 'SI', 'SI', '65789435D', '2017-05-16', '2017-05-18', 'EN TRAMITE', 'Licencia para la apertura de un bar'),
('482568', 'URBANO', 'Avenida', 'TERRAZAS DE VERANO', 'SI', 'SI', 'NO', 'NO', 'SI', '56743567S', '2017-08-17', '2017-01-30', 'EN TRAMITE', 'Terraza de verano exclusivamente para verano'),
('638492', 'RURAL', 'Plaza', 'ESTABLECIMIENTOS, SECTOR ALIMENTICIO', 'NO', 'SI', 'NO', 'NO', 'SI', '65477984F', '2017-05-01', '2017-01-15', 'EN TRAMITE', 'Comercio con licencia en productos alimenticios.'),
('678456', 'URBANO', 'Avenida', 'SALONES RECREATIVOS Y DE JUEGO', 'SI', 'SI', 'SI', 'NO', 'NO', '5678734F', '2017-10-21', '2017-10-14', 'EN TRAMITE', 'Recreativas y juegos variados.'),
('789472', 'URBANO', 'Plaza', 'CAJAS DE AHORROS,BANCOS, ENTIDADES FINANCIERAS', 'SI', 'SI', 'SI', 'SI', 'SI', '56743567S', '2017-05-03', '2017-09-02', 'EN TRAMITE', 'Cajas de ahorros'),
('98765', 'RURAL', 'Plaza', 'GASOLINERAS', 'NO', 'SI', 'SI', 'NO', 'NO', '123', '2017-05-17', '2017-05-27', 'DENEGADA', 'Actividad fraudulenta');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registra`
--

DROP TABLE IF EXISTS `registra`;
CREATE TABLE IF NOT EXISTS `registra` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `DNI_funcionario` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `catastro_Licencia` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `catastro_Licencia` (`catastro_Licencia`),
  KEY `DNI_funcionario` (`DNI_funcionario`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `registra`
--

INSERT INTO `registra` (`id`, `DNI_funcionario`, `catastro_Licencia`) VALUES
(27, '37689365L', '456982'),
(28, '37689365L', '678456'),
(35, '98745627Z', '482568'),
(36, '45687234D', '789472');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `titular`
--

DROP TABLE IF EXISTS `titular`;
CREATE TABLE IF NOT EXISTS `titular` (
  `CIF_NIF_NIE` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `REGISTRO` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `APELLIDOS` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `MUNICIPIO` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `COD_POSTAL` int(5) DEFAULT NULL,
  `DIRECCION` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `TELEFONO_MOVIL` int(22) NOT NULL,
  `TELEFONO_FIJO` int(22) DEFAULT NULL,
  `EMAIL` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `FAX` int(11) NOT NULL,
  `TIPO_SOLICITANTE` enum('FISICA','JURIDICA') COLLATE utf8_spanish_ci NOT NULL,
  `FOTOCOPIA_DNI_CIF_NIE` enum('SI','NO') COLLATE utf8_spanish_ci NOT NULL DEFAULT 'NO',
  `FOTOGRAFIAS` enum('SI','NO') COLLATE utf8_spanish_ci NOT NULL DEFAULT 'NO',
  `FOTOCOPIA_ACTIVIDAD` enum('SI','NO') COLLATE utf8_spanish_ci NOT NULL DEFAULT 'NO',
  `FOTOCOPIA_ESCRITURAS` enum('SI','NO') COLLATE utf8_spanish_ci NOT NULL DEFAULT 'NO',
  `JUSTIFICANTE_PAGO` enum('SI','NO') COLLATE utf8_spanish_ci NOT NULL DEFAULT 'NO',
  `FOTOCOPIA_OTROS` enum('SI','NO') COLLATE utf8_spanish_ci NOT NULL,
  `RAZON_SOCIAL` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`CIF_NIF_NIE`),
  UNIQUE KEY `REGISTRO` (`REGISTRO`)
) ENGINE=InnoDB AUTO_INCREMENT=675439 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `titular`
--

INSERT INTO `titular` (`CIF_NIF_NIE`, `REGISTRO`, `NOMBRE`, `APELLIDOS`, `MUNICIPIO`, `COD_POSTAL`, `DIRECCION`, `TELEFONO_MOVIL`, `TELEFONO_FIJO`, `EMAIL`, `FAX`, `TIPO_SOLICITANTE`, `FOTOCOPIA_DNI_CIF_NIE`, `FOTOGRAFIAS`, `FOTOCOPIA_ACTIVIDAD`, `FOTOCOPIA_ESCRITURAS`, `JUSTIFICANTE_PAGO`, `FOTOCOPIA_OTROS`, `RAZON_SOCIAL`) VALUES
('123', 123, 'ola', 'oli', 'huola', 23456, 'olita', 123456, 9876543, 'uooolee@gmail.com', 1234, '', 'SI', 'NO', 'NO', 'SI', 'NO', 'SI', ''),
('56743567S', 234567, 'Manuel', 'Blanco Suaña', 'Las Matas', 29546, 'Calle Amapolas 13', 678984567, 914568738, 'zamorano000@gmai.com', 980500500, 'FISICA', 'SI', 'SI', 'SI', 'NO', 'SI', 'SI', ''),
('5678734F', 234657, 'María', 'Duarte Espinete', 'Torrijos', 34567, 'Calle Tertulianas Gálvez 6', 657894534, 915678947, 'mde@hotmail.es', 0, 'FISICA', 'NO', 'SI', '', 'NO', 'NO', 'SI', ''),
('65477984F', 675438, 'Alfonso', 'Pérez Garrido', 'Valdemoro', 56798, 'Calle Izquierda 67', 76898745, NULL, 'PerezG@gmail.com', 876, 'FISICA', 'SI', 'SI', 'SI', 'SI', 'SI', 'SI', ''),
('65789435D', 123784, 'Emilia', 'Sanchez Andrede', 'Los Molinos', 34675, 'Avenida Andalucia 32', 657894567, NULL, 'oficinasAndrede@hotmail.com', 0, 'JURIDICA', 'SI', 'SI', 'SI', 'NO', 'SI', 'SI', '');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `licencia`
--
ALTER TABLE `licencia`
  ADD CONSTRAINT `licencia_ibfk_1` FOREIGN KEY (`DNI_titular`) REFERENCES `titular` (`CIF_NIF_NIE`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `registra`
--
ALTER TABLE `registra`
  ADD CONSTRAINT `registra_ibfk_1` FOREIGN KEY (`catastro_Licencia`) REFERENCES `licencia` (`REF_CATASTRAL`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `registra_ibfk_2` FOREIGN KEY (`DNI_funcionario`) REFERENCES `funcionario` (`DNI`) ON DELETE CASCADE ON UPDATE CASCADE;


--
-- Metadatos
--
USE `phpmyadmin`;

--
-- Metadatos para funcionario
--

--
-- Metadatos para licencia
--

--
-- Metadatos para registra
--

--
-- Metadatos para titular
--

--
-- Volcado de datos para la tabla `pma__table_uiprefs`
--

INSERT INTO `pma__table_uiprefs` (`username`, `db_name`, `table_name`, `prefs`, `last_update`) VALUES
('root', 'db_agla', 'titular', '{"sorted_col":"`titular`.`FOTOCOPIA_DNI_CIF_NIE` ASC"}', '2017-05-18 11:53:20');

--
-- Metadatos para db_agla
--

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
