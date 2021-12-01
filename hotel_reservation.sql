-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 26 Lis 2021, 10:47
-- Wersja serwera: 10.4.18-MariaDB
-- Wersja PHP: 7.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `hotel_reservation`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `guests`
--

CREATE TABLE `guests` (
  `id_guest` int(11) NOT NULL,
  `id_room` int(11) NOT NULL,
  `firstname` varchar(20) NOT NULL,
  `lastname` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `address` varchar(255) NOT NULL,
  `city` varchar(50) NOT NULL,
  `phone` bigint(9) NOT NULL,
  `card_number` bigint(20) NOT NULL,
  `number_of_days` int(3) NOT NULL,
  `fees` double NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `guests`
--

INSERT INTO `guests` (`id_guest`, `id_room`, `firstname`, `lastname`, `email`, `address`, `city`, `phone`, `card_number`, `number_of_days`, `fees`, `created_at`, `updated_at`) VALUES
(1, 1, 'Patryk', 'Kowalski', 'kowalski@wp.pl', 'Jarosław 37-562', 'Jarosław', 123123456, 123123123123123, 3, 750, '2021-11-26 09:46:09', '2021-11-26 09:46:09'),
(2, 2, 'Jan', 'Kowalski', 'kowalski.jan@wp.pl', 'Jarosław 37-562', 'Jarosław', 123123456, 123123123123123, 4, 100, '2021-11-26 09:46:29', '2021-11-26 09:46:29');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `rooms`
--

CREATE TABLE `rooms` (
  `id_room` int(11) NOT NULL,
  `room_type` varchar(20) NOT NULL,
  `room_capacity` varchar(50) NOT NULL,
  `room_fee` double NOT NULL,
  `is_empty` tinyint(1) NOT NULL DEFAULT 0,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `rooms`
--

INSERT INTO `rooms` (`id_room`, `room_type`, `room_capacity`, `room_fee`, `is_empty`, `created_at`, `updated_at`) VALUES
(1, 'Economy', 'Single', 250, 0, '2021-11-26 09:42:58', '2021-11-26 09:42:58'),
(2, 'Economy', 'Single', 250, 0, '2021-11-26 09:43:09', '2021-11-26 09:43:09'),
(3, 'Normal', 'Single', 250, 0, '2021-11-26 09:43:24', '2021-11-26 09:43:24'),
(4, 'Normal', 'Double', 350, 0, '2021-11-26 09:43:36', '2021-11-26 09:43:36'),
(5, 'Vip', 'Triple', 500, 0, '2021-11-26 09:44:44', '2021-11-26 09:44:44');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `login` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(255) NOT NULL,
  `is_admin` tinyint(1) NOT NULL DEFAULT 0,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `users`
--

INSERT INTO `users` (`id`, `name`, `login`, `email`, `password`, `is_admin`, `created_at`, `updated_at`) VALUES
(1, 'Patryk', 'admin', 'admin@wp.pl', 'admin', 1, '2021-11-26 09:24:04', '2021-11-26 09:24:04'),
(2, 'Karol', 'user', 'user@wp.pl', 'user', 0, '2021-11-26 09:24:04', '2021-11-26 09:24:04');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `guests`
--
ALTER TABLE `guests`
  ADD PRIMARY KEY (`id_guest`),
  ADD KEY `id_room` (`id_room`);

--
-- Indeksy dla tabeli `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`id_room`);

--
-- Indeksy dla tabeli `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `guests`
--
ALTER TABLE `guests`
  MODIFY `id_guest` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT dla tabeli `rooms`
--
ALTER TABLE `rooms`
  MODIFY `id_room` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT dla tabeli `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `guests`
--
ALTER TABLE `guests`
  ADD CONSTRAINT `guests_ibfk_1` FOREIGN KEY (`id_room`) REFERENCES `rooms` (`id_room`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
