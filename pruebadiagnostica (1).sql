-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-11-2021 a las 09:10:56
-- Versión del servidor: 10.4.20-MariaDB
-- Versión de PHP: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pruebadiagnostica`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `Nombre` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`Nombre`) VALUES
('Arte'),
('Deportes'),
('Geografía'),
('Historia'),
('Matemática');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `opciones`
--

CREATE TABLE `opciones` (
  `id` int(11) NOT NULL,
  `descripción` varchar(255) NOT NULL,
  `idPregunta` varchar(255) NOT NULL,
  `Valida` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `opciones`
--

INSERT INTO `opciones` (`id`, `descripción`, `idPregunta`, `Valida`) VALUES
(1, 'Miguel Ángel', '\"La piedad\" es una escultura de...', 1),
(2, 'Pedro', '\"La piedad\" es una escultura de...', 0),
(3, 'Pepito', '\"La piedad\" es una escultura de...', 0),
(4, 'Leo Messi', '\"La piedad\" es una escultura de...', 0),
(5, 'Siglo XV', '¿En que siglo se inició el Renacimiento?', 1),
(6, 'Siglo XX', '¿En que siglo se inició el Renacimiento?', 0),
(7, 'Siglo XIV', '¿En que siglo se inició el Renacimiento?', 0),
(8, 'Siglo XII', '¿En que siglo se inició el Renacimiento?', 0),
(9, 'Siglo XIX', '¿En que siglo nació Van Gogh?', 1),
(10, 'Siglo XX', '¿En que siglo nació Van Gogh?', 0),
(11, 'Siglo XVII', '¿En que siglo nació Van Gogh?', 0),
(12, 'Siglo XVIII', '¿En que siglo nació Van Gogh?', 0),
(13, 'Louvre', '¿En que museo está la Mona Lisa?', 1),
(14, 'Museo de Prado', '¿En que museo está la Mona Lisa?', 0),
(15, 'British Museum', '¿En que museo está la Mona Lisa?', 0),
(16, 'Galería Uffizi', '¿En que museo está la Mona Lisa?', 0),
(17, 'Siglo XVII', '¿En que siglo nació Velázquez?', 1),
(18, 'Siglo XVIII', '¿En que siglo nació Velázquez?', 0),
(19, 'Siglo XV', '¿En que siglo nació Velázquez?', 0),
(20, 'Siglo X', '¿En que siglo nació Velázquez?', 0),
(21, 'Raíz cuadrada de 18', '¿Cuánto vale la hipotenusa de un triangulo rectángulo , sabiendo que sus catetos miden 3cm?', 1),
(22, '4', '¿Cuánto vale la hipotenusa de un triangulo rectángulo , sabiendo que sus catetos miden 3cm?', 0),
(23, '3,5', '¿Cuánto vale la hipotenusa de un triangulo rectángulo , sabiendo que sus catetos miden 3cm?', 0),
(24, '2', '¿Cuánto vale la hipotenusa de un triangulo rectángulo , sabiendo que sus catetos miden 3cm?', 0),
(25, '50', '¿Cuánto es el 25% de 200?', 1),
(26, '25', '¿Cuánto es el 25% de 200?', 0),
(27, '20', '¿Cuánto es el 25% de 200?', 0),
(28, '21', '¿Cuánto es el 25% de 200?', 0),
(29, '10', '¿Cuánto es 2+2x4?', 1),
(30, '16', '¿Cuánto es 2+2x4?', 0),
(31, '12', '¿Cuánto es 2+2x4?', 0),
(32, '11', '¿Cuánto es 2+2x4?', 0),
(33, '2', '¿Cuento es la raíz Cuadrada de 4?', 1),
(34, '4', '¿Cuento es la raíz Cuadrada de 4?', 0),
(35, '1', '¿Cuento es la raíz Cuadrada de 4?', 0),
(36, '3', '¿Cuento es la raíz Cuadrada de 4?', 0),
(37, '4', '¿Cuánto es 2 + 2?', 1),
(38, '8', '¿Cuánto es 2 + 2?', 0),
(39, '2', '¿Cuánto es 2 + 2?', 0),
(40, '3', '¿Cuánto es 2 + 2?', 0),
(41, 'En Grecia', '¿En qué país se ubican las ruinas de Esparta?', 1),
(42, 'En Italia', '¿En qué país se ubican las ruinas de Esparta?', 0),
(43, 'En España', '¿En qué país se ubican las ruinas de Esparta?', 0),
(44, 'En Francia', '¿En qué país se ubican las ruinas de Esparta?', 0),
(45, 'Serbia', '¿Cuál de estos países no tiene acceso al Mar Mediterráneo?', 1),
(46, 'Chipre', '¿Cuál de estos países no tiene acceso al Mar Mediterráneo?', 0),
(47, 'Egipto', '¿Cuál de estos países no tiene acceso al Mar Mediterráneo?', 0),
(48, 'Eslovenia', '¿Cuál de estos países no tiene acceso al Mar Mediterráneo?', 0),
(49, 'En Asia', 'El gran desierto de Gobi se ubica en...', 1),
(50, 'En América Central', 'El gran desierto de Gobi se ubica en...', 0),
(51, 'En África ', 'El gran desierto de Gobi se ubica en...', 0),
(52, 'En Sudamérica', 'El gran desierto de Gobi se ubica en...', 0),
(53, '6', '¿Cuántos continentes hay en la Tierra?', 1),
(54, '5', '¿Cuántos continentes hay en la Tierra?', 0),
(55, '11', '¿Cuántos continentes hay en la Tierra?', 0),
(56, '8', '¿Cuántos continentes hay en la Tierra?', 0),
(57, 'Nilo', '¿Cuál es el rió más largo del mundo?', 1),
(58, 'Amazonas', '¿Cuál es el rió más largo del mundo?', 0),
(59, 'Rio Amarillo', '¿Cuál es el rió más largo del mundo?', 0),
(60, 'Yangtse', '¿Cuál es el rió más largo del mundo?', 0),
(61, 'Francesa', '¿De qué nacionalidad era Juana de Arco?', 1),
(62, 'Inglesa', '¿De qué nacionalidad era Juana de Arco?', 0),
(63, 'Italiana', '¿De qué nacionalidad era Juana de Arco?', 0),
(64, 'Española', '¿De qué nacionalidad era Juana de Arco?', 0),
(65, 'George Washington', '¿Quién fue el primer presidente de los Estados Unidos?', 1),
(66, 'John Adams', '¿Quién fue el primer presidente de los Estados Unidos?', 0),
(67, 'Thomas Jefferson', '¿Quién fue el primer presidente de los Estados Unidos?', 0),
(68, 'Pepito Rodríguez', '¿Quién fue el primer presidente de los Estados Unidos?', 0),
(69, 'En 1492', '¿En qué año descubrió América Cristóbal Colón?', 1),
(70, 'En 1498', '¿En qué año descubrió América Cristóbal Colón?', 0),
(71, 'En 1462', '¿En qué año descubrió América Cristóbal Colón?', 0),
(72, 'En 1945', '¿En qué año descubrió América Cristóbal Colón?', 0),
(73, 'Alemania invadió Polonia', '¿Qué inició la Segunda Guerra Mundial?', 1),
(74, 'El asesinato del archiduque Francisco Fernando', '¿Qué inició la Segunda Guerra Mundial?', 0),
(75, 'Hitler invadió Austria', '¿Qué inició la Segunda Guerra Mundial?', 0),
(76, 'Hitler invadió America', '¿Qué inició la Segunda Guerra Mundial?', 0),
(77, 'Nació en Austria', '¿De qué nacionalidad era Adolf Hitler?', 1),
(78, 'Nació en Polonia', '¿De qué nacionalidad era Adolf Hitler?', 0),
(79, 'Nació en Alemania', '¿De qué nacionalidad era Adolf Hitler?', 0),
(80, 'Nació en Argentina', '¿De qué nacionalidad era Adolf Hitler?', 0),
(81, 'en Suiza', '¿En qué país ganó Alemania su primer Mundial?', 1),
(82, 'en Francia', '¿En qué país ganó Alemania su primer Mundial?', 0),
(83, 'en Argentina', '¿En qué país ganó Alemania su primer Mundial?', 0),
(84, 'en Brasil', '¿En qué país ganó Alemania su primer Mundial?', 0),
(85, 'El 13 de julio de 1930 en Uruguay.', '¿Cuándo se celebró el primer mundial de fútbol?', 1),
(86, 'El 13 de julio de 1960 en Argentina.', '¿Cuándo se celebró el primer mundial de fútbol?', 0),
(87, 'El 13 de julio de 1930 en Brasil.', '¿Cuándo se celebró el primer mundial de fútbol?', 0),
(88, 'El 16 de julio de 1930 en Uruguay.', '¿Cuándo se celebró el primer mundial de fútbol?', 0),
(89, ' Brasil', '¿Qué selección de fútbol ha ganado más Mundiales?', 1),
(90, 'Uruguay', '¿Qué selección de fútbol ha ganado más Mundiales?', 0),
(91, 'Argentina', '¿Qué selección de fútbol ha ganado más Mundiales?', 0),
(92, 'Colombia', '¿Qué selección de fútbol ha ganado más Mundiales?', 0),
(93, 'Leo Messi', '¿Quién es el máximo goleador del FC Barcelona?', 1),
(94, 'Luis Suarez', '¿Quién es el máximo goleador del FC Barcelona?', 0),
(95, 'Ansu Fati', '¿Quién es el máximo goleador del FC Barcelona?', 0),
(96, 'Xavi Hernández', '¿Quién es el máximo goleador del FC Barcelona?', 0),
(97, '90 minutos', '¿Cuánto dura un partido de fútbol? ', 1),
(98, '120 minutos', '¿Cuánto dura un partido de fútbol? ', 0),
(99, '45 minutos', '¿Cuánto dura un partido de fútbol? ', 0),
(100, '20 minutos', '¿Cuánto dura un partido de fútbol? ', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pregunta`
--

CREATE TABLE `pregunta` (
  `id` int(11) NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Nivel` int(11) NOT NULL,
  `categoria` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pregunta`
--

INSERT INTO `pregunta` (`id`, `Nombre`, `Nivel`, `categoria`) VALUES
(25, '\"La piedad\" es una escultura de...', 5, 'Arte'),
(13, 'El gran desierto de Gobi se ubica en...', 3, 'Geografía'),
(14, '¿Cuál de estos países no tiene acceso al Mar Mediterráneo?', 4, 'Geografía'),
(11, '¿Cuál es el rió más largo del mundo?', 1, 'Geografía'),
(4, '¿Cuándo se celebró el primer mundial de fútbol?', 4, 'Deportes'),
(1, '¿Cuánto dura un partido de fútbol? ', 1, 'Deportes'),
(16, '¿Cuánto es 2 + 2?', 1, 'Matemática'),
(18, '¿Cuánto es 2+2x4?', 3, 'Matemática'),
(19, '¿Cuánto es el 25% de 200?', 4, 'Matemática'),
(20, '¿Cuánto vale la hipotenusa de un triangulo rectángulo , sabiendo que sus catetos miden 3cm?', 5, 'Matemática'),
(12, '¿Cuántos continentes hay en la Tierra?', 2, 'Geografía'),
(17, '¿Cuento es la raíz Cuadrada de 4?', 2, 'Matemática'),
(6, '¿De qué nacionalidad era Adolf Hitler?', 1, 'Historia'),
(10, '¿De qué nacionalidad era Juana de Arco?', 5, 'Historia'),
(8, '¿En qué año descubrió América Cristóbal Colón?', 3, 'Historia'),
(22, '¿En que museo está la Mona Lisa?', 2, 'Arte'),
(5, '¿En qué país ganó Alemania su primer Mundial?', 5, 'Deportes'),
(15, '¿En qué país se ubican las ruinas de Esparta?', 5, 'Geografía'),
(23, '¿En que siglo nació Van Gogh?', 3, 'Arte'),
(21, '¿En que siglo nació Velázquez?', 1, 'Arte'),
(24, '¿En que siglo se inició el Renacimiento?', 4, 'Arte'),
(7, '¿Qué inició la Segunda Guerra Mundial?', 2, 'Historia'),
(3, '¿Qué selección de fútbol ha ganado más Mundiales?', 3, 'Deportes'),
(2, '¿Quién es el máximo goleador del FC Barcelona?', 2, 'Deportes'),
(9, '¿Quién fue el primer presidente de los Estados Unidos?', 4, 'Historia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `premio`
--

CREATE TABLE `premio` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ronda`
--

CREATE TABLE `ronda` (
  `nivel` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ronda`
--

INSERT INTO `ronda` (`nivel`) VALUES
(1),
(2),
(3),
(4),
(5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Apellido` varchar(255) NOT NULL,
  `Nickname` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Tipo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `Nombre`, `Apellido`, `Nickname`, `Password`, `Tipo`) VALUES
(10, 'holaa', 'hola', 'h1', '6d16e989de5314f3eff5e0c4a24c2bf0fd7f8fe395e713ac839b325a10c4ed1191d1c972c49471efcaa197275b652464fc19007ea5f3542b798c6295b38a2b31', ''),
(11, 'xd', 'xd', 'xd', '6d16e989de5314f3eff5e0c4a24c2bf0fd7f8fe395e713ac839b325a10c4ed1191d1c972c49471efcaa197275b652464fc19007ea5f3542b798c6295b38a2b31', ''),
(12, 'hola', 'hola', 'hola', 'hola', 'jugador'),
(13, 'xd1', 'xd1', 'xd1', 'a1221bcfd87e62ee10abc6702a22ea81d1e6dd40a5ef248f83659cb470cf59121f82003774ae0d4d5731457e3a3c044f8f8e3ec181727e64a44cb981fcd872bb', 'jugador'),
(14, 'henry', 'ferreira', 'haff', 'b0934413f8197a2ef7a5db4677d6b460e09cbcb2f47994cb320a5ac39cf64afaa828a2abaab053339d47791c031f11162f6a2f4f8ec180fa5bbc15d10b6b5b43', 'jugador'),
(15, 'pablo', 'acland', 'pabser', 'e4b0da8a66b7dd2154d92df97da1c6cea8d421519b0a300df2be329e423f9675e39f6240733a7534df30ade501af974fb267e6e6a2768af68e55a3b47a31bf1b', 'jugador');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`Nombre`);

--
-- Indices de la tabla `opciones`
--
ALTER TABLE `opciones`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idPregunta` (`idPregunta`);

--
-- Indices de la tabla `pregunta`
--
ALTER TABLE `pregunta`
  ADD PRIMARY KEY (`Nombre`) USING BTREE,
  ADD KEY `Nivel` (`Nivel`),
  ADD KEY `categoria` (`categoria`),
  ADD KEY `id` (`id`);

--
-- Indices de la tabla `premio`
--
ALTER TABLE `premio`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `ronda`
--
ALTER TABLE `ronda`
  ADD PRIMARY KEY (`nivel`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `opciones`
--
ALTER TABLE `opciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=106;

--
-- AUTO_INCREMENT de la tabla `pregunta`
--
ALTER TABLE `pregunta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT de la tabla `premio`
--
ALTER TABLE `premio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `opciones`
--
ALTER TABLE `opciones`
  ADD CONSTRAINT `opciones_ibfk_1` FOREIGN KEY (`idPregunta`) REFERENCES `pregunta` (`Nombre`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `pregunta`
--
ALTER TABLE `pregunta`
  ADD CONSTRAINT `pregunta_ibfk_1` FOREIGN KEY (`Nivel`) REFERENCES `ronda` (`nivel`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pregunta_ibfk_2` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`Nombre`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
