-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-04-2021 a las 04:40:43
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sistemapau`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `Nombre` varchar(100) NOT NULL,
  `Edad` int(99) DEFAULT NULL,
  `Telefono` text NOT NULL,
  `Mail` text DEFAULT NULL,
  `DNI` int(11) NOT NULL,
  `FechaInicio` date NOT NULL,
  `Estado` int(2) NOT NULL DEFAULT 1,
  `DiaClase` text DEFAULT NULL,
  `HoraClase` time DEFAULT NULL,
  `Comentarios` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`Nombre`, `Edad`, `Telefono`, `Mail`, `DNI`, `FechaInicio`, `Estado`, `DiaClase`, `HoraClase`, `Comentarios`) VALUES
('PERSONA 1', 19, '1165417450', 'HERNANXDSV@GMAIL.COM', 1, '2021-04-21', 1, NULL, NULL, 'Ninguna'),
('PERSONA 2', 19, '1165417451', 'HERNANXDSV@GMAIL.COM', 2, '2021-04-21', 1, NULL, NULL, 'Ninguna'),
('PERSONA 3', 19, '1165417452', 'HERNANXDSV@GMAIL.COM', 3, '2021-04-21', 1, NULL, NULL, 'Ninguna'),
('PERSONA 4', 19, '1165417453', 'HERNANXDSV@GMAIL.COM', 4, '2021-04-21', 1, NULL, NULL, 'Ninguna'),
('PERSONA 5', 19, '1165417454', 'HERNANXDSV@GMAIL.COM', 5, '2021-04-21', 1, NULL, NULL, 'Ninguna'),
('PERSONA 6', 19, '1165417455', 'HERNANXDSV@GMAIL.COM', 6, '2021-04-21', 1, NULL, NULL, 'Ninguna'),
('PERSONA 7', 19, '1165417456', 'HERNANXDSV@GMAIL.COM', 7, '2021-04-21', 1, NULL, NULL, 'Ninguna'),
('PERSONA 8', 19, '1165417457', 'HERNANXDSV@GMAIL.COM', 8, '2021-04-21', 1, NULL, NULL, 'Ninguna'),
('PERSONA 9', 19, '1165417458', 'HERNANXDSV@GMAIL.COM', 9, '2021-04-21', 1, NULL, NULL, 'Ninguna');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clasegeneral`
--

CREATE TABLE `clasegeneral` (
  `id` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `diasemana` int(11) NOT NULL,
  `hora` time NOT NULL,
  `numeroalumnos` int(11) NOT NULL,
  `observaciones` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clasesemanal`
--

CREATE TABLE `clasesemanal` (
  `ID` int(11) NOT NULL,
  `diasemana` int(11) NOT NULL,
  `hora` time NOT NULL,
  `numeroalumnos` int(11) DEFAULT 0,
  `tematica` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `diasemana`
--

CREATE TABLE `diasemana` (
  `id` int(8) NOT NULL,
  `dia` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `diasemana`
--

INSERT INTO `diasemana` (`id`, `dia`) VALUES
(0, 'Lunes'),
(1, 'Martes'),
(2, 'Miercoles'),
(3, 'Jueves'),
(4, 'Viernes'),
(5, 'Sabado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estados`
--

CREATE TABLE `estados` (
  `ID` int(5) NOT NULL,
  `Estado` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `estados`
--

INSERT INTO `estados` (`ID`, `Estado`) VALUES
(0, 'Inactivo'),
(1, 'Activo');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`DNI`),
  ADD KEY `Estado` (`Estado`);

--
-- Indices de la tabla `clasegeneral`
--
ALTER TABLE `clasegeneral`
  ADD PRIMARY KEY (`id`),
  ADD KEY `diasemana` (`diasemana`);

--
-- Indices de la tabla `clasesemanal`
--
ALTER TABLE `clasesemanal`
  ADD PRIMARY KEY (`diasemana`,`hora`) USING BTREE;

--
-- Indices de la tabla `diasemana`
--
ALTER TABLE `diasemana`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `estados`
--
ALTER TABLE `estados`
  ADD PRIMARY KEY (`ID`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD CONSTRAINT `alumnos_ibfk_1` FOREIGN KEY (`Estado`) REFERENCES `estados` (`ID`);

--
-- Filtros para la tabla `clasegeneral`
--
ALTER TABLE `clasegeneral`
  ADD CONSTRAINT `clasegeneral_ibfk_1` FOREIGN KEY (`diasemana`) REFERENCES `diasemana` (`id`);

--
-- Filtros para la tabla `clasesemanal`
--
ALTER TABLE `clasesemanal`
  ADD CONSTRAINT `clasesemanal_ibfk_1` FOREIGN KEY (`diasemana`) REFERENCES `diasemana` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
