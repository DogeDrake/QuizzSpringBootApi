-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-07-2023 a las 17:08:00
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `quizz`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `answer`
--

CREATE TABLE `answer` (
  `answer_id` int(11) NOT NULL,
  `answer_text` varchar(255) NOT NULL,
  `is_correct` tinyint(1) NOT NULL,
  `question_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `answer`
--

INSERT INTO `answer` (`answer_id`, `answer_text`, `is_correct`, `question_id`) VALUES
(1, '1492', 1, 1),
(2, '1500', 0, 1),
(3, '1521', 0, 1),
(4, '1776', 0, 1),
(5, 'Leonardo da Vinci', 1, 2),
(6, 'Pablo Picasso', 0, 2),
(7, 'Vincent van Gogh', 0, 2),
(8, 'Claude Monet', 0, 2),
(9, 'Amazonas', 1, 3),
(10, 'Nilo', 0, 3),
(11, 'Yangtsé', 0, 3),
(12, 'Misisipi', 0, 3),
(13, 'París', 1, 4),
(14, 'Londres', 0, 4),
(15, 'Roma', 0, 4),
(16, 'Madrid', 0, 4),
(17, 'Oxígeno', 1, 5),
(18, 'Hidrógeno', 0, 5),
(19, 'Carbono', 0, 5),
(20, 'Nitrógeno', 0, 5),
(21, 'George Orwell', 1, 6),
(22, 'Aldous Huxley', 0, 6),
(23, 'Ray Bradbury', 0, 6),
(24, 'Ernest Hemingway', 0, 6),
(25, 'Miguel de Cervantes Saavedra', 1, 7),
(26, 'Gabriel García Márquez', 0, 7),
(27, 'William Shakespeare', 0, 7),
(28, 'Fyodor Dostoyevsky', 0, 7),
(29, 'H2SO4', 1, 8),
(30, 'NaCl', 0, 8),
(31, 'CO2', 0, 8),
(32, 'H2O', 0, 8),
(33, '1917', 1, 9),
(34, '1789', 0, 9),
(35, '1945', 0, 9),
(36, '1871', 0, 9),
(37, 'Oganesón', 1, 10),
(38, 'Uranio', 0, 10),
(39, 'Plutonio', 0, 10),
(40, 'Titanio', 0, 10),
(41, 'Oganesón', 1, 11),
(42, 'Uranio', 0, 11),
(43, 'Plutonio', 0, 11),
(44, 'Titanio', 0, 11),
(45, '(base * altura) / 2', 1, 12),
(46, 'lado1 + lado2 + lado3', 0, 12),
(47, 'base * altura', 0, 12),
(48, 'lado * lado', 0, 12),
(49, 'Isaac Newton', 1, 13),
(50, 'Albert Einstein', 0, 13),
(51, 'Galileo Galilei', 0, 13),
(52, 'Marie Curie', 0, 13),
(53, 'El proceso mediante el cual las plantas convierten la luz solar en energía química', 1, 14),
(54, 'El proceso de respiración de las plantas', 0, 14),
(55, 'El proceso de reproducción de las plantas', 0, 14),
(56, 'El proceso de captación de agua y nutrientes por las plantas', 0, 14),
(57, 'Au', 1, 15),
(58, 'Ag', 0, 15),
(59, 'Fe', 0, 15),
(60, 'Cu', 0, 15),
(61, 'H2O', 1, 16),
(62, 'CO2', 0, 16),
(63, 'NaCl', 0, 16),
(64, 'C6H12O6', 0, 16),
(65, 'Teoría de la evolución por selección natural', 1, 17),
(66, 'Teoría de la relatividad', 0, 17),
(67, 'Teoría cuántica', 0, 17),
(68, 'Teoría de la gravitación universal', 0, 17),
(69, 'Tenis', 1, 18),
(70, 'Fútbol', 0, 18),
(71, 'Baloncesto', 0, 18),
(72, 'Golf', 0, 18),
(73, 'Fútbol americano', 1, 19),
(74, 'Béisbol', 0, 19),
(75, 'Baloncesto', 0, 19),
(76, 'Hockey sobre hielo', 0, 19);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `question`
--

CREATE TABLE `question` (
  `question_id` int(11) NOT NULL,
  `question_text` varchar(255) NOT NULL,
  `quiz_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `question`
--

INSERT INTO `question` (`question_id`, `question_text`, `quiz_id`) VALUES
(1, '¿En qué año se descubrió América?', 1),
(2, '¿Quién pintó la Mona Lisa?', 1),
(3, '¿Cuál es el río más largo del mundo?', 1),
(4, '¿Cuál es la capital de Francia?', 1),
(5, '¿Cuál es el elemento más abundante en la Tierra?', 1),
(6, '¿Quién escribió la obra \"1984\"?', 1),
(7, '¿Cuál es el autor de la novela \"Don Quijote de la Mancha\"?', 1),
(8, '¿Cuál es la fórmula química del ácido sulfúrico?', 1),
(9, '¿En qué año se llevó a cabo la Revolución Rusa?', 1),
(10, '¿Cuál es el elemento más pesado en la tabla periódica?', 1),
(11, '¿Cuál es el elemento más pesado en la tabla periódica?', 1),
(12, '¿Cuál es la fórmula del área de un triángulo?', 2),
(13, '¿Quién descubrió la ley de la gravedad?', 1),
(14, '¿Cuál es el proceso de fotosíntesis?', 3),
(15, '¿Cuál es el símbolo químico del oro?', 3),
(16, '¿Cuál es la fórmula del agua?', 3),
(17, '¿Cuál es la teoría que explica la evolución de las especies?', 3),
(18, '¿En qué deporte se utiliza una raqueta para golpear una pelota?', 4),
(19, '¿Cuál es el deporte más popular en Estados Unidos?', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `quiz`
--

CREATE TABLE `quiz` (
  `quiz_id` int(11) NOT NULL,
  `quiz_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `quiz`
--

INSERT INTO `quiz` (`quiz_id`, `quiz_name`) VALUES
(1, 'Cuestionario de Historia'),
(2, 'Cuestionario de Matemáticas'),
(3, 'Cuestionario de Ciencias'),
(4, 'Cuestionario de Deportes');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `answer`
--
ALTER TABLE `answer`
  ADD PRIMARY KEY (`answer_id`),
  ADD KEY `question_id` (`question_id`);

--
-- Indices de la tabla `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`question_id`),
  ADD KEY `quiz_id` (`quiz_id`);

--
-- Indices de la tabla `quiz`
--
ALTER TABLE `quiz`
  ADD PRIMARY KEY (`quiz_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `answer`
--
ALTER TABLE `answer`
  MODIFY `answer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=77;

--
-- AUTO_INCREMENT de la tabla `question`
--
ALTER TABLE `question`
  MODIFY `question_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de la tabla `quiz`
--
ALTER TABLE `quiz`
  MODIFY `quiz_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `answer`
--
ALTER TABLE `answer`
  ADD CONSTRAINT `answer_ibfk_1` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`);

--
-- Filtros para la tabla `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `question_ibfk_1` FOREIGN KEY (`quiz_id`) REFERENCES `quiz` (`quiz_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
